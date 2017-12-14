package view;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import controller.*;
import entity.Books;
import entity.Users;

public class ManagerView {
	private Controller<Users> usersController = new UsersControllerImpl();
	private Controller<Books> booksController = new BooksControllerImpl();
	private Scanner scanner = new Scanner(System.in);
	
	public void initView(){
		System.out.println("-----------管理员------------");
		System.out.println("          1. 用户管理");
		System.out.println("          2. 图书管理");
		System.out.println("          3. 退出管理");
		System.out.println("-----------------------------");
	}
	
	public void userView(){
		System.out.println("-----------用户管理------------");
		System.out.println("          1. 增加用户");
		System.out.println("          2. 删除用户");
		System.out.println("          3. 修改用户");
		System.out.println("          4. ID查询用户");
		System.out.println("          5. 查询所有用户");
		System.out.println("          6. 返回上一级");
		System.out.println("-----------------------------");
	}
	
	public void bookView(){
		System.out.println("-----------用户管理------------");
		System.out.println("          1. 增加图书");
		System.out.println("          2. 删除图书");
		System.out.println("          3. 修改图书");
		System.out.println("          4. ID查询图书");
		System.out.println("          5. 查询所有图书");
		System.out.println("          6. 返回上一级");
		System.out.println("-----------------------------");
	}
	
	public void addUser(){
		System.out.println("=========添加用户===========");
		
		System.out.print("用户名:");
		String user_name = scanner.next();
		System.out.print("密码:");
		String user_password = scanner.next();
		Timestamp user_time = new Timestamp(new Date().getTime());
		Users user = new Users(0,user_name,user_password,user_time);
		if(usersController.save(user)){
			System.out.println("用户添加成功");
		}else{
			System.out.println("用户添加失败");
		}
	}
	public void deleteUser(){
		System.out.println("=========删除用户===========");
		System.out.print("用户ID:");
		int user_id = scanner.nextInt();
		Users user = new Users();
		user.setUserId(user_id);
		if(usersController.delete(user)){
			System.out.println("用户删除成功");
		}else{
			System.out.println("用户删除失败");
		}
	}
	public void updateUser(){
		System.out.println("=========更新用户===========");
		System.out.print("用户名:");
		String user_name = scanner.next();
		System.out.print("密码:");
		String user_password = scanner.next();
		Timestamp user_time = new Timestamp(new Date().getTime());
		Users user = new Users();
		user.setUserName(user_name);
		user.setUserPassword(user_password);
		user.setUserTime(user_time);
		if(usersController.update(user)){
			System.out.println("用户更新成功");
		}else{
			System.out.println("用户更新失败");
		}
	}
	public void selectByUserId(){
		System.out.println("=========ID查询用户===========");
		System.out.print("用户ID:");
		int user_id = scanner.nextInt();
		Users user = usersController.selectById(user_id);
		if(null!=user){
			System.out.println("ID\t姓名\t密码\t状态\t时间");
			System.out.print(user.getUserId()+"\t");
			System.out.print(user.getUserName()+"\t");
			System.out.print(user.getUserPassword()+"\t");
			System.out.print(user.getUserStatus()+"\t");
			System.out.print(user.getUserTime()+"\t");
		}else{
			System.out.println("用户查询失败");
		}
	}
	public void seleteUserAll(){
		System.out.println("=========查询所有用户===========");
		ArrayList<Users> users = usersController.selectAll();
		if(null!=users && users.size()>0){
			System.out.println("ID\t姓名\t密码\t状态\t时间");
			for (Users users2 : users) {
				System.out.print(users2.getUserId()+"\t");
				System.out.print(users2.getUserName()+"\t");
				System.out.print(users2.getUserPassword()+"\t");
				System.out.print(users2.getUserStatus()+"\t");
				System.out.println(users2.getUserTime()+"\t");
			}
		}else{
			System.out.println("用户查询失败");
		}
	}
	public void addBook(){
		System.out.println("=========添加图书===========");
		System.out.print("图书名:");
		String book_name = scanner.next();
		System.out.print("作者名:");
		String book_author = scanner.next();
		Timestamp book_time = new Timestamp(new Date().getTime());
		Books book = new Books();
		book.setBookName(book_name);
		book.setBookAuthor(book_author);
		book.setBookTime(book_time);
		if(booksController.save(book)){
			System.out.println("图书添加成功");
		}else{
			System.out.println("图书添加失败");
		}
	}
	public void deleteBook(){
		System.out.println("=========删除图书===========");
		System.out.print("图书ID:");
		int book_id = scanner.nextInt();
		Books book = new Books();
		book.setBookId(book_id);
		if(booksController.delete(book)){
			System.out.println("图书删除成功");
		}else{
			System.out.println("图书删除失败");
		}
	}
	public void updateBook(){
		System.out.println("=========更新图书===========");
		System.out.print("图书ID:");
		int book_id = scanner.nextInt();
		System.out.print("图书名:");
		String book_name = scanner.next();
		System.out.print("作者名:");
		String book_author = scanner.next();
		Timestamp book_time = new Timestamp(new Date().getTime());
		Books book = new Books(book_id,book_name,book_author,book_time);
		if(booksController.update(book)){
			System.out.println("图书更新成功");
		}else{
			System.out.println("图书更新失败");
		}
	}
	
