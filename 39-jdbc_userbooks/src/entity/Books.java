package entity;

import java.sql.Timestamp;

public class Books {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private Timestamp bookTime;
	private int bookStatus;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public Timestamp getBookTime() {
		return bookTime;
	}
	public void setBookTime(Timestamp bookTime) {
		this.bookTime = bookTime;
	}
	public int getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(int bookStatus) {
		this.bookStatus = bookStatus;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int bookId, String bookName, String bookAuthor, Timestamp bookTime, int bookStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookTime = bookTime;
		this.bookStatus = bookStatus;
	}
	public Books(int bookId, String bookName, String bookAuthor, Timestamp bookTime) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookTime = bookTime;
	}
}
