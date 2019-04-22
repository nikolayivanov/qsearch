package com.knet.qsearch.apiclients.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author I301205 Stack Exchange API question owner DTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerDTO {
	private String display_name;

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
}
