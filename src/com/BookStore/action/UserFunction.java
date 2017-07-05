package com.BookStore.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateSessionFactory;

import com.BookStore.entity.BookInfo;
import com.BookStore.entity.LoginUser;
import com.BookStore.entity.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

public class UserFunction extends ActionSupport {

	private LoginUser user;
	private List<BookInfo> bookLists;

	public List<BookInfo> getBookLists() {
		return bookLists;
	}

	public void setBookLists(List<BookInfo> bookLists) {
		this.bookLists = bookLists;
	}

	public LoginUser getUser() {
		return user;
	}

	public void setUser(LoginUser user) {
		this.user = user;
	}

	public String login() {
		String hql = "from UserInfo where userName=:userName and password=:password";

		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString("userName", user.getUserName());
		query.setString("password", user.getPassword());
		UserInfo info = (UserInfo) query.uniqueResult();
		if (info != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public List<BookInfo> getAllBooks() {
		String hql = "from BookInfo";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		bookLists = query.list();
		return bookLists;
	}
}
