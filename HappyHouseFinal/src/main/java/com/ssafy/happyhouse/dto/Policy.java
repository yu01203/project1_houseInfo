package com.ssafy.happyhouse.dto;

public class Policy {
	private int policy_no;
	private String policy_title;
	private String policy_content;
	private String policy_userid;
	private String policy_datetime;
	public int getPolicy_no() {
		return policy_no;
	}
	public void setPolicy_no(int policy_no) {
		this.policy_no = policy_no;
	}
	public String getPolicy_title() {
		return policy_title;
	}
	public void setPolicy_title(String policy_title) {
		this.policy_title = policy_title;
	}
	public String getPolicy_content() {
		return policy_content;
	}
	public void setPolicy_content(String policy_content) {
		this.policy_content = policy_content;
	}
	public String getPolicy_userid() {
		return policy_userid;
	}
	public void setPolicy_userid(String policy_userid) {
		this.policy_userid = policy_userid;
	}
	public String getPolicy_datetime() {
		return policy_datetime;
	}
	public void setPolicy_datetime(String policy_datetime) {
		this.policy_datetime = policy_datetime;
	}
	@Override
	public String toString() {
		return "Policy [policy_no=" + policy_no + ", policy_title=" + policy_title + ", policy_content="
				+ policy_content + ", policy_userid=" + policy_userid + ", policy_datetime=" + policy_datetime + "]";
	}
	
	
	
}
