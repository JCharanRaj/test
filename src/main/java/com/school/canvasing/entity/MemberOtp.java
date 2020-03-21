package com.school.canvasing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "member_otp")
@Table(name = "MEMBER_OTP")
public class MemberOtp extends BaseEntity{
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="otp")
	private String otp;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
}
