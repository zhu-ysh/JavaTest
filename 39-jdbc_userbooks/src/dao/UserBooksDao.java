package dao;
import java.util.ArrayList;

import entity.*;

public interface UserBooksDao extends Dao<UserBooks>{
	//ͨ���û�id�����������id����
	public ArrayList<Integer> getBookIdsByUser(Users user);
}
