package com.BookStore.entity;

/**
 * BookInfo entity. @author MyEclipse Persistence Tools
 */

public class BookInfo implements java.io.Serializable {

	// Fields

	private Long bookId;
	private String bookName;
	private Long bookPrice;
	private Long bookStock;
	private String bookPhoto;

	// Constructors

	/** default constructor */
	public BookInfo() {
	}

	/** minimal constructor */
	public BookInfo(Long bookId, String bookName, Long bookPrice, Long bookStock) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookStock = bookStock;
	}

	/** full constructor */
	public BookInfo(Long bookId, String bookName, Long bookPrice,
			Long bookStock, String bookPhoto) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookStock = bookStock;
		this.bookPhoto = bookPhoto;
	}

	// Property accessors

	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Long getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(Long bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Long getBookStock() {
		return this.bookStock;
	}

	public void setBookStock(Long bookStock) {
		this.bookStock = bookStock;
	}

	public String getBookPhoto() {
		return this.bookPhoto;
	}

	public void setBookPhoto(String bookPhoto) {
		this.bookPhoto = bookPhoto;
	}

}