package dao;
import java.util.ArrayList;

import entity.*;

public interface UserBooksDao extends Dao<UserBooks>{
	//通过用户id返回所有书的id集合
	public ArrayList<Integer> getBookIdsByUser(Users user);
}
