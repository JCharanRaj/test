package com.school.canvasing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "parent_details")
@Table(name = "PARENT_DETAILS")
public class ParentDetails extends BaseEntity {


	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name = "father_mobile")
	private String fatherMobile;
	
	@Column(name = "mother_mobile")
	private String motherMobile;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "no_of_children")
	private int noOfChildren;
	
	@Column(name = "door_no")
	private String doorNo;
	
	@Column(name = "father_aadhar")
	private String fatherAadhar;
	
	@Column(name = "mother_aadhar")
	private String motherAadhar;
	
	@Column(name = "land_mark")
	private String landMark;

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherMobile() {
		return fatherMobile;
	}

	public void setFatherMobile(String fatherMobile) {
		this.fatherMobile = fatherMobile;
	}

	public String getMotherMobile() {
		return motherMobile;
	}

	public void setMotherMobile(String motherMobile) {
		this.motherMobile = motherMobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getFatherAadhar() {
		return fatherAadhar;
	}

	public void setFatherAadhar(String fatherAadhar) {
		this.fatherAadhar = fatherAadhar;
	}

	public String getMotherAadhar() {
		return motherAadhar;
	}

	public void setMotherAadhar(String motherAadhar) {
		this.motherAadhar = motherAadhar;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	
	
	
}
