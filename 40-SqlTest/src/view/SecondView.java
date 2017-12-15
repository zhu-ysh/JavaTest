package view;

import java.util.Scanner;

import entity.Users;

public class SecondView {
	Scanner scan = new Scanner(System.in);
	ThirdView view3 = new ThirdView();
	
	public void initView(){
		System.out.println("========== 二级菜单  =============");
		System.out.println("	   1.查看商品");
		System.out.println("	   2.查看购物车");
		System.out.println("	   3.已购商品统计分析");
		System.out.println("	   4.返回上一层");
		System.out.println("===============================");
	}
	
	//1.查看商品
	public void lookGoods(){
	}
	
	//2.查看购物车
	public void lookBuyCar(){
	}
	
	//3.已购商品统计分析
	public void buyGoodTxt(Users user){
		view3.view3(user);
	}
	
	
	public void view2(Users user){
		while(true){
			initView();
			System.out.println("请输入指令:");
			switch(scan.nextInt()){
				case 1:lookGoods();break;
				case 2:lookBuyCar();break;
				case 3:buyGoodTxt(user);break;
				case 4:return;
					default:System.out.println("输入错误,请重新输入!!!!");
			}
		}
	}
}
