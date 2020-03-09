package com.school.canvasing.view;

public class ViewResponse {

	private long id;
	private String status;
	private String message;
	private Object data;

	public long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	

}
