package entity;

import java.sql.Timestamp;

public class Users {
	private int userId;
	private String userName;
	private String userPassword;
	private Timestamp userTime;
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Timestamp getUserTime() {
		return userTime;
	}
	public void setUserTime(Timestamp userTime) {
		this.userTime = userTime;
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
	public Users(int userId, String userName, String userPassword, Timestamp userTime, int userStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTime = userTime;
		this.userStatus = userStatus;
	}
	public Users(int userId, String userName, String userPassword, Timestamp userTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTime = userTime;
	}
}
