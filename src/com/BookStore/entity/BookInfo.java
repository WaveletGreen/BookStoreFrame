package com.BookStore.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * BookInfo entity. @author MyEclipse Persistence Tools
 */

public class BookInfo implements java.io.Serializable {

	// Fields

	private Long bookId;
	private String bookName;
	private Double bookPrice;
	private Long bookStock;
	private String bookPhoto;
	private Set orderDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public BookInfo() {
	}

	/** minimal constructor */
	public BookInfo(Long bookId, String bookName, Double bookPrice, Long bookStock) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookStock = bookStock;
	}

	/** full constructor */
	public BookInfo(Long bookId, String bookName, Double bookPrice,
			Long bookStock, String bookPhoto, Set orderDetails) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookStock = bookStock;
		this.bookPhoto = bookPhoto;
		this.orderDetails = orderDetails;
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

	public Double getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
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

	public Set getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set orderDetails) {
		this.orderDetails = orderDetails;
	}

}