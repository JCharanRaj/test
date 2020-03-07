package com.school.canvasing.exception;

import java.time.LocalDateTime;

import com.school.canvasing.common.DateAndTimeUtil;

public class ErrorResponse {
	
	private String status;
	private String message;
	private LocalDateTime timeStamp;
	private String path;

	public ErrorResponse(String status, String message, String path) {
		super();
		this.message = message;
		this.path = path;
		this.timeStamp = DateAndTimeUtil.now();
		this.status= status;
	}


	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public String getPath() {
		return path;
	}


}
