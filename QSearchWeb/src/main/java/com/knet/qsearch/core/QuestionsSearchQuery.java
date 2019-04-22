package com.knet.qsearch.core;

/**
 * @author I301205
 * Questions search query.
 */
public class QuestionsSearchQuery {
	private String query;
	private long pagenum = 1;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public long getPagenum() {
		return pagenum;
	}

	public void setPagenum(long pagenum) {
		this.pagenum = pagenum;
	}
}
