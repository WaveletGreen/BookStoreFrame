package com.BookStore.action;

import com.opensymphony.xwork2.ActionSupport;

public class Global extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	@Override
	public boolean hasErrors() {
		return super.hasErrors();
	}

	public String logout() {
		return "logout";
	}

}
