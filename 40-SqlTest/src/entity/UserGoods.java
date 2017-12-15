package entity;

import java.sql.Timestamp;

public class UserGoods {
	private int userGoodsId;
	private int userId;
	private int goodsId;
	private double goods_buy_price;
	private Timestamp userGoodsSetTime;
	private Timestamp userGoodsUpDateTime;
	private int userGoodsStatus;
	
	
	public int getUserGoodsId() {
		return userGoodsId;
	}
	public void setUserGoodsId(int userGoodsId) {
		this.userGoodsId = userGoodsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public double getGoods_buy_price() {
		return goods_buy_price;
	}
	public void setGoods_buy_price(double goods_buy_price) {
		this.goods_buy_price = goods_buy_price;
	}
	public Timestamp getUserGoodsSetTime() {
		return userGoodsSetTime;
	}
	public void setUserGoodsSetTime(Timestamp userGoodsSetTime) {
		this.userGoodsSetTime = userGoodsSetTime;
	}
	public Timestamp getUserGoodsUpDateTime() {
		return userGoodsUpDateTime;
	}
	public void setUserGoodsUpDateTime(Timestamp userGoodsUpDateTime) {
		this.userGoodsUpDateTime = userGoodsUpDateTime;
	}
	public int getUserGoodsStatus() {
		return userGoodsStatus;
	}
	public void setUserGoodsStatus(int userGoodsStatus) {
		this.userGoodsStatus = userGoodsStatus;
	}
	public UserGoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserGoods(int userGoodsId, int userId, int goodsId, double goods_buy_price, Timestamp userGoodsSetTime,
			Timestamp userGoodsUpDateTime, int userGoodsStatus) {
		super();
		this.userGoodsId = userGoodsId;
		this.userId = userId;
		this.goodsId = goodsId;
		this.goods_buy_price = goods_buy_price;
		this.userGoodsSetTime = userGoodsSetTime;
		this.userGoodsUpDateTime = userGoodsUpDateTime;
		this.userGoodsStatus = userGoodsStatus;
	}
}
