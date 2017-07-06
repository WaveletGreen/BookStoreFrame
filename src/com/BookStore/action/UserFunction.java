package com.BookStore.action;

import java.util.List;

import oracle.net.aso.q;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;

import com.BookStore.entity.BookInfo;
import com.BookStore.entity.LoginUser;
import com.BookStore.entity.Page;
import com.BookStore.entity.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

public class UserFunction extends ActionSupport {

	private LoginUser user;
	private UserInfo regUser;
	private List<BookInfo> bookLists;
	private String errorMsg;
	private Page page;
	private String searchBookName;
	public String getSearchBookName() {
		return searchBookName;
	}

	public void setSearchBookName(String searchBookName) {
		this.searchBookName = searchBookName;
	}

	public UserInfo getRegUser() {
		return regUser;
	}

	public void setRegUser(UserInfo regUser) {
		this.regUser = regUser;
	}

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
			getBooksByPage(null, 1, 5);
			return SUCCESS;
		} else {
			addFieldError("loginError", "用户名或密码错误");
			return INPUT;
		}
	}

	public String regist() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(regUser);
		tx.commit();
		session.close();
		// 这里是需要重定向，否则刷新的时候回重复提交注册
		return "registToIndex";
	}

	/**
	 * 获取所有书籍方法,测试用
	 * 
	 * @return
	 */
	public String getAllBooks() {
		String hql = "from BookInfo";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		bookLists = query.list();
		return "toIndex";
	}

	public String search() {
		if (page == null) {
			page = new Page();
		}
		getBooksByPage(searchBookName, page.getPageIndex(), 5);
		return "toIndex";
	}

	/**
	 * 分页查询，包含模糊查询
	 * 
	 * @param index
	 *            查询其实页数
	 * @param maxResult
	 *            每页显示最大记录数
	 * @return
	 */
	public List<BookInfo> getBooksByPage(String bookName, int index, int maxResult) {
		boolean controller = false;
		int listSize = 0;
		StringBuilder hql = new StringBuilder();
		hql.append("from BookInfo ");
		if (bookName != null) {
			hql.append("where bookName like :bookName ");
			controller = true;
		}
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql.toString());
		if (controller) {
			query.setString("bookName", "%" + bookName + "%");
		}
		bookLists = query.list();
		if (this.page == null) {
			this.page = new Page();
		}
		if (bookLists.isEmpty()) {
			page.setPageIndex(1);
			page.setTotalPages(1);
			page.setNextPageIndex(1);
			page.setPrePageIndex(1);
		} else {

			if (maxResult < 1) {
				maxResult = 1;
			}
			if (bookLists.size() % maxResult != 0) {
				listSize = bookLists.size() / maxResult + 1;
			} else {
				listSize = bookLists.size() / maxResult;
			}
			if (listSize < 1) {
				listSize = 1;
				page.setTotalPages(listSize);
			} else {
				page.setTotalPages(listSize);
			}
			if (index < 1) {
				index = 1;
			} else if (index > listSize) {
				index = listSize;
			}
			page.setPageIndex(index);
			page.setPrePageIndex(index);
			page.setNextPageIndex(index);
		}
		// 设置查询范围
		query.setFirstResult((index - 1) * maxResult);
		query.setMaxResults(maxResult);
		bookLists = query.list();
		return bookLists;
	}
}
