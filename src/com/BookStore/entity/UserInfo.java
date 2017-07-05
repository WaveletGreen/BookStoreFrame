package com.BookStore.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private String userName;
	private String password;
	private String email;
	private Set orderInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	/** full constructor */
	public UserInfo(String userName, String password, String email,
			Set orderInfos) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.orderInfos = orderInfos;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getOrderInfos() {
		return this.orderInfos;
	}

	public void setOrderInfos(Set orderInfos) {
		this.orderInfos = orderInfos;
	}

}