package controller;

import java.util.ArrayList;

import entity.UserBooks;
import entity.Users;
import service.UserBooksService;
import service.impl.UserBooksServiceImpl;

public class UserBooksControllerImpl implements Controller<UserBooks> {

	private UserBooksService userbooksService = new UserBooksServiceImpl();
	@Override
	public boolean save(UserBooks t) {
		return userbooksService.save(t);
	}

	@Override
	public boolean delete(UserBooks t) {
		return userbooksService.delete(t);
	}

	@Override
	public boolean update(UserBooks t) {
		return userbooksService.update(t);
	}

	@Override
	public UserBooks selectById(int id) {
		return userbooksService.selectById(id);
	}

	@Override
	public ArrayList<UserBooks> selectAll() {
		return userbooksService.selectAll();
	}
	
	public ArrayList<Integer> getBookIdsByUser(Users user){
		return userbooksService.getBookIdsByUser(user);
	}
}
