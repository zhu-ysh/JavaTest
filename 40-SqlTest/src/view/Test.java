package view;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		FirstView view1 = new FirstView();
		Scanner scan = new Scanner(System.in);
		
		while(true){
			view1.initView();
			System.out.println("请输入指令:");
			switch(scan.nextInt()){
			case 1:view1.login();break;
			case 2:view1.register();break;
			case 3:System.out.println("再见!!");return;
				default:System.out.println("输入错误,请重新输入!!!!");
			}
		}
	}

}
