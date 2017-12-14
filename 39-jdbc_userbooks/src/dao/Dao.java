package dao;
import java.util.*;

public interface Dao<T> {
	public boolean save(T t);
	public boolean delete(T t);
	public boolean update(T t);
	public T selectById(int id);
	public ArrayList<T> selectAll();
}
