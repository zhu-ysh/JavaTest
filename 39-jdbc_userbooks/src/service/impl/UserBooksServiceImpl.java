package service.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.UserBooksDao;
import entity.UserBooks;
import entity.Users;
import service.UserBooksService;

public class UserBooksServiceImpl implements UserBooksService{

	private UserBooksDao userBooksDao = DaoFactory.getUserBooksDaoInstance();
	@Override
	public boolean save(UserBooks t) {
		return userBooksDao.save(t);
	}

	@Override
	public boolean delete(UserBooks t) {
		return userBooksDao.delete(t);
	}

	@Override
	public boolean update(UserBooks t) {
		return userBooksDao.update(t);
	}

	@Override
	public UserBooks selectById(int id) {
		return userBooksDao.selectById(id);
	}

	@Override
	public ArrayList<UserBooks> selectAll() {
		return userBooksDao.selectAll();
	}

	@Override
	public ArrayList<Integer> getBookIdsByUser(Users user) {
		return userBooksDao.getBookIdsByUser(user);
	}
}
