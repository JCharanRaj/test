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

	@Column(name="initial_longitude", columnDefinition="Decimal(10,2) default '0.00'")
	private double initialLongitude;

	@Column(name="initial_latitude", columnDefinition="Decimal(10,2) default '0.00'")
	private double initialLatitude;

	@Column(name="current_longitude", columnDefinition="Decimal(10,2) default '0.00'")
	private double currentLongitude;

	@Column(name="current_latitude", columnDefinition="Decimal(10,2) default '0.00'")
	private double currentLatitude;

	@ManyToOne
	@JoinColumn(name = "teacher_id", nullable = false)
	private SchoolMember teacher;

	@Column(name = "date")
	private LocalDate date;

	@Column(name="distance", columnDefinition="Decimal(10,2) default '0.00'")
	private double distance;

	public double getInitialLongitude() {
		return initialLongitude;
	}

	public void setInitialLongitude(double initialLongitude) {
		this.initialLongitude = initialLongitude;
	}

	public double getInitialLatitude() {
		return initialLatitude;
	}

	public void setInitialLatitude(double initialLatitude) {
		this.initialLatitude = initialLatitude;
	}

	public double getCurrentLongitude() {
		return currentLongitude;
	}

	public void setCurrentLongitude(double currentLongitude) {
		this.currentLongitude = currentLongitude;
	}

	public double getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
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
