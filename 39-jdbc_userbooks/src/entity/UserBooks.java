package entity;

public class UserBooks {
	private int userbookId;
	private int userbookStatus;
	private Users user;
	private Books book;
	public int getUserbookId() {
		return userbookId;
	}
	public void setUserbookId(int userbookId) {
		this.userbookId = userbookId;
	}
	public int getUserbookStatus() {
		return userbookStatus;
	}
	public void setUserbookStatus(int userbookStatus) {
		this.userbookStatus = userbookStatus;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public UserBooks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserBooks(int userbookId, int userbookStatus, Users user, Books book) {
		super();
		this.userbookId = userbookId;
		this.userbookStatus = userbookStatus;
		this.user = user;
		this.book = book;
	}
	
	public UserBooks(int userbookId, Users user, Books book) {
		super();
		this.userbookId = userbookId;
		this.user = user;
		this.book = book;
	}
}
