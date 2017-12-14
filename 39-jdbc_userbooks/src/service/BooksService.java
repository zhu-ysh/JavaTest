package service;

import java.util.ArrayList;

import entity.Books;

public interface BooksService extends Service<Books>{
	public ArrayList<Books> getBooksByIds(ArrayList<Integer> ids);
	public ArrayList<Books> page(int per,int page);
	public ArrayList<Books> selectAllLike(String like);
}
