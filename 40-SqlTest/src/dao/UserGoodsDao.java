package dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import entity.UserGoods;
import entity.Users;

public interface UserGoodsDao extends Dao<UserGoods> {
	public ArrayList<UserGoods> selectUserBuyGoods(Users user);
	public ArrayList<UserGoods> selectUserTimeBuyGoods(Users user,Timestamp t1,Timestamp t2);
	
	public int selectMonthTxt(Users user);
	public ArrayList<String> selectMonthTxt(Users user,int p,int num);
	
	public int upAvgPirceGoods(Users user);
	public ArrayList<UserGoods> upAvgPirceGoods(Users user,int p,int num);
}
