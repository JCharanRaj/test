package com.school.canvasing.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.canvasing.common.Gender;

@Entity(name = "student")
@Table(name = "STUDENT")
public class Student extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private long age;

	@Column(name = "gender")
	private Gender gender;

	@ManyToOne
    @JoinColumn(name = "parent_details_id", nullable = false)
    private ParentDetails parentDetails;
	
	@ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private SchoolMember teacher;	


	@Column(name = "relationship")
	private String relationship;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "previous_school")
	private String previousSchool;

	@Column(name = "previous_class")
	private String previousClass;

	@Column(name = "admission_class")
	private String admissionClass;

	@Column(name = "parent_or_guardian_remark")
	private String parentOrGuardianRemark;

	@Column(name = "willingness")
	private String willingness;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public ParentDetails getParentDetails() {
		return parentDetails;
	}

	public void setParentDetails(ParentDetails parentDetails) {
		this.parentDetails = parentDetails;
	}

	public SchoolMember getTeacher() {
		return teacher;
	}

	public void setTeacher(SchoolMember teacher) {
		this.teacher = teacher;
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