	public void selectByBookId(){
		System.out.println("=========ID查询图书===========");
		System.out.print("图书ID:");
		int book_id = scanner.nextInt();
		Books book = booksController.selectById(book_id);
		if(null!=book){
			System.out.println("ID\t书名\t作者\t状态\t时间");
			System.out.print(book.getBookId()+"\t");
			System.out.print(book.getBookName()+"\t");
			System.out.print(book.getBookAuthor()+"\t");
			System.out.print(book.getBookStatus()+"\t");
			System.out.print(book.getBookTime()+"\t");
		}else{
			System.out.println("图书查询失败");
		}
	}
	
	public void seleteBookAll(){
		System.out.println("=========查询所有图书===========");
		ArrayList<Books> books = booksController.selectAll();
		if(null!=books && books.size()>0){
			System.out.println("ID\t书名\t作者\t状态\t时间");
			for (Books books2 : books) {
				System.out.print(books2.getBookId()+"\t");
				System.out.print(books2.getBookName()+"\t");
				System.out.print(books2.getBookAuthor()+"\t");
				System.out.print(books2.getBookStatus()+"\t");
				System.out.println(books2.getBookTime()+"\t");
			}
		}else{
			System.out.println("图书查询失败");
		}
	}
	
	public static void main(String[] args) {
		ManagerView mv = new ManagerView();
		while(true){
			mv.initView();
			System.out.println("请输入选项");
			int choose = mv.scanner.nextInt();
			switch(choose){
			case 1:
				label1:
				while(true){
					mv.userView();
					System.out.println("请输入选项");
					int choose2 = mv.scanner.nextInt();
					switch(choose2){
					case 1:mv.addUser();break;
					case 2:mv.deleteUser();break;
					case 3:mv.updateUser();break;
					case 4:mv.selectByUserId();break;
					case 5:mv.seleteUserAll();break;
					case 6:break label1;
					default:System.out.println("输入有误，请重新输入");
					}
				}
				
				break;
			case 2:
				label2:
					while(true){
						mv.bookView();
						System.out.println("请输入选项");
						int choose3 = mv.scanner.nextInt();
						switch(choose3){
						case 1:mv.addBook();break;
						case 2:mv.deleteBook();break;
						case 3:mv.updateBook();break;
						case 4:mv.selectByBookId();break;
						case 5:mv.seleteBookAll();break;
						case 6:break label2;
						default:System.out.println("输入有误，请重新输入");
						}
					}
				break;
			case 3:System.out.println("再见!");return;
			default:System.out.println("输入有误，请重新输入");
			}
		}
	}
}
