package controller;

import java.util.ArrayList;

import entity.Books;
import service.BooksService;
import service.impl.BooksServiceImpl;

public class BooksControllerImpl implements Controller<Books>{

	private BooksService booksService = new BooksServiceImpl();
	@Override
	public boolean save(Books t) {
		return booksService.save(t);
	}

	@Override
	public boolean delete(Books t) {
		return booksService.delete(t);
	}

	@Override
	public boolean update(Books t) {
		return booksService.update(t);
	}

	@Override
	public Books selectById(int id) {
		return booksService.selectById(id);
	}

	@Override
	public ArrayList<Books> selectAll() {
		return booksService.selectAll();
	}
	
	public ArrayList<Books> getBooksByIds(ArrayList<Integer> ids){
		return booksService.getBooksByIds(ids);
	}
	
	public ArrayList<Books> page(int per,int page){
		return booksService.page(per, page);
	}
	
	public ArrayList<Books> selectAllLike(String like){
		return booksService.selectAllLike(like);
	}
}
