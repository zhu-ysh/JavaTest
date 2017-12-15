package entity;

import java.sql.Timestamp;

public class Users {
	private int userId;
	private String userName;
	private String userPassWord;
	private Timestamp userSetTime;
	private Timestamp userUpDateTime;
	private int userStatus;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}
	public Timestamp getUserSetTime() {
		return userSetTime;
	}
	public void setUserSetTime(Timestamp userSetTime) {
		this.userSetTime = userSetTime;
	}
	public Timestamp getUserUpDateTime() {
		return userUpDateTime;
	}
	public void setUserUpDateTime(Timestamp userUpDateTime) {
		this.userUpDateTime = userUpDateTime;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int userId, String userName, String userPassWord, Timestamp userSetTime, Timestamp userUpDateTime,
			int userStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassWord = userPassWord;
		this.userSetTime = userSetTime;
		this.userUpDateTime = userUpDateTime;
		this.userStatus = userStatus;
	}
}
