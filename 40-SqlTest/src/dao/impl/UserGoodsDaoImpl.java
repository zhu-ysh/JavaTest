package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import dao.UserGoodsDao;
import entity.Goods;
import entity.UserGoods;
import entity.Users;
import util.DBUtil;

public class UserGoodsDaoImpl implements UserGoodsDao{
	private Connection conn = DBUtil.getConnection();
	
	@Override
	public boolean save(UserGoods t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserGoods t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserGoods t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserGoods selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserGoods> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserGoods> selectUserBuyGoods(Users user) {
		String sql = "select usergoods_id,goods_id,usergoods_settime,goods_count,goods_buy_price "
				+ "from usergoods "
				+ "where user_id = ? "
				+ "and usergoods_status = 0 "
				+ "order by usergoods_settime desc";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			rs = ps.executeQuery();
			ArrayList<UserGoods> uGoodss = new ArrayList<UserGoods>(); 
			while(rs.next()){
				UserGoods userGoods = new UserGoods();
				userGoods.setUserGoodsId(rs.getInt(1));
				userGoods.setGoodsId(rs.getInt(2));
				userGoods.setUserGoodsSetTime(rs.getTimestamp(3));
				userGoods.setGoodsCount(rs.getInt(4));
				userGoods.setGoods_buy_price(rs.getDouble(5));
				uGoodss.add(userGoods);
			}	
			return uGoodss;
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
	public ArrayList<UserGoods> selectUserTimeBuyGoods(Users user, Timestamp t1, Timestamp t2) {
		String sql = "select usergoods_id,goods_id,usergoods_settime,goods_count,goods_buy_price "
				+ "from usergoods "
				+ "where user_id = ? "
				+ "and usergoods_status = 0 "
				+ "and usergoods_settime between ? and ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setTimestamp(2, t1);
			ps.setTimestamp(3, t2);
			rs = ps.executeQuery();
			ArrayList<UserGoods> uGoodss = new ArrayList<UserGoods>(); 
			while(rs.next()){
				UserGoods userGoods = new UserGoods();
				userGoods.setUserGoodsId(rs.getInt(1));
				userGoods.setGoodsId(rs.getInt(2));
				userGoods.setUserGoodsSetTime(rs.getTimestamp(3));
				userGoods.setGoodsCount(rs.getInt(4));
				userGoods.setGoods_buy_price(rs.getDouble(5));
				uGoodss.add(userGoods);
			}	
			return uGoodss;
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
	public int selectMonthTxt(Users user) {
		String sql = "select sum(goods_buy_price*goods_count),sum(goods_count),to_char(usergoods_settime,'YYYY-MM')\r\n" + 
				"from userGoods\r\n" + 
				"where user_id = ?\r\n" + 
				"group by to_char(usergoods_settime,'YYYY-MM')";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			rs = ps.executeQuery();
			while(rs.next()){
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		
		return i;
	}

	@Override
	public ArrayList<String> selectMonthTxt(Users user, int p, int num) {
		String sql = "select * from \r\n" + 
				"(select sum(goods_buy_price*goods_count),sum(goods_count),to_char(usergoods_settime,'YYYY-MM')\r\n" + 
				"from userGoods\r\n" + 
				"where user_id = ?\r\n" + 
				"and usergoods_status = 0\r\n" + 
				"group by to_char(usergoods_settime,'YYYY-MM'))\r\n" + 
				"where rownum between ?*?-(?-1) and ?*?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> arr = new ArrayList<String>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setInt(2, num);
			ps.setInt(3, p);
			ps.setInt(4, num);
			ps.setInt(5, num);
			ps.setInt(6, p);
			rs = ps.executeQuery();
			while(rs.next()){
				arr.add(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"ÔÂ");
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
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

	
	
	
	
	
	/*select 
	ug.usergoods_id,t.goods_id,a,ug.goods_buy_price,ug.usergoods_settime
	from (
	select goods_id,avg(goods_buy_price) a
	from userGoods
	where user_id = 2
	and usergoods_status = 0
	group by goods_id ) t,userGoods ug
	where t.goods_id = ug.goods_id
	and ug.user_id = 2
	and ug.usergoods_status = 0
	and ug.goods_buy_price > t.a*/
	
	@Override
	public int upAvgPirceGoods(Users user) {
		String sql = "select goods_id\r\n" + 
				"from usergoods\r\n" + 
				"where user_id = ?\r\n" + 
				"and usergoods_status = 0\r\n" + 
				"and goods_buy_price >(\r\n" + 
				"select ceil(sum(goods_buy_price*goods_count)/sum(goods_count))\r\n" + 
				"from usergoods\r\n" + 
				"where user_id = ?\r\n" + 
				"and usergoods_status = 0\r\n" + 
				")";
		PreparedStatement ps = null;	
		ResultSet rs = null;
		int i = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setInt(2, user.getUserId());
			rs = ps.executeQuery();
			while(rs.next()){
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return i;
	}

	@Override
	public ArrayList<UserGoods> upAvgPirceGoods(Users user, int p, int num) {
		String sql = "select * from\r\n" + 
				"(select goods_id\r\n" + 
				"from usergoods\r\n" + 
				"where user_id = ?\r\n" + 
				"and usergoods_status = 0\r\n" + 
				"and goods_buy_price >(\r\n" + 
				"select ceil(sum(goods_buy_price*goods_count)/sum(goods_count))\r\n" + 
				"from usergoods\r\n" + 
				"where user_id = ?\r\n" + 
				"and usergoods_status = 0))\r\n" + 
				"where rownum between ?*?-(?-1) and ?*?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserGoods> arr = new ArrayList<UserGoods>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setInt(2, user.getUserId());
			ps.setInt(3, num);
			ps.setInt(4, p);
			ps.setInt(5, num);
			ps.setInt(6, num);
			ps.setInt(7, p);
			rs = ps.executeQuery();
			while(rs.next()){
				UserGoods ug = new UserGoods();
				ug.setGoodsId(rs.getInt(1));
				arr.add(ug);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
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
