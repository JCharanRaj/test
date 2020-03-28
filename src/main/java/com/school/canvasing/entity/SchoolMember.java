package com.school.canvasing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "school_member")
@Table(name = "SCHOOL_MEMBER")
public class SchoolMember extends BaseEntity {

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "mpin")
	private String mpin;
	
	@Column(name = "password")
	private String password;


	@Column(name = "role")
	private String role;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private String status;

	@Column(name = "login_status")
	private String loginStatus;

	@Column(name = "rank", columnDefinition = "integer default 0")
	private long rank;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMpin() {
		return mpin;
	}

	public void setMpin(String mpin) {
		this.mpin = mpin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public long getRank() {
		return rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
