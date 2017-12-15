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
		System.out.println("========== �����˵�  =============");
		System.out.println("	   1.�鿴�ѹ����������Ʒ");
		System.out.println("	   2.�鿴ʱ����ڹ����������Ʒ");
		System.out.println("	   3.�鿴��������ϸ");
		System.out.println("	   4.�鿴����ƽ������۸��������Ʒ");
		System.out.println("	   5.������һ��");
		System.out.println("===============================");
	}
	
	//1.�鿴�ѹ����������Ʒ(������ʱ�併������)
	public void buyGoods(Users user){
		System.out.println("======== �鿴�ѹ����������Ʒ  ===========");
		ArrayList<UserGoods> userGoodss = userGoodsDaoImpl.selectUserBuyGoods(user);
		System.out.println("������\t��Ʒ��\t��������\t����ʱ����\t����ʱ��");
		for (UserGoods userGoods : userGoodss) {
			System.out.print(userGoods.getUserGoodsId()+"\t");
			Goods goods = goodsDaoImpl.selectById(userGoods.getGoodsId());
			System.out.print(goods.getGoodsName()+"\t");
			System.out.print(userGoods.getGoodsCount()+"\t");
			System.out.print(userGoods.getGoods_buy_price()+"\t");
			System.out.println(userGoods.getUserGoodsSetTime());
		}
		
	}
	
	//2.�鿴ʱ����ڹ����������Ʒ(��ʾ���뿪ʼʱ��,����ʱ��)
	public void timeBuyGoods(Users user){
		System.out.println("======== �鿴ʱ����ڹ����������Ʒ  ===========");
		System.out.println("�����뿪ʼʱ��:");
		System.out.println("�����뿪ʼ��:");
		int year = scan.nextInt();
		System.out.println("�����뿪ʼ��:");
		int month = scan.nextInt();
		System.out.println("�����뿪ʼ��:");
		int day = scan.nextInt();
		Timestamp t1 = new Timestamp(year-1900, month, day, 0, 0, 0, 0);
		System.out.println("���������ʱ��:");
		System.out.println("�����������:");
		year = scan.nextInt();
		System.out.println("�����������:");
		month = scan.nextInt();
		System.out.println("�����������:");
		day = scan.nextInt();
		Timestamp t2 = new Timestamp(year-1900, month, day, 0, 0, 0, 0);
		
		ArrayList<UserGoods> userGoodss = userGoodsDaoImpl.selectUserTimeBuyGoods(user, t1, t2);
		System.out.println("������\t��Ʒ��\t��������\t����ʱ����\t����ʱ��");
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

	//3.�鿴��������ϸ(�鿴ÿ�����ѽ��͹�����Ʒ����,Ҫ���з�ҳ,5��)
	public void monthBuyTxt(Users user){
		System.out.println("======== �鿴��������ϸ  ===========");
		int i = userGoodsDaoImpl.selectMonthTxt(user);
		System.out.println("���� "+(int)(Math.ceil(i*1.0/5))+" ҳ,������Ҫ��ѯ��ҳ��:");
		int p = scan.nextInt(); 
		ArrayList<String> strArr = userGoodsDaoImpl.selectMonthTxt(user,p,5);
		System.out.println("���ѽ��\t��Ʒ����\t�·�");
		for (String string : strArr) {
			System.out.println(string);
		}
	}
	
	//4.�鿴����ƽ������۸��������Ʒ(ʹ��1��SQL���?,��ҳ,5��)
	public void upAvgPirceGoods(Users user){
		System.out.println("====== �鿴����ƽ������۸��������Ʒ  =========");
		int i = userGoodsDaoImpl.upAvgPirceGoods(user);
		System.out.println("���� "+(int)(Math.ceil(i*1.0/5))+" ҳ,������Ҫ��ѯ��ҳ��:");
		int p = scan.nextInt(); 
		ArrayList<UserGoods> userGoodss = userGoodsDaoImpl.upAvgPirceGoods(user, p, 5);
		System.out.println("��Ʒ��");
		for (UserGoods userGoods : userGoodss) {
			Goods goods = goodsDaoImpl.selectById(userGoods.getGoodsId());
			System.out.println(goods.getGoodsName());
		}
	}

	
	
	public void view3(Users user){
		while(true){
			initView();
			System.out.println("������ָ��:");
			switch(scan.nextInt()){
				case 1:buyGoods(user);break;
				case 2:timeBuyGoods(user);break;
				case 3:monthBuyTxt(user);break;
				case 4:upAvgPirceGoods(user);break;
				case 5:return;
					default:System.out.println("�������,����������!!!!");
			}
		}
	}
}
