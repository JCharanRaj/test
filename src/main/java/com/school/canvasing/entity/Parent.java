package com.school.canvasing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.school.canvasing.common.Gender;

@Entity(name = "parent")
@Table(name = "PARENT")
public class Parent extends BaseEntity{
	

	@Column(name = "name")
	private String name;
	
	@Column(name = "name")
	private String mobileNumber;
	
	@Column(name = "age")
	private long age;
	
	@Column(name = "gender")
	private Gender gender;

	public String getName() {
		return name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public long getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	
}
