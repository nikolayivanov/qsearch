package com.knet.qsearch.core;

import java.util.Date;

/**
 * @author I301205
 * Questions search result item.
 */
public class QuestionsSearchResult {

	private Date creationdate;
	private Boolean isanswered;
	private String title;
	private String ownerdisplayname;
	private String url;

	public Date getCreationDate() {
		return creationdate;
	}

	public void setCreationDate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Boolean getIsAnswered() {
		return isanswered;
	}

	public void setIsAnswered(Boolean isanswered) {
		this.isanswered = isanswered;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOwnerDisplayName() {
		return ownerdisplayname;
	}

	public void setOwnerDisplayName(String ownerdisplayname) {
		this.ownerdisplayname = ownerdisplayname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
