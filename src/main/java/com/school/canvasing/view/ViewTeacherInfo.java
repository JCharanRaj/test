package com.school.canvasing.view;

import java.time.LocalDate;
import java.util.List;

public class ViewTeacherInfo {
	private long id;
	private long totalStudents;
	private double totalDistance;
	private List<WillingnessData> willingness;
	private long rank;
	private long attentedDays;
	private LocalDate lastTimeUsed;
	private String locationName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(long totalStudents) {
		this.totalStudents = totalStudents;
	}

	public double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public List<WillingnessData> getWillingness() {
		return willingness;
	}

	public void setWillingness(List<WillingnessData> willingness) {
		this.willingness = willingness;
	}

	public long getRank() {
		return rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	public long getAttentedDays() {
		return attentedDays;
	}

	public void setAttentedDays(long attentedDays) {
		this.attentedDays = attentedDays;
	}

	public LocalDate getLastTimeUsed() {
		return lastTimeUsed;
	}

	public void setLastTimeUsed(LocalDate lastTimeUsed) {
		this.lastTimeUsed = lastTimeUsed;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
