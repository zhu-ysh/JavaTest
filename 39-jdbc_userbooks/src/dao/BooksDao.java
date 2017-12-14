package dao;

import java.util.ArrayList;

import entity.Books;

public interface BooksDao extends Dao<Books>{
	public ArrayList<Books> getBooksByIds(ArrayList<Integer> ids);
	public ArrayList<Books> page(int per,int page);
	public ArrayList<Books> selectAllLike(String like);
}
