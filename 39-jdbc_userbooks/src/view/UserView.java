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
		System.out.println("-----------�û�------------");
		System.out.println("          1. �鿴����ͼ��");
		System.out.println("          2. ģ����ѯͼ��");
		System.out.println("          3. ���ͼ��");
		System.out.println("          4. ɾ��ͼ��");
		System.out.println("          5. �鿴ͼ��");
		System.out.println("          6. �˳�");
		System.out.println("-----------------------------");
	}
	 
	//ģ����ѯ
	public void selectAllLike(){
		System.out.println("=========��ѯ����ͼ��===========");
		System.out.print("������Ҫ�鿴������:");
		String like = scanner.next();
		ArrayList<Books> bookss = booksController.selectAllLike(like);
		if(null!=bookss && bookss.size()>0){
			System.out.println("ID\t����\t����\t״̬\tʱ��");
			for (Books books2 : bookss) {
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
	
	//��ѯ������
	public void selectAllBooks(){
		System.out.println("=========��ѯ����ͼ��===========");
		ArrayList<Books> books = booksController.selectAll();
		int per = 5;
		System.out.println("����:"+Math.ceil(books.size()*1.0/per)+"ҳ");
		System.out.print("������Ҫ�鿴��ҳ��:");
		int page = scanner.nextInt();
		//���÷�ҳ��ѯ
		ArrayList<Books> bookss = booksController.page(per, page);
		if(null!=books && books.size()>0){
			System.out.println("ID\t����\t����\t״̬\tʱ��");
			for (Books books2 : bookss) {
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
	
	public void addUserBooks(){
		System.out.println("=========����û�ͼ��===========");
		System.out.print("����ͼ��ID:");
		int book_id = scanner.nextInt();
		UserBooks ub = new UserBooks();
		Books book = new Books();
		book.setBookId(book_id);
		ub.setBook(book);
		ub.setUser(loginUser);
		if(userbooksController.save(ub)){
			System.out.println("��ӳɹ�");
		}else{
			System.out.println("���ʧ��");
		}
	}
	
	public void deleteUserBooks(){
		System.out.println("=========ɾ���û�ͼ��===========");
		System.out.print("����ID:");
		int userbook_id = scanner.nextInt();
		UserBooks ub = new UserBooks();
		ub.setUserbookId(userbook_id);
		if(userbooksController.delete(ub)){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
	
	public void selectAllByUserId(){
		 ArrayList<Integer> ids = userbooksController.getBookIdsByUser(loginUser);
		 ArrayList<Books> books= booksController.getBooksByIds(ids);
		 if(null!=books && books.size()>0){
			System.out.println("ID\t����\t����\t״̬\tʱ��");
			for(int i = 0;i<books.size();i++){
				System.out.print(ids.get(i)+"\t");
				System.out.print(books.get(i).getBookName()+"\t");
				System.out.print(books.get(i).getBookAuthor()+"\t");
				System.out.print(books.get(i).getBookStatus()+"\t");
				System.out.println(books.get(i).getBookTime()+"\t");
			}
		}else{
			System.out.println("ͼ���ѯʧ��");
		}
	}
	
	public void login(){
		System.out.println("-----------��¼------------");
		System.out.print("�û���:");
		String user_name = scanner.next();
		System.out.print("����:");
		String user_password= scanner.next();
		Users user = new Users();
		user.setUserName(user_name);
		user.setUserPassword(user_password);
		loginUser = usersController.login(user);
		
		if(null!=loginUser){
			while(true){
				initView();
				System.out.print("����ѡ��:");
				int choose = scanner.nextInt();
				switch(choose){
				case 1:selectAllBooks();break;
				case 2:selectAllLike();break;
				case 3:addUserBooks();break;
				case 4:deleteUserBooks();break;
				case 5:selectAllByUserId();break;
				case 6:System.out.println("�ټ���");return;
				default:System.out.println("������������������");
				}
			}
		}else{
			System.out.println("��¼ʧ��");
		}
	}
	
	public static void main(String[] args) {
		UserView uv = new UserView();
		uv.login();
	}
}
