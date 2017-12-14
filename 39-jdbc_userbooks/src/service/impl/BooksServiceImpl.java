package service.impl;

import java.util.ArrayList;

import dao.BooksDao;
import dao.DaoFactory;
import entity.Books;
import service.BooksService;

public class BooksServiceImpl implements BooksService{

	private BooksDao booksDao = DaoFactory.getBooksDaoInstance();
	@Override
	public boolean save(Books t) {
		return booksDao.save(t);
	}

	@Override
	public boolean delete(Books t) {
		return booksDao.delete(t);
	}

	@Override
	public boolean update(Books t) {
		return booksDao.update(t);
	}

	@Override
	public Books selectById(int id) {
		return booksDao.selectById(id);
	}

	@Override
	public ArrayList<Books> selectAll() {
		return booksDao.selectAll();
	}

	@Override
	public ArrayList<Books> getBooksByIds(ArrayList<Integer> ids) {
		return booksDao.getBooksByIds(ids);
	}

	@Override
	public ArrayList<Books> page(int per, int page) {
		return booksDao.page(per, page);
	}

	@Override
	public ArrayList<Books> selectAllLike(String like) {
		return booksDao.selectAllLike(like);
	}
}
