package view;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		FirstView view1 = new FirstView();
		Scanner scan = new Scanner(System.in);
		
		while(true){
			view1.initView();
			System.out.println("������ָ��:");
			switch(scan.nextInt()){
			case 1:view1.login();break;
			case 2:view1.register();break;
			case 3:System.out.println("�ټ�!!");return;
				default:System.out.println("�������,����������!!!!");
			}
		}
	}

}
