package dao;

import entity.Users;

public interface UsersDao extends Dao<Users>{
	//��¼
	public Users login(Users user);
}
