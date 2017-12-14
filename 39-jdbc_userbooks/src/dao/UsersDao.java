package dao;

import entity.Users;

public interface UsersDao extends Dao<Users>{
	//µÇÂ¼
	public Users login(Users user);
}
