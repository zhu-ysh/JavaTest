package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BooksDao;
import entity.Books;
import util.DBUtil;

public class BooksDaoImpl implements BooksDao{

	private Connection conn = DBUtil.getConnection();
	
	private int getId(){
		try {
			String sql = "select nvl(max(book_id),0)+1 from books";
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
	public boolean save(Books t) {
		String sql = "insert into books(book_id,book_name,book_author,book_time) values(?,?,?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, getId());
			ps.setString(2, t.getBookName());
			ps.setString(3, t.getBookAuthor());
			ps.setTimestamp(4, t.getBookTime());
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
	public boolean delete(Books t) {
		String sql = "update books set book_status=1 where book_id=? and book_status=0";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getBookId());
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
	public boolean update(Books t) {
		String sql = "update books set book_name=?,book_author=? where book_id=? and book_status=0";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(3, t.getBookId());
			ps.setString(1, t.getBookName());
			ps.setString(2, t.getBookAuthor());
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
	public Books selectById(int id) {
		String sql = "select * from books where book_id=? and book_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAuthor(rs.getString(3));
				book.setBookTime(rs.getTimestamp(4));
				book.setBookStatus(rs.getInt(5));
				return book;
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
	public ArrayList<Books> selectAll() {
		String sql = "select * from books where book_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Books> books = new ArrayList<Books>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAuthor(rs.getString(3));
				book.setBookTime(rs.getTimestamp(4));
				book.setBookStatus(rs.getInt(5));
				books.add(book);
			}
			return books;
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
	public ArrayList<Books> getBooksByIds(ArrayList<Integer> ids) {
		ArrayList<Books> books = new ArrayList<Books>();
		for (Integer id : ids) {
			Books book = selectById(id);
			books.add(book);
		}
		return books;
	}

	@Override
	public ArrayList<Books> page(int per, int page) {
		String sql = "select * from (select t.book_id,t.book_name,t.book_author,book_time,book_status from (select rownum r,books.* from books where book_status=0)t where t.r >= ?*?-(?-1)) where rownum <=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Books> books = new ArrayList<Books>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, per);
			ps.setInt(2, page);
			ps.setInt(3, per);
			ps.setInt(4, per);
			rs = ps.executeQuery();
			while(rs.next()){
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAuthor(rs.getString(3));
				book.setBookTime(rs.getTimestamp(4));
				book.setBookStatus(rs.getInt(5));
				books.add(book);
			}
			return books;
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
	public ArrayList<Books> selectAllLike(String like) {
		String sql = "select * from books where book_status=0 and book_name like '%"+like+"%'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Books> books = new ArrayList<Books>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAuthor(rs.getString(3));
				book.setBookTime(rs.getTimestamp(4));
				book.setBookStatus(rs.getInt(5));
				books.add(book);
			}
			return books;
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
