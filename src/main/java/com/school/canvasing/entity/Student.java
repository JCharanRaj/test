package com.school.canvasing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.school.canvasing.common.Gender;


@Entity(name = "student")
@Table(name = "STUDENT")
public class Student extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private long age;
	
	@Column(name = "gender")
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private SchoolMember teacher;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Parent parent;

	public String getName() {
		return name;
	}

	public long getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public SchoolMember getTeacher() {
		return teacher;
	}

	public Parent getParent() {
		return parent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setTeacher(SchoolMember teacher) {
		this.teacher = teacher;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
}
