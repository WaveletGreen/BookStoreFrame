package com.BookStore.action;

import java.util.List;

import oracle.net.aso.q;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateSessionFactory;

import com.BookStore.entity.BookInfo;
import com.BookStore.entity.LoginUser;
import com.BookStore.entity.Page;
import com.BookStore.entity.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

public class UserFunction extends ActionSupport {

	private LoginUser user;
	private List<BookInfo> bookLists;
	private String errorMsg;
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

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
			getAllBooks();
			return SUCCESS;
		} else {
			addFieldError("loginError", "用户名或密码错误");
			return INPUT;
		}
	}

	/**
	 * 获取所有书籍方法
	 * 
	 * @return
	 */
	public List<BookInfo> getAllBooks() {
		String hql = "from BookInfo";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		bookLists = query.list();
		return bookLists;
	}

	/**
	 * 分页查询，包含模糊查询
	 * 
	 * @param index
	 * @param maxResult
	 * @return
	 */
	public List<BookInfo> getBooksByPage(
//			String bookName, int index,int maxResult
			) {
		boolean controller = false;
		StringBuilder hql = new StringBuilder();
		hql.append("from BookInfo ");
//		if (bookName != null) {
//			hql.append("where bookName like :bookName ");
//			controller = true;
//		}

		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql.toString());
//		if (controller) {
//			query.setString("bookName", "%" + bookName + "%");
//		}
		bookLists = query.list();
		if (!bookLists.isEmpty()) {
			page.setPageIndex(1);
			page.setTotalPages(1);
			page.setNextPageIndex(1);
			page.setPrePageIndex(1);
		} else {
			page.setTotalPages(bookLists.size() / 5);
			page.setPageIndex(1);
			page.setNextPageIndex(1);
			page.setPageIndex(1);
		}
		// 设置查询范围
		query.setFirstResult(1);
		query.setMaxResults(5);
		bookLists = query.list();
		return bookLists;
	}
}
