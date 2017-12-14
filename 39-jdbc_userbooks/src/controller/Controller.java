package controller;

import java.util.ArrayList;

public interface Controller<T> {
	public boolean save(T t);
	public boolean delete(T t);
	public boolean update(T t);
	public T selectById(int id);
	public ArrayList<T> selectAll();
}
