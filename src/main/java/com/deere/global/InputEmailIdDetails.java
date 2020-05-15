package com.deere.global;

public class InputEmailIdDetails {
	
	private String emailId,flag;
	
	
	public InputEmailIdDetails() {
		this.emailId = "";
		this.flag = "N";

	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmaild(String emailId) {
		this.emailId = emailId;
	}

	public String getExecute() {
		return flag;
	}

	public void setExecute(String flag) {
		this.flag = flag;
	}

}
