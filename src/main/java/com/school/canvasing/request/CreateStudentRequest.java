package com.school.canvasing.request;

import java.time.LocalDate;

import com.school.canvasing.common.Gender;

public class CreateStudentRequest {

	private String name;
	private Gender gender;
	private String fatherName;
	private String motherName;
	private String fatherMobile;
	private String motherMobile;
	private String address;
	private int noOfChildren;
	private String doorNo;
	private long fatherAdhar;
	private long motherAdhar;
	private String landMark;
	private String relationship;
	private LocalDate dateOfBirth;
	private String previousSchool;
	private int previousClass;
	private int admissionClass;
	private String parentOrGuardianRemark;
	private long teacherId;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
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
	
	public long getFatherAdhar() {
		return fatherAdhar;
	}
	public void setFatherAdhar(long fatherAdhar) {
		this.fatherAdhar = fatherAdhar;
	}
	public long getMotherAdhar() {
		return motherAdhar;
	}
	public void setMotherAdhar(long motherAdhar) {
		this.motherAdhar = motherAdhar;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPreviousSchool() {
		return previousSchool;
	}
	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}
	public int getPreviousClass() {
		return previousClass;
	}
	public void setPreviousClass(int previousClass) {
		this.previousClass = previousClass;
	}
	public int getAdmissionClass() {
		return admissionClass;
	}
	public void setAdmissionClass(int admissionClass) {
		this.admissionClass = admissionClass;
	}
	public String getParentOrGuardianRemark() {
		return parentOrGuardianRemark;
	}
	public void setParentOrGuardianRemark(String parentOrGuardianRemark) {
		this.parentOrGuardianRemark = parentOrGuardianRemark;
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	} 
	
	
}
