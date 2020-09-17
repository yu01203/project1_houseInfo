package com.ssafy.happyhouse.dto;

public class SearchBean {
	private String dongName;
	private boolean type[];
	
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public boolean[] getType() {
		return type;
	}
	public void setType(boolean[] type) {
		this.type = type;
	}
	
}
