package com.school.canvasing.request;

import com.school.canvasing.common.SchoolMemberRole;

public class CreateMemberRequest {
	
	private String mobileNumber;
	private String password;
	private SchoolMemberRole role;
	private String name;
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public SchoolMemberRole getRole() {
		return role;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(SchoolMemberRole role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
