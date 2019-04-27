package com.osdepym.dto;

import java.util.List;

public class PlanSeccionDTO {
	private String title;
	private String subtitle;
	private List<PlanItemDTO> itemsList;
	
	public PlanSeccionDTO(String title, String subtitle, List<PlanItemDTO> list) {
		this.title = title;
		this.subtitle = subtitle;
		this.itemsList = list;
	}
	
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