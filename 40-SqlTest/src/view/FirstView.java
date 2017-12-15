package view;

import java.util.Scanner;

import dao.impl.UsersDaoImpl;
import entity.Users;

public class FirstView {
	Scanner scan = new Scanner(System.in);
	UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
	SecondView view2 = new SecondView();
	
	public void initView(){
		System.out.println("========== һ���˵�  =============");
		System.out.println("	   1.��½");
		System.out.println("	   2.ע��");
		System.out.println("===============================");
	}
	
	//1.��½
	public void login(){
		System.out.println("========== �û���½  =============");
		System.out.println("�������û�ID:");
		int userID = scan.nextInt();
		System.out.println("����������:");
		String userPassword = scan.next();
		
		Users user = usersDaoImpl.login(userID,userPassword);
		if(null != user){
			System.out.println(user.getUserName()+" ��½�ɹ�!!");
			view2.view2(user);
		}else{
			System.out.println("��½ʧ��!!!");
		}
	}
	
	//2.ע��
	public void register(){
		System.out.println("========== �û�ע��  =============");
		System.out.println("����������:");
		String userName = scan.next();
		System.out.println("����������:");
		String userPassword = scan.next();
		
		int id =  usersDaoImpl.save(userName,userPassword);
		if(0 != id){
			System.out.println("ע��ɹ�,"+userName+"��ID��:"+id);
		}else{
			System.out.println("ע��ʧ��!!");
		}
	}
	
}
