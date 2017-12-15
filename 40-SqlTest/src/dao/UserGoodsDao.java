package dao;

import java.util.ArrayList;

import entity.UserGoods;
import entity.Users;

public interface UserGoodsDao extends Dao<UserGoods> {
	public ArrayList<UserGoods> selectUserBuyGoods(Users user);
}
