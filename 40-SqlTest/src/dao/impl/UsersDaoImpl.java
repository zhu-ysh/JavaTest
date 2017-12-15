package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import dao.UsersDao;
import entity.Users;
import util.DBUtil;

public class UsersDaoImpl implements UsersDao {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Users t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Users t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Users> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	//зЂВс
	@Override
	public int save(String name, String pwd) {
		String sql = "insert into users values(?,?,?,sysdate,sysdate,0)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			int id = getId();
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3, pwd);
			int row = ps.executeUpdate();
			return row == 1? id:0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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
	public Users login(int userId, String pwd) {
		String sql = "select * from users where user_id=? and user_password=? and user_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()){
				Users user2 = new Users();
				user2.setUserId(rs.getInt(1));
				user2.setUserName(rs.getString(2));
				user2.setUserPassWord(rs.getString(3));
				user2.setUserSetTime(rs.getTimestamp(4));
				user2.setUserUpDateTime(rs.getTimestamp(5));
				user2.setUserStatus(rs.getInt(6));
				return user2;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(null != rs){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null != ps){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
