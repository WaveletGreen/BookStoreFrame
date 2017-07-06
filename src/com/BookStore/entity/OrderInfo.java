package com.BookStore.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OrderInfo entity. @author MyEclipse Persistence Tools
 */

public class OrderInfo implements java.io.Serializable {

	// Fields

	private Long orderId;
	private UserInfo userInfo;
	private Double orderPrice;
	private String orderGetman;
	private Integer orderStatus;
	private Date orderTime;
	private Set orderDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public OrderInfo() {
	}

	/** minimal constructor */
	public OrderInfo(Long orderId, UserInfo userInfo, Double orderPrice,
			String orderGetman, Integer orderStatus, Date orderTime) {
		this.orderId = orderId;
		this.userInfo = userInfo;
		this.orderPrice = orderPrice;
		this.orderGetman = orderGetman;
		this.orderStatus = orderStatus;
		this.orderTime = orderTime;
	}

	/** full constructor */
	public OrderInfo(Long orderId, UserInfo userInfo, Double orderPrice,
			String orderGetman, Integer orderStatus, Date orderTime,
			Set orderDetails) {
		this.orderId = orderId;
		this.userInfo = userInfo;
		this.orderPrice = orderPrice;
		this.orderGetman = orderGetman;
		this.orderStatus = orderStatus;
		this.orderTime = orderTime;
		this.orderDetails = orderDetails;
	}

	// Property accessors

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Double getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderGetman() {
		return this.orderGetman;
	}

	public void setOrderGetman(String orderGetman) {
		this.orderGetman = orderGetman;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Set getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set orderDetails) {
		this.orderDetails = orderDetails;
	}

}