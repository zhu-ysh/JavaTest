package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.GoodsDao;
import entity.Goods;
import util.DBUtil;

public class GoodsDaoImpl implements GoodsDao {
	
	private Connection conn = DBUtil.getConnection();
	
	@Override
	public boolean save(Goods t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Goods t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Goods t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Goods selectById(int id) {
		String sql = "select goods_name from goods where goods_id=? and goods_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				Goods goods = new Goods();
				goods.setGoodsName(rs.getString(1));
				return goods;
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
	public ArrayList<Goods> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
