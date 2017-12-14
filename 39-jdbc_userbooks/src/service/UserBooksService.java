package service;

import java.util.ArrayList;

import entity.UserBooks;
import entity.Users;

public interface UserBooksService extends Service<UserBooks>{
	public ArrayList<Integer> getBookIdsByUser(Users user);
}
