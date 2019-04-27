package com.osdepym.dto;

import java.util.List;

public class PlanSectionDTO {
	private String title;
	private String subtitle;
	private List<PlanItemDTO> itemsList;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public List<PlanItemDTO> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<PlanItemDTO> itemsList) {
		this.itemsList = itemsList;
	}
}
