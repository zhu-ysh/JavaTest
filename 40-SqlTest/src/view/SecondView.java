package view;

import java.util.Scanner;

import entity.Users;

public class SecondView {
	Scanner scan = new Scanner(System.in);
	ThirdView view3 = new ThirdView();
	
	public void initView(){
		System.out.println("========== �����˵�  =============");
		System.out.println("	   1.�鿴��Ʒ");
		System.out.println("	   2.�鿴���ﳵ");
		System.out.println("	   3.�ѹ���Ʒͳ�Ʒ���");
		System.out.println("	   4.������һ��");
		System.out.println("===============================");
	}
	
	//1.�鿴��Ʒ
	public void lookGoods(){
	}
	
	//2.�鿴���ﳵ
	public void lookBuyCar(){
	}
	
	//3.�ѹ���Ʒͳ�Ʒ���
	public void buyGoodTxt(Users user){
		view3.view3(user);
	}
	
	
	public void view2(Users user){
		while(true){
			initView();
			System.out.println("������ָ��:");
			switch(scan.nextInt()){
				case 1:lookGoods();break;
				case 2:lookBuyCar();break;
				case 3:buyGoodTxt(user);break;
				case 4:return;
					default:System.out.println("�������,����������!!!!");
			}
		}
	}
}
