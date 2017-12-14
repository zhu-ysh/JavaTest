package dao;

import dao.impl.BooksDaoImpl;
import dao.impl.UserBooksDaoImpl;
import dao.impl.UsersDaoImpl;

public class DaoFactory {
	private static UsersDao usersDao ;
	private static BooksDao booksDao ; 
	private static UserBooksDao userBooksDao;
	
	public static UsersDao getUsersDaoInstance(){
		if(null == usersDao){
			usersDao = new UsersDaoImpl();
		}
		return usersDao;
	}
	
	public static BooksDao getBooksDaoInstance(){
		if(null == booksDao){
			booksDao = new BooksDaoImpl();
		}
		return booksDao;
	}
	
	public static UserBooksDao getUserBooksDaoInstance(){
		if(null == userBooksDao){
			userBooksDao = new UserBooksDaoImpl();
		}
		return userBooksDao;
	}
}
