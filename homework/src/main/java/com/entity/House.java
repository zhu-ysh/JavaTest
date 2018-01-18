package com.entity;

public class House {
	private int houseId;
	private String houseRegion;
	private String houseType;
	private int housePrice;
	
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getHouseRegion() {
		return houseRegion;
	}
	public void setHouseRegion(String houseRegion) {
		this.houseRegion = houseRegion;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public int getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}
	public House(int houseId, String houseRegion, String houseType, int housePrice) {
		super();
		this.houseId = houseId;
		this.houseRegion = houseRegion;
		this.houseType = houseType;
		this.housePrice = housePrice;
	}
	@Override
	public String toString() {
		return "house [houseId=" + houseId + ", houseRegion=" + houseRegion + ", houseType=" + houseType
				+ ", housePrice=" + housePrice + "]";
	}
}
