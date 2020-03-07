package com.school.canvasing.view;

import com.school.canvasing.common.Gender;

public class ViewStudents {

	private long id;
	private String name;
	private long age;
	private Gender gender;
	private String teacherName;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}
