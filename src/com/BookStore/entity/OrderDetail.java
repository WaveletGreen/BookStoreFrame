package com.BookStore.entity;

import java.math.BigDecimal;

/**
 * OrderDetail entity. @author MyEclipse Persistence Tools
 */

public class OrderDetail implements java.io.Serializable {

	// Fields

	private BigDecimal orderDetailId;
	private BookInfo bookInfo;
	private OrderInfo orderInfo;
	private Double bookPrice;
	private BigDecimal bookAmount;

	// Constructors

	/** default constructor */
	public OrderDetail() {
	}

	/** full constructor */
	public OrderDetail(BigDecimal orderDetailId, BookInfo bookInfo,
			OrderInfo orderInfo, Double bookPrice, BigDecimal bookAmount) {
		this.orderDetailId = orderDetailId;
		this.bookInfo = bookInfo;
		this.orderInfo = orderInfo;
		this.bookPrice = bookPrice;
		this.bookAmount = bookAmount;
	}

	// Property accessors

	public BigDecimal getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(BigDecimal orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public BookInfo getBookInfo() {
		return this.bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public OrderInfo getOrderInfo() {
		return this.orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Double getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public BigDecimal getBookAmount() {
		return this.bookAmount;
	}

	public void setBookAmount(BigDecimal bookAmount) {
		this.bookAmount = bookAmount;
	}

}