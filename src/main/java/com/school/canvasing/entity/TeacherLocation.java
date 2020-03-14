package com.school.canvasing.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "teacher_location")
@Table(name = "TEACHER_LOCATION")
public class TeacherLocation extends BaseEntity {

	@Column(name="initial_longitude")
	private String initialLongitude;

	@Column(name="initial_latitude")
	private String initialLatitude;

	@Column(name="current_longitude")
	private String currentLongitude;

	@Column(name="current_latitude")
	private String currentLatitude;

	@ManyToOne
	@JoinColumn(name = "teacher_id", nullable = false)
	private SchoolMember teacher;

	@Column(name = "date")
	private LocalDate date;

	@Column(name="distance", columnDefinition="Decimal(10,2) default '0.00'")
	private double distance;

	public String getInitialLongitude() {
		return initialLongitude;
	}

	public void setInitialLongitude(String initialLongitude) {
		this.initialLongitude = initialLongitude;
	}

	public String getInitialLatitude() {
		return initialLatitude;
	}

	public void setInitialLatitude(String initialLatitude) {
		this.initialLatitude = initialLatitude;
	}

	public String getCurrentLongitude() {
		return currentLongitude;
	}

	public void setCurrentLongitude(String currentLongitude) {
		this.currentLongitude = currentLongitude;
	}

	public String getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(String currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public SchoolMember getTeacher() {
		return teacher;
	}

	public void setTeacher(SchoolMember teacher) {
		this.teacher = teacher;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
