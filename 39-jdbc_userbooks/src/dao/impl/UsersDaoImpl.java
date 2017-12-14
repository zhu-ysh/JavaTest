package dao.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.UsersDao;
import entity.Users;
import util.DBUtil;

public class UsersDaoImpl implements UsersDao{

	private Connection conn = DBUtil.getConnection();
	
	private int getId(){
		try {
			String sql = "select nvl(max(user_id),0)+1 from users";
			PreparedStatement ps = null;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public boolean save(Users t) {
		String sql = "insert into users(user_id,user_name,user_password,user_time) values(?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, getId());
			ps.setString(2, t.getUserName());
			ps.setString(3, t.getUserPassword());
			ps.setTimestamp(4, t.getUserTime());
			int row = ps.executeUpdate();
			
			return row==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			if(null!=ps){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean delete(Users t) {
		String sql = "update users set user_status=1 where user_id=? and user_status=0";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getUserId());
			int row = ps.executeUpdate();
			return row==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			if(null!=ps){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean update(Users t) {
		String sql = "update users set user_name=?,user_password=? where user_id=? and user_status=0";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(3, t.getUserId());
			ps.setString(1, t.getUserName());
			ps.setString(2, t.getUserPassword());
			int row = ps.executeUpdate();
			return row==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			if(null!=ps){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Users selectById(int id) {
		String sql = "select * from users where user_status=0 and user_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				Users user = new Users();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserTime(rs.getTimestamp(4));
				user.setUserStatus(rs.getInt(5));
				return user;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if(null!=rs){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null!=ps){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public ArrayList<Users> selectAll() {
		String sql = "select * from users where user_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Users> users = new ArrayList<Users>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Users user = new Users();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserTime(rs.getTimestamp(4));
				user.setUserStatus(rs.getInt(5));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if(null!=rs){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null!=ps){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Users login(Users user) {
		String sql = "select * from users where user_name=? and user_password=? and user_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				Users user2 = new Users();
				user2.setUserId(rs.getInt(1));
				user2.setUserName(rs.getString(2));
				user2.setUserPassword(rs.getString(3));
				user2.setUserTime(rs.getTimestamp(4));
				user2.setUserStatus(rs.getInt(5));
				return user2;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
