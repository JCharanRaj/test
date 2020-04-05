package com.school.canvasing.view;

import java.time.LocalDate;

import com.school.canvasing.common.Gender;

public class StudentDetails {
	private long id;
	private String studentName;
	private String motherName;
	private String fatherName;
	private String location;
	private long age;
	private Gender gender;
	private LocalDate dateOfBirth;
	private String previousSchool;
	private String previousClass;
	private String admissionClass;
	private String parentOrGuardianRemark;
	private String willingness;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

}
