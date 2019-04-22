package com.knet.qsearch.apiclients.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author I301205 Stack Exchange API response DTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseDTO {
	private List<QuestionDTO> items;
	private int error_id;
	private String error_message;
	private String error_name;
	private Boolean has_more;

	public List<QuestionDTO> getItems() {
		return items;
	}

	public void setItems(List<QuestionDTO> items) {
		this.items = items;
	}

	public int getError_id() {
		return error_id;
	}

	public void setError_id(int error_id) {
		this.error_id = error_id;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public String getError_name() {
		return error_name;
	}

	public void setError_name(String error_name) {
		this.error_name = error_name;
	}

	public Boolean getHas_more() {
		return has_more;
	}

	public void setHas_more(Boolean has_more) {
		this.has_more = has_more;
	}
}