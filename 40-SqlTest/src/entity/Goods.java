package entity;

import java.sql.Timestamp;

public class Goods {
	private int goodsId;
	private int goodsPrice;
	private String goodsName;
	private Timestamp goodsSetTime;
	private Timestamp goodsUpDateTime;
	private int goodsStatus;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Timestamp getGoodsSetTime() {
		return goodsSetTime;
	}
	public void setGoodsSetTime(Timestamp goodsSetTime) {
		this.goodsSetTime = goodsSetTime;
	}
	public Timestamp getGoodsUpDateTime() {
		return goodsUpDateTime;
	}
	public void setGoodsUpDateTime(Timestamp goodsUpDateTime) {
		this.goodsUpDateTime = goodsUpDateTime;
	}
	public int getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(int goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(int goodsId, int goodsPrice, String goodsName, Timestamp goodsSetTime, Timestamp goodsUpDateTime,
			int goodsStatus) {
		super();
		this.goodsId = goodsId;
		this.goodsPrice = goodsPrice;
		this.goodsName = goodsName;
		this.goodsSetTime = goodsSetTime;
		this.goodsUpDateTime = goodsUpDateTime;
		this.goodsStatus = goodsStatus;
	}
}
