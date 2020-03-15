package com.school.canvasing.request;

import java.time.LocalDate;

import com.school.canvasing.common.Gender;

public class StudentRequest {

	private String name;
	private String relationship;
	private int age;
	private LocalDate dateOfBirth;
	private String previousSchool;
	private String previousClass;
	private String admissionClass;
	private String parentOrGuardianRemark;
	private Gender gender;
	private String willingness;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getWillingness() {
		return willingness;
	}

	public void setWillingness(String willingness) {
		this.willingness = willingness;
	}

}
