package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BooksControllerImpl;
import controller.Controller;
import controller.UserBooksControllerImpl;
import controller.UsersControllerImpl;
import entity.Books;
import entity.UserBooks;
import entity.Users;

public class UserView {
	private UsersControllerImpl usersController = new UsersControllerImpl();
	private BooksControllerImpl booksController = new BooksControllerImpl();
	private UserBooksControllerImpl userbooksController = new UserBooksControllerImpl();
	private Scanner scanner = new Scanner(System.in);
	private Users loginUser;
	
	public void initView(){
		System.out.println("-----------用户------------");
		System.out.println("          1. 查看所有图书");
		System.out.println("          2. 模糊查询图书");
		System.out.println("          3. 添加图书");
		System.out.println("          4. 删除图书");
		System.out.println("          5. 查看图书");
		System.out.println("          6. 退出");
		System.out.println("-----------------------------");
	}
	 
	//模糊查询
	public void selectAllLike(){
		System.out.println("=========查询所有图书===========");
		System.out.print("请输入要查看的书名:");
		String like = scanner.next();
		ArrayList<Books> bookss = booksController.selectAllLike(like);
		if(null!=bookss && bookss.size()>0){
			System.out.println("ID\t书名\t作者\t状态\t时间");
			for (Books books2 : bookss) {
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
	
	//查询所有书
	public void selectAllBooks(){
		System.out.println("=========查询所有图书===========");
		ArrayList<Books> books = booksController.selectAll();
		int per = 5;
		System.out.println("共有:"+Math.ceil(books.size()*1.0/per)+"页");
		System.out.print("请输入要查看的页数:");
		int page = scanner.nextInt();
		//调用分页查询
		ArrayList<Books> bookss = booksController.page(per, page);
		if(null!=books && books.size()>0){
			System.out.println("ID\t书名\t作者\t状态\t时间");
			for (Books books2 : bookss) {
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
	
	public void addUserBooks(){
		System.out.println("=========添加用户图书===========");
		System.out.print("输入图书ID:");
		int book_id = scanner.nextInt();
		UserBooks ub = new UserBooks();
		Books book = new Books();
		book.setBookId(book_id);
		ub.setBook(book);
		ub.setUser(loginUser);
		if(userbooksController.save(ub)){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}
	
	public void deleteUserBooks(){
		System.out.println("=========删除用户图书===========");
		System.out.print("输入ID:");
		int userbook_id = scanner.nextInt();
		UserBooks ub = new UserBooks();
		ub.setUserbookId(userbook_id);
		if(userbooksController.delete(ub)){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
	
	public void selectAllByUserId(){
		 ArrayList<Integer> ids = userbooksController.getBookIdsByUser(loginUser);
		 ArrayList<Books> books= booksController.getBooksByIds(ids);
		 if(null!=books && books.size()>0){
			System.out.println("ID\t书名\t作者\t状态\t时间");
			for(int i = 0;i<books.size();i++){
				System.out.print(ids.get(i)+"\t");
				System.out.print(books.get(i).getBookName()+"\t");
				System.out.print(books.get(i).getBookAuthor()+"\t");
				System.out.print(books.get(i).getBookStatus()+"\t");
				System.out.println(books.get(i).getBookTime()+"\t");
			}
		}else{
			System.out.println("图书查询失败");
		}
	}
	
	public void login(){
		System.out.println("-----------登录------------");
		System.out.print("用户名:");
		String user_name = scanner.next();
		System.out.print("密码:");
		String user_password= scanner.next();
		Users user = new Users();
		user.setUserName(user_name);
		user.setUserPassword(user_password);
		loginUser = usersController.login(user);
		
		if(null!=loginUser){
			while(true){
				initView();
				System.out.print("输入选项:");
				int choose = scanner.nextInt();
				switch(choose){
				case 1:selectAllBooks();break;
				case 2:selectAllLike();break;
				case 3:addUserBooks();break;
				case 4:deleteUserBooks();break;
				case 5:selectAllByUserId();break;
				case 6:System.out.println("再见！");return;
				default:System.out.println("输入有误，请重新输入");
				}
			}
		}else{
			System.out.println("登录失败");
		}
	}
	
	public static void main(String[] args) {
		UserView uv = new UserView();
		uv.login();
	}
}
