package com.ssafy.happyhouse.dto;

public class Qna {
	private int qna_no;
	private String qna_title;
	private String qna_content;
	private String qna_userid;
	private String qna_datetime;
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_userid() {
		return qna_userid;
	}
	public void setQna_userid(String qna_userid) {
		this.qna_userid = qna_userid;
	}
	public String getQna_datetime() {
		return qna_datetime;
	}
	public void setQna_datetime(String qna_datetime) {
		this.qna_datetime = qna_datetime;
	}
	@Override
	public String toString() {
		return "Qna [qna_no=" + qna_no + ", qna_title=" + qna_title + ", qna_content=" + qna_content + ", qna_userid="
				+ qna_userid + ", qna_datetime=" + qna_datetime + "]";
	}

	
	
}
