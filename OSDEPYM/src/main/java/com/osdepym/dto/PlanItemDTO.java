package com.osdepym.dto;

import java.util.List;

public class PlanItemDTO {
	private String title;
	private String value;
	private List<PlanItemDTO> subitemsList;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<PlanItemDTO> getSubitemsList() {
		return subitemsList;
	}
	public void setSubitemsList(List<PlanItemDTO> subitemsList) {
		this.subitemsList = subitemsList;
	}
}
