package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.*;
import entity.Books;
import entity.UserBooks;
import entity.Users;
import util.DBUtil;
public class UserBooksDaoImpl implements UserBooksDao{

	private Connection conn = DBUtil.getConnection();
	
	private int getId(){
		try {
			String sql = "select nvl(max(userbook_id),0)+1 from userbooks";
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
	public boolean save(UserBooks t) {
		String sql = "insert into userbooks(userbook_id,user_id,book_id) values(?,?,?)";
		PreparedStatement ps =null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, getId());
			ps.setInt(2, t.getUser().getUserId());
			ps.setInt(3, t.getBook().getBookId());
			int row = ps.executeUpdate();
			return row==1?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public boolean delete(UserBooks t) {
		String sql = "update userbooks set userbook_status=1 where userbook_id=? and userbook_status=0";
		PreparedStatement ps =null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getUserbookId());
			int row = ps.executeUpdate();
			return row==1?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public boolean update(UserBooks t) {
		return false;
	}

	@Override
	public UserBooks selectById(int id) {
		String sql = "select userbook_id,user_id,book_id,userbook_status from userbooks where userbook_id=? and userbook_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				UserBooks userbook = new UserBooks();
				userbook.setUserbookId(rs.getInt(1));
				//那到用户id，通过用户id查询用户
				UsersDao usersDao = DaoFactory.getUsersDaoInstance();
				Users user = usersDao.selectById(rs.getInt(2));
				if(null != user){
					userbook.setUser(user);
				}
				BooksDao booksDao = DaoFactory.getBooksDaoInstance();
				Books book = booksDao.selectById(rs.getInt(3));
				if(null != book){
					userbook.setBook(book);
				}
				userbook.setUserbookStatus(rs.getInt(4));
				return userbook;
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
		return null;
	}

	@Override
	public ArrayList<UserBooks> selectAll() {
		String sql = "select userbook_id,user_id,book_id,userbook_status from userbooks where userbook_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserBooks> userbooks = new ArrayList<UserBooks>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
				UserBooks userbook = new UserBooks();
				userbook.setUserbookId(rs.getInt(1));
				//那到用户id，通过用户id查询用户
				UsersDao usersDao = DaoFactory.getUsersDaoInstance();
				Users user = usersDao.selectById(rs.getInt(2));
				if(null != user){
					userbook.setUser(user);
				}
				BooksDao booksDao = DaoFactory.getBooksDaoInstance();
				Books book = booksDao.selectById(rs.getInt(3));
				if(null != book){
					userbook.setBook(book);
				}
				userbook.setUserbookStatus(rs.getInt(4));
				userbooks.add(userbook);
			}
			return userbooks;
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
	public ArrayList<Integer> getBookIdsByUser(Users user) {
		String sql = "select book_id from userbooks where user_id=? and userbook_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				ids.add(id);
			}
			return ids;
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
}
