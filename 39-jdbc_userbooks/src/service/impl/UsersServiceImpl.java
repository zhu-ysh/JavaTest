package service.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.UsersDao;
import entity.Users;
import service.UsersService;

public class UsersServiceImpl implements UsersService{

	private UsersDao usersDao = DaoFactory.getUsersDaoInstance();
	
	@Override
	public boolean save(Users t) {
		return usersDao.save(t);
	}

	@Override
	public boolean delete(Users t) {
		return usersDao.delete(t);
	}

	@Override
	public boolean update(Users t) {
		return usersDao.update(t);
	}

	@Override
	public Users selectById(int id) {
		return usersDao.selectById(id);
	}

	@Override
	public ArrayList<Users> selectAll() {
		return usersDao.selectAll();
	}

	@Override
	public Users login(Users user) {
		return usersDao.login(user);
	}
}
