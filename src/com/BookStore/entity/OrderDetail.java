package com.BookStore.entity;

import java.math.BigDecimal;

/**
 * OrderDetail entity. @author MyEclipse Persistence Tools
 */

public class OrderDetail implements java.io.Serializable {

	// Fields

	private Integer orderDetailId;
	private BookInfo bookInfo;
	private OrderInfo orderInfo;
	private Double bookPrice;
	private Integer bookAmount;

	// Constructors

	/** default constructor */
	public OrderDetail() {
	}

	/** full constructor */
	public OrderDetail(Integer orderDetailId, BookInfo bookInfo,
			OrderInfo orderInfo, Double bookPrice, Integer bookAmount) {
		this.orderDetailId = orderDetailId;
		this.bookInfo = bookInfo;
		this.orderInfo = orderInfo;
		this.bookPrice = bookPrice;
		this.bookAmount = bookAmount;
	}

	// Property accessors

	public Integer getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
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

	public Integer getBookAmount() {
		return this.bookAmount;
	}

	public void setBookAmount(Integer bookAmount) {
		this.bookAmount = bookAmount;
	}

}