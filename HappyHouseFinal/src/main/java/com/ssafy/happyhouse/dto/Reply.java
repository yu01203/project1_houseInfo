package com.ssafy.happyhouse.dto;

public class Reply {
	private int reply_no;
	private String reply_content;
	private String reply_userid;
	private String reply_datetime;
	private int qna_no;
	
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_userid() {
		return reply_userid;
	}
	public void setReply_userid(String reply_userid) {
		this.reply_userid = reply_userid;
	}
	public String getReply_datetime() {
		return reply_datetime;
	}
	public void setReply_datetime(String reply_datetime) {
		this.reply_datetime = reply_datetime;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	@Override
	public String toString() {
		return "Reply [reply_no=" + reply_no + ", reply_content=" + reply_content + ", reply_userid=" + reply_userid
				+ ", reply_datetime=" + reply_datetime + ", qna_no=" + qna_no + "]";
	}

	

	
	
}
