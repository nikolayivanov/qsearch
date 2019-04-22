package com.knet.qsearch.apiclients.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author I301205 Stack Exchange API question DTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {
	private OwnerDTO owner;
	private Boolean is_answered;
	private Date creation_date;
	private String link;
	private String title;

	public OwnerDTO getOwner() {
		return owner;
	}

	public void setOwner(OwnerDTO owner) {
		this.owner = owner;
	}

	public Boolean getIs_answered() {
		return is_answered;
	}

	public void setIs_answered(Boolean is_answered) {
		this.is_answered = is_answered;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
