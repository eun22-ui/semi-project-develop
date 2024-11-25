package com.kh.book.model.vo;

import java.sql.Date;

public class Book {
	private int bookId;// BOOK_ID NUMBER
	private String bookTitle;// BOOK_TITLE VARCHAR2(1000 BYTE)
	private String bookAuthor;// BOOK_AUTHOR VARCHAR2(100 BYTE)
	private String publisher;// PUBLISHER VARCHAR2(100 BYTE)
	private int publishDate;// PUBLISH_DATE NUMBER
	private Date enrollDate;// ENROLL_DATE DATE
	private String ageRank;// AGE_RANK VARCHAR2(1 BYTE)
	private int rentCount;// RENT_COUNT NUMBER
	private String status;// STATUS VARCHAR2(1 BYTE)
	private String summary;
	private String imgName;

	public Book() {
		super();
	}
	
	
	public Book(int bookId, String bookTitle, String imgName) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.imgName = imgName;
	}

	public Book(int bookId, String bookTitle, String bookAuthor, String summary, String imgName) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.summary = summary;
		this.imgName = imgName;
	}




	public Book(int bookId, String bookTitle, String bookAuthor, String publisher, int publishDate, Date enrollDate,
			String ageRank, int rentCount, String status, String summary, String imgName) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.enrollDate = enrollDate;
		this.ageRank = ageRank;
		this.rentCount = rentCount;
		this.status = status;
		this.summary = summary;
		this.imgName = imgName;
	}

	public Book(int bookId, String bookTitle, String bookAuthor, String publisher, int publishDate, Date enrollDate,
			String status, String summary, String imgName) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.enrollDate = enrollDate;
		this.status = status;
		this.summary = summary;
		this.imgName = imgName;
	}
	
	
	public Book(String imgName, int bookId, String bookTitle, String bookAuthor, String publisher, int publishDate, String ageRank,
			String summary) {
		super();
		this.imgName = imgName;
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.ageRank = ageRank;
		this.summary = summary;
	}

	public Book(int bookId, String bookTitle, String bookAuthor, int publishDate, Date enrollDate, String ageRank,
			String status) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publishDate = publishDate;
		this.enrollDate = enrollDate;
		this.ageRank = ageRank;
		this.status = status;
	}

	public Book(int bookId, String bookTitle, String bookAuthor, String publisher, int publishDate, Date enrollDate,
			String status, String imgName) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.enrollDate = enrollDate;
		this.status = status;
		this.imgName = imgName;
	}

	

	public Book(int bookId, String bookTitle, String bookAuthor, String imgName) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.imgName = imgName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(int publishDate) {
		this.publishDate = publishDate;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getAgeRank() {
		return ageRank;
	}

	public void setAgeRank(String ageRank) {
		this.ageRank = ageRank;
	}

	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", publisher="
				+ publisher + ", publishDate=" + publishDate + ", enrollDate=" + enrollDate + ", ageRank=" + ageRank
				+ ", rentCount=" + rentCount + ", status=" + status + ", summary=" + summary + ", imgName=" + imgName
				+ "]";
	}


}
