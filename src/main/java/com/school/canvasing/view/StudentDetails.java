package com.school.canvasing.view;

import java.time.LocalDate;

import com.school.canvasing.common.Gender;

public class StudentDetails {
	
	private long id;
	private String studentName;

	private String fatherName;
	private String fatherAadharNO;
	private String fatherMobileNO;
	private String motherName;
	private String motherAadharNO;
	private String motherMobileNO;
	private String address;
	private String doorNO;
	private String landmark;
	private long age;
	private Gender gender;
	private LocalDate dateOfBirth;
	private String previousSchool;
	private String previousClass;
	private String admissionClass;
	private String parentOrGuardianRemark;
	private String willingness;
	private String relationship;

	public String getFatherAadharNO() {
		return fatherAadharNO;
	}

	public void setFatherAadharNO(String fatherAadharNO) {
		this.fatherAadharNO = fatherAadharNO;
	}

	public String getFatherMobileNO() {
		return fatherMobileNO;
	}

	public void setFatherMobileNO(String fatherMobileNO) {
		this.fatherMobileNO = fatherMobileNO;
	}

	public String getMotherAadharNO() {
		return motherAadharNO;
	}

	public void setMotherAadharNO(String motherAadharNO) {
		this.motherAadharNO = motherAadharNO;
	}

	public String getMotherMobileNO() {
		return motherMobileNO;
	}

	public void setMotherMobileNO(String motherMobileNO) {
		this.motherMobileNO = motherMobileNO;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDoorNO() {
		return doorNO;
	}

	public void setDoorNO(String doorNO) {
		this.doorNO = doorNO;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public String getPreviousClass() {
		return previousClass;
	}

	public void setPreviousClass(String previousClass) {
		this.previousClass = previousClass;
	}

	public String getAdmissionClass() {
		return admissionClass;
	}

	public void setAdmissionClass(String admissionClass) {
		this.admissionClass = admissionClass;
	}

	public String getParentOrGuardianRemark() {
		return parentOrGuardianRemark;
	}

	public void setParentOrGuardianRemark(String parentOrGuardianRemark) {
		this.parentOrGuardianRemark = parentOrGuardianRemark;
	}

	public String getWillingness() {
		return willingness;
	}

	public void setWillingness(String willingness) {
		this.willingness = willingness;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

}
