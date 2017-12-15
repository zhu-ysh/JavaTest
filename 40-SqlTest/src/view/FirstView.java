package view;

import java.util.Scanner;

import dao.impl.UsersDaoImpl;
import entity.Users;

public class FirstView {
	Scanner scan = new Scanner(System.in);
	UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
	SecondView view2 = new SecondView();
	
	public void initView(){
		System.out.println("========== 一级菜单  =============");
		System.out.println("	   1.登陆");
		System.out.println("	   2.注册");
		System.out.println("===============================");
	}
	
	//1.登陆
	public void login(){
		System.out.println("========== 用户登陆  =============");
		System.out.println("请输入用户ID:");
		int userID = scan.nextInt();
		System.out.println("请输入密码:");
		String userPassword = scan.next();
		
		Users user = usersDaoImpl.login(userID,userPassword);
		if(null != user){
			System.out.println(user.getUserName()+" 登陆成功!!");
			view2.view2(user);
		}else{
			System.out.println("登陆失败!!!");
		}
	}
	
	//2.注册
	public void register(){
		System.out.println("========== 用户注册  =============");
		System.out.println("请输入姓名:");
		String userName = scan.next();
		System.out.println("请输入密码:");
		String userPassword = scan.next();
		
		int id =  usersDaoImpl.save(userName,userPassword);
		if(0 != id){
			System.out.println("注册成功,"+userName+"的ID是:"+id);
		}else{
			System.out.println("注册失败!!");
		}
	}
	
}
