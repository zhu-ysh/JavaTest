package view;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dao.impl.GoodsDaoImpl;
import dao.impl.UserGoodsDaoImpl;
import entity.Goods;
import entity.UserGoods;
import entity.Users;

public class ThirdView {
	Scanner scan = new Scanner(System.in);
	UserGoodsDaoImpl userGoodsDaoImpl = new UserGoodsDaoImpl();
	GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
	
	public void initView(){
		System.out.println("========== 三级菜单  =============");
		System.out.println("	   1.查看已购买的所有商品");
		System.out.println("	   2.查看时间段内购买的所有商品");
		System.out.println("	   3.查看月消费详细");
		System.out.println("	   4.查看高于平均购买价格的所有商品");
		System.out.println("	   5.返回上一层");
		System.out.println("===============================");
	}
	
	//1.查看已购买的所有商品(按购买时间降序排序)
	public void buyGoods(Users user){
		System.out.println("======== 查看已购买的所有商品  ===========");
		ArrayList<UserGoods> userGoodss = userGoodsDaoImpl.selectUserBuyGoods(user);
		System.out.println("订单号\t商品名\t购买数量\t购买时单价\t购买时间");
		for (UserGoods userGoods : userGoodss) {
			System.out.print(userGoods.getUserGoodsId()+"\t");
			Goods goods = goodsDaoImpl.selectById(userGoods.getGoodsId());
			System.out.print(goods.getGoodsName()+"\t");
			System.out.print(userGoods.getGoodsCount()+"\t");
			System.out.print(userGoods.getGoods_buy_price()+"\t");
			System.out.println(userGoods.getUserGoodsSetTime());
		}
		
	}
	
	//2.查看时间段内购买的所有商品(提示输入开始时间,结束时间)
	public void timeBuyGoods(Users user){
		System.out.println("======== 查看时间段内购买的所有商品  ===========");
		System.out.println("请输入开始时间:");
		System.out.println("请输入开始年:");
		int year = scan.nextInt();
		System.out.println("请输入开始月:");
		int month = scan.nextInt();
		System.out.println("请输入开始日:");
		int day = scan.nextInt();
		Timestamp t1 = new Timestamp(year-1900, month, day, 0, 0, 0, 0);
		System.out.println("请输入结束时间:");
		System.out.println("请输入结束年:");
		year = scan.nextInt();
		System.out.println("请输入结束月:");
		month = scan.nextInt();
		System.out.println("请输入结束日:");
		day = scan.nextInt();
		Timestamp t2 = new Timestamp(year-1900, month, day, 0, 0, 0, 0);
		
		ArrayList<UserGoods> userGoodss = userGoodsDaoImpl.selectUserTimeBuyGoods(user, t1, t2);
		System.out.println("订单号\t商品名\t购买数量\t购买时单价\t购买时间");
		for (Iterator iterator = userGoodss.iterator(); iterator.hasNext();) {
			UserGoods userGoods2 = (UserGoods) iterator.next();
			System.out.print(userGoods2.getUserGoodsId()+"\t");
			Goods goods = goodsDaoImpl.selectById(userGoods2.getGoodsId());
			System.out.print(goods.getGoodsName()+"\t");
			System.out.print(userGoods2.getGoodsCount()+"\t");
			System.out.print(userGoods2.getGoods_buy_price()+"\t");
			System.out.println(userGoods2.getUserGoodsSetTime());
		}
		
	}

	//3.查看月消费详细(查看每月消费金额和购买商品数量,要求有分页,5条)
	public void monthBuyTxt(Users user){
		System.out.println("======== 查看月消费详细  ===========");
		int i = userGoodsDaoImpl.selectMonthTxt(user);
		System.out.println("共有 "+(int)(Math.ceil(i*1.0/5))+" 页,请输入要查询的页数:");
		int p = scan.nextInt(); 
		ArrayList<String> strArr = userGoodsDaoImpl.selectMonthTxt(user,p,5);
		System.out.println("消费金额\t商品数量\t月份");
		for (String string : strArr) {
			System.out.println(string);
		}
	}
	
	//4.查看高于平均购买价格的所有商品(使用1条SQL语句?,分页,5条)
	public void upAvgPirceGoods(Users user){
		System.out.println("====== 查看高于平均购买价格的所有商品  =========");
		int i = userGoodsDaoImpl.upAvgPirceGoods(user);
		System.out.println("共有 "+(int)(Math.ceil(i*1.0/5))+" 页,请输入要查询的页数:");
		int p = scan.nextInt(); 
		ArrayList<UserGoods> userGoodss = userGoodsDaoImpl.upAvgPirceGoods(user, p, 5);
		System.out.println("商品名");
		for (UserGoods userGoods : userGoodss) {
			Goods goods = goodsDaoImpl.selectById(userGoods.getGoodsId());
			System.out.println(goods.getGoodsName());
		}
	}

	
	
	public void view3(Users user){
		while(true){
			initView();
			System.out.println("请输入指令:");
			switch(scan.nextInt()){
				case 1:buyGoods(user);break;
				case 2:timeBuyGoods(user);break;
				case 3:monthBuyTxt(user);break;
				case 4:upAvgPirceGoods(user);break;
				case 5:return;
					default:System.out.println("输入错误,请重新输入!!!!");
			}
		}
	}
}
