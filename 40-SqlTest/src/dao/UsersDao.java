package dao;

import entity.Users;

public interface UsersDao extends Dao<Users> {
	public int save(String name,String pwd);
	public Users login(int userId,String pwd);
}
