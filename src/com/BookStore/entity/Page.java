package com.BookStore.entity;

public class Page {

	private int pageIndex;
	private int totalPages;
	private int prePageIndex;
	private int nextPageIndex;

	public Page() {
	}

	public Page(int pageIndex, int totalPages, int prePageIndex,
			int nextPageIndex) {
	}

	public int getPageIndex() {
		return this.pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalPages() {
		return this.totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPrePageIndex() {
		return this.prePageIndex;
	}

	public void setPrePageIndex(int prePageIndex) {
		this.prePageIndex = prePageIndex - 1;
		if (this.prePageIndex < pageIndex) {
			this.prePageIndex = pageIndex;
		}
	}

	public int getNextPageIndex() {
		return this.nextPageIndex;

	}

	public void setNextPageIndex(int nextPageIndex) {
		this.nextPageIndex = nextPageIndex + 1;
		if (this.nextPageIndex > totalPages) {
			this.nextPageIndex = totalPages;
		}
	}

}