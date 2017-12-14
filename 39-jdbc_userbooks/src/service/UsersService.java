package service;

import entity.Users;

public interface UsersService extends Service<Users> {
	public Users login(Users user);
}
