package com.atos.springboot.dtos;

import org.springframework.data.domain.Page;

@SuppressWarnings("rawtypes")
public class PageResult<T extends Page> {

	private int		currentPage;
	private int		begin;
	private int		end;
	private int		totalPages;
	private int		itemsPerPage;
	private T		pageable;
	private String	firstUrl;
	private String	lastUrl;
	private String	prevUrl;
	private String	nextUrl;
	private String  baseUrl;

	public PageResult(T page, String baseUrl) {
		this.baseUrl = baseUrl;
		this.pageable = page;
		this.currentPage = page.getNumber() + 1;
		this.begin = Math.max(1, this.currentPage - 5);
		this.itemsPerPage = page.getNumberOfElements();
		this.end = Math.min(this.begin + 10, page.getTotalPages()-1);
		this.firstUrl = this.baseUrl + "/0/";
		this.lastUrl = this.baseUrl + "/" + (this.pageable.getTotalPages() -1) + "/";
		this.prevUrl = this.baseUrl +  "/" + (this.currentPage - 2) + "/";
		this.nextUrl = this.baseUrl + "/" + (this.currentPage) + "/";
		this.totalPages = page.getTotalPages()-1;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public T getPageable() {
		return pageable;
	}

	public void setPageable(T pageable) {
		this.pageable = pageable;
	}

	public String getFirstUrl() {
		return firstUrl;
	}

	public void setFirstUrl(String firstUrl) {
		this.firstUrl = firstUrl;
	}

	public String getLastUrl() {
		return lastUrl;
	}

	public void setLastUrl(String lastUrl) {
		this.lastUrl = lastUrl;
	}

	public String getPrevUrl() {
		return prevUrl;
	}

	public void setPrevUrl(String prevUrl) {
		this.prevUrl = prevUrl;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

}
