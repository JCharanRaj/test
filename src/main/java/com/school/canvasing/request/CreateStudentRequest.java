package com.school.canvasing.request;

import java.util.List;

public class CreateStudentRequest {

	private String fatherName;
	private String motherName;
	private String fatherMobile;
	private String motherMobile;
	private String address;
	private int noOfChildren;
	private String doorNo;
	private String fatherAadhar;
	private String motherAadhar;
	private String landMark;	
	private long teacherId;	
	private List<StudentRequest>  studentRequests;
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
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	public List<StudentRequest> getStudentRequests() {
		return studentRequests;
	}
	public void setStudentRequests(List<StudentRequest> studentRequests) {
		this.studentRequests = studentRequests;
	}


	
	
}
