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
	public String[] selectMonthTxt(Users user) {
		// TODO Auto-generated method stub
		return null;
	}
}
