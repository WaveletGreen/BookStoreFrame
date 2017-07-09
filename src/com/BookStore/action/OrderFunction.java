package com.BookStore.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
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

public class OrderFunction extends ActionSupport implements SessionAware {
	private List<Cart> cart;// 用户购物车
	private UserInfo user;// 登录的用户
	private List<BookInfo> bookLists;// 书籍列表，查询数据库获得
	private String[] book_id;// 从前端获取到的book_id，用于查询数据库以获得书籍列表
	private OrderInfo orderInfo;// 总订单
	private List<OrderDetail> orderDetail;// 订单详情
	private String buyNum;// 购买书籍的数量，有可能有多本
	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(String buyNum) {
		this.buyNum = buyNum;
	}

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
		System.out.println("------------------" + user.getUserName());
		// String hql = "select b.bookId,b.bookName,b.bookPrice,b.bookPhoto " +
		// "from BookInfo b "
		// + "right outer join OrderDetail od on b.bookId=od.bookInfo.bookId " +
		// "where b.bookId in ("
		// + "select od.bookInfo.bookId from OrderDetail od " + "where
		// od.orderInfo.orderId in "
		// + "(select o.orderId from OrderInfo o where o.orderStatus=0))";
		String hql = "select  b.book_id ,b.book_name,b.book_price,b.book_photo,od.book_amount from book_info b right join order_detail od on b.book_id=od.book_id where b.book_id in (select book_id from order_detail od where od.order_id in (select o.order_id from order_info  o where o.order_status=0))";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createSQLQuery(hql);
		// query.setString("userName", user.getUserName());
		List<Object[]> infoList;
		infoList = query.list();
		if(this.cart==null){
			this.cart=new ArrayList<Cart>();
		}
		for (int i = 0; i < infoList.size(); i++) {
			Cart cart=new Cart();
			cart.setBook_id(Long.parseLong(infoList.get(i)[0].toString()));
			cart.setBookName(infoList.get(i)[1].toString());
			cart.setPrice(Double.parseDouble(infoList.get(i)[2].toString()));
			cart.setBookPhoto(infoList.get(i)[3].toString());
			cart.setNumber(Integer.parseInt(infoList.get(i)[4].toString()));
			this.cart.add(cart);
		}
		return INPUT;
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
		if (cart == null) {
			cart = new ArrayList<Cart>();
		}
		// 获取书籍详细信息
		for (int i = 0; i < book_id.length; i++) {
			bookLists.add((BookInfo) session.get(BookInfo.class, Long.parseLong(book_id[i])));
		}
		user = (UserInfo) session.get(UserInfo.class, user.getUserName());
		orderInfo = new OrderInfo();
		orderInfo.setOrderGetman(user.getUserName());
		orderInfo.setOrderStatus(0);// 表示还在购物车中,设为0是订单没完成支付
		orderInfo.setOrderTime(new Date());
		orderInfo.setUserInfo(user);
		// 计算总金额
		double price = 0;
		for (int i = 0; i < bookLists.size(); i++) {
			price += bookLists.get(i).getBookPrice() * Integer.parseInt(buyNum);
		}
		orderInfo.setOrderPrice(price);
		session.save(orderInfo);
		if (orderDetail == null) {
			orderDetail = new ArrayList<OrderDetail>();
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
		for (int i = 0; i < bookLists.size(); i++) {
			Cart cart = new Cart();
			cart.setBook_id(bookLists.get(i).getBookId());
			cart.setBookName(bookLists.get(i).getBookName());
			cart.setBookPhoto(bookLists.get(i).getBookName());
			cart.setBookPhoto(bookLists.get(i).getBookPhoto());
			cart.setNumber(1);
		}
		Query query = session.createQuery("from OrderInfo where userInfo.userName=:userName and orderStatus=0");
		query.setString("userName", user.getUserName());
		cart = query.list();

		tx.commit();
		return cart;
	}
}
