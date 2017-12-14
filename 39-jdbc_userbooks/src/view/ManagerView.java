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
		System.out.println("-----------����Ա------------");
		System.out.println("          1. �û�����");
		System.out.println("          2. ͼ�����");
		System.out.println("          3. �˳�����");
		System.out.println("-----------------------------");
	}
	
	public void userView(){
		System.out.println("-----------�û�����------------");
		System.out.println("          1. �����û�");
		System.out.println("          2. ɾ���û�");
		System.out.println("          3. �޸��û�");
		System.out.println("          4. ID��ѯ�û�");
		System.out.println("          5. ��ѯ�����û�");
		System.out.println("          6. ������һ��");
		System.out.println("-----------------------------");
	}
	
	public void bookView(){
		System.out.println("-----------�û�����------------");
		System.out.println("          1. ����ͼ��");
		System.out.println("          2. ɾ��ͼ��");
		System.out.println("          3. �޸�ͼ��");
		System.out.println("          4. ID��ѯͼ��");
		System.out.println("          5. ��ѯ����ͼ��");
		System.out.println("          6. ������һ��");
		System.out.println("-----------------------------");
	}
	
	public void addUser(){
		System.out.println("=========����û�===========");
		
		System.out.print("�û���:");
		String user_name = scanner.next();
		System.out.print("����:");
		String user_password = scanner.next();
		Timestamp user_time = new Timestamp(new Date().getTime());
		Users user = new Users(0,user_name,user_password,user_time);
		if(usersController.save(user)){
			System.out.println("�û���ӳɹ�");
		}else{
			System.out.println("�û����ʧ��");
		}
	}
	public void deleteUser(){
		System.out.println("=========ɾ���û�===========");
		System.out.print("�û�ID:");
		int user_id = scanner.nextInt();
		Users user = new Users();
		user.setUserId(user_id);
		if(usersController.delete(user)){
			System.out.println("�û�ɾ���ɹ�");
		}else{
			System.out.println("�û�ɾ��ʧ��");
		}
	}
	public void updateUser(){
		System.out.println("=========�����û�===========");
		System.out.print("�û���:");
		String user_name = scanner.next();
		System.out.print("����:");
		String user_password = scanner.next();
		Timestamp user_time = new Timestamp(new Date().getTime());
		Users user = new Users();
		user.setUserName(user_name);
		user.setUserPassword(user_password);
		user.setUserTime(user_time);
		if(usersController.update(user)){
			System.out.println("�û����³ɹ�");
		}else{
			System.out.println("�û�����ʧ��");
		}
	}
	public void selectByUserId(){
		System.out.println("=========ID��ѯ�û�===========");
		System.out.print("�û�ID:");
		int user_id = scanner.nextInt();
		Users user = usersController.selectById(user_id);
		if(null!=user){
			System.out.println("ID\t����\t����\t״̬\tʱ��");
			System.out.print(user.getUserId()+"\t");
			System.out.print(user.getUserName()+"\t");
			System.out.print(user.getUserPassword()+"\t");
			System.out.print(user.getUserStatus()+"\t");
			System.out.print(user.getUserTime()+"\t");
		}else{
			System.out.println("�û���ѯʧ��");
		}
	}
	public void seleteUserAll(){
		System.out.println("=========��ѯ�����û�===========");
		ArrayList<Users> users = usersController.selectAll();
		if(null!=users && users.size()>0){
			System.out.println("ID\t����\t����\t״̬\tʱ��");
			for (Users users2 : users) {
				System.out.print(users2.getUserId()+"\t");
				System.out.print(users2.getUserName()+"\t");
				System.out.print(users2.getUserPassword()+"\t");
				System.out.print(users2.getUserStatus()+"\t");
				System.out.println(users2.getUserTime()+"\t");
			}
		}else{
			System.out.println("�û���ѯʧ��");
		}
	}
	public void addBook(){
		System.out.println("=========���ͼ��===========");
		System.out.print("ͼ����:");
		String book_name = scanner.next();
		System.out.print("������:");
		String book_author = scanner.next();
		Timestamp book_time = new Timestamp(new Date().getTime());
		Books book = new Books();
		book.setBookName(book_name);
		book.setBookAuthor(book_author);
		book.setBookTime(book_time);
		if(booksController.save(book)){
			System.out.println("ͼ����ӳɹ�");
		}else{
			System.out.println("ͼ�����ʧ��");
		}
	}
	public void deleteBook(){
		System.out.println("=========ɾ��ͼ��===========");
		System.out.print("ͼ��ID:");
		int book_id = scanner.nextInt();
		Books book = new Books();
		book.setBookId(book_id);
		if(booksController.delete(book)){
			System.out.println("ͼ��ɾ���ɹ�");
		}else{
			System.out.println("ͼ��ɾ��ʧ��");
		}
	}
	public void updateBook(){
		System.out.println("=========����ͼ��===========");
		System.out.print("ͼ��ID:");
		int book_id = scanner.nextInt();
		System.out.print("ͼ����:");
		String book_name = scanner.next();
		System.out.print("������:");
		String book_author = scanner.next();
		Timestamp book_time = new Timestamp(new Date().getTime());
		Books book = new Books(book_id,book_name,book_author,book_time);
		if(booksController.update(book)){
			System.out.println("ͼ����³ɹ�");
		}else{
			System.out.println("ͼ�����ʧ��");
		}
	}
	
	public void selectByBookId(){
		System.out.println("=========ID��ѯͼ��===========");
		System.out.print("ͼ��ID:");
		int book_id = scanner.nextInt();
		Books book = booksController.selectById(book_id);
		if(null!=book){
			System.out.println("ID\t����\t����\t״̬\tʱ��");
			System.out.print(book.getBookId()+"\t");
			System.out.print(book.getBookName()+"\t");
			System.out.print(book.getBookAuthor()+"\t");
			System.out.print(book.getBookStatus()+"\t");
			System.out.print(book.getBookTime()+"\t");
		}else{
			System.out.println("ͼ���ѯʧ��");
		}
	}
	
	public void seleteBookAll(){
		System.out.println("=========��ѯ����ͼ��===========");
		ArrayList<Books> books = booksController.selectAll();
		if(null!=books && books.size()>0){
			System.out.println("ID\t����\t����\t״̬\tʱ��");
			for (Books books2 : books) {
				System.out.print(books2.getBookId()+"\t");
				System.out.print(books2.getBookName()+"\t");
				System.out.print(books2.getBookAuthor()+"\t");
				System.out.print(books2.getBookStatus()+"\t");
				System.out.println(books2.getBookTime()+"\t");
			}
		}else{
			System.out.println("ͼ���ѯʧ��");
		}
	}
	
	public static void main(String[] args) {
		ManagerView mv = new ManagerView();
		while(true){
			mv.initView();
			System.out.println("������ѡ��");
			int choose = mv.scanner.nextInt();
			switch(choose){
			case 1:
				label1:
				while(true){
					mv.userView();
					System.out.println("������ѡ��");
					int choose2 = mv.scanner.nextInt();
					switch(choose2){
					case 1:mv.addUser();break;
					case 2:mv.deleteUser();break;
					case 3:mv.updateUser();break;
					case 4:mv.selectByUserId();break;
					case 5:mv.seleteUserAll();break;
					case 6:break label1;
					default:System.out.println("������������������");
					}
				}
				
				break;
			case 2:
				label2:
					while(true){
						mv.bookView();
						System.out.println("������ѡ��");
						int choose3 = mv.scanner.nextInt();
						switch(choose3){
						case 1:mv.addBook();break;
						case 2:mv.deleteBook();break;
						case 3:mv.updateBook();break;
						case 4:mv.selectByBookId();break;
						case 5:mv.seleteBookAll();break;
						case 6:break label2;
						default:System.out.println("������������������");
						}
					}
				break;
			case 3:System.out.println("�ټ�!");return;
			default:System.out.println("������������������");
			}
		}
	}
}
