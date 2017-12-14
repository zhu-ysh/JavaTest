package controller;

import java.util.ArrayList;

import entity.Users;
import service.UsersService;
import service.impl.UsersServiceImpl;

public class UsersControllerImpl implements Controller<Users>{

	private UsersService usersService = new UsersServiceImpl();
	
	@Override
	public boolean save(Users t) {
		return usersService.save(t);
	}

	@Override
	public boolean delete(Users t) {
		return usersService.delete(t);
	}

	@Override
	public boolean update(Users t) {
		return usersService.update(t);
	}

	@Override
	public Users selectById(int id) {
		return usersService.selectById(id);
	}

	@Override
	public ArrayList<Users> selectAll() {
		return usersService.selectAll();
	}
	
	public Users login(Users user){
		return usersService.login(user);
	}
}
