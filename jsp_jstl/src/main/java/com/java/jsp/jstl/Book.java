package com.java.jsp.jstl;

public class Book {

	private int bookNumber,id;
	private String bookName;
	private String authorName;
	private double price;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookNumber, String bookName, String authorName, double price) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	

}
