package com.school.canvasing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity(name = "school_member")
@Table(name = "SCHOOL_MEMBER")
public class SchoolMember extends BaseEntity{

	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="name")
	private String name;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="status")
	private String status;
	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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
	
	
}
