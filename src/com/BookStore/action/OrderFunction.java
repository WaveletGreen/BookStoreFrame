package com.BookStore.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.BookStore.entity.BookInfo;
import com.BookStore.entity.Cart;
import com.BookStore.entity.OrderDetail;
import com.BookStore.entity.OrderInfo;
import com.BookStore.entity.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.util.QEncoderStream;

import util.HibernateSessionFactory;

public class OrderFunction extends ActionSupport {
	private List<Cart> cart;
	private UserInfo user;
	private List<BookInfo> bookLists;
	private String[] book_id;
	private OrderInfo orderInfo;
	private List<OrderDetail> orderDetail;

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public String[] getBook_id() {
		return book_id;
	}

	public void setBook_id(String[] book_id) {
		this.book_id = book_id;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getUserCart() {
		return SUCCESS;
	}

	public String putIntoUserCart() {
		System.out.println(book_id);
		getCartTemp();
		return SUCCESS;
	}

	public List<Cart> getCartTemp() {
		String hql;
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		if (bookLists == null) {
			bookLists = new ArrayList<BookInfo>();
		}
		// 获取书籍详细信息
		for (int i = 0; i < book_id.length; i++) {
			bookLists.add((BookInfo) session.get(BookInfo.class, Long.parseLong(book_id[i])));
		}
		user = (UserInfo) session.get(UserInfo.class, user.getUserName());
		orderInfo = new OrderInfo();
		orderInfo.setOrderGetman(user.getUserName());
		orderInfo.setOrderStatus(0);
		orderInfo.setOrderTime(new Date());
		orderInfo.setOrderPrice(180.5);
		orderInfo.setUserInfo(user);
		session.save(orderInfo);
		if(orderDetail==null){
			orderDetail=new ArrayList<OrderDetail>();
		}
		for (int i = 0; i < bookLists.size(); i++) {
			OrderDetail detail = new OrderDetail();
			detail.setBookAmount(1);
			detail.setBookInfo(bookLists.get(i));
			detail.setBookPrice(bookLists.get(i).getBookPrice());
			detail.setOrderInfo(orderInfo);
			orderDetail.add(detail);
			session.save(detail);
		}
		tx.commit();
		return cart;

	}
}
