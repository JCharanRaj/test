package com.school.canvasing.common;

public class Constants {

	private Constants() {

	}
	
	public static final String SUCCESS = "Success";
	public static final String FAILED = "Failed";
	public static final String ACTIVE = "ACTIVE";
	public static final String INACTIVE = "INACTIVE";

	public static final String USER_LOGIN = "<role> login successfully";
	public static final String USER_CREATED = "New <role> created successfully..!";
	public static final String USER_EXIST = "User already exists with this mobile number: ";
	public static final String INCORRECT_MOBILE = "incorrect mobile number";
	public static final String INCORRECT_MPIN = "incorrect mpin";
	public static final String USER_NOT_FOUND_WITH_ID = "No user found with Id: ";
	public static final String USER_NOT_FOUND = "This mobile number does not exists, please contact your Principal";
	public static final String USER_NOT_PRINCIPAL = "User not Principal to show teachers data";
	public static final String USER_NOT_TEACHER = "User not a Teacher";
	public static final String USER_NOT_TEACHER_TO_ADD_STUDENT = "User not a Teacher to add student";
	public static final String UPDATE_TEACHER_LOCATION = "Teacher location updated successfully..!";
	public static final String STUDENT_CREATED = "All students are added successfully..!";
	public static final String STUDENT_EXISTS = "Student already exists with this parent";
	public static final String USER_LOGOUT = "<role> logout successfully";
	public static final String TEACHER_NOT_FOUND = "No Teacher found with id: ";
	public static final int AADHAR_LENGTH = 12;
	
	public static final String AADHAR ="Aadhar number must be 12 charecters";
	
	
	public static final String VERIFY_MPIN = "Verify your mpin";
	public static final String OTP_SENT = "OTP sent";
	public static final String OTP_VERIFIED = "Otp verified successfully";
	public static final String INCORRECT_OTP = "incorrect otp";
	public static final String OTP_MESSAGE ="<otp> is the Onetime password (OTP) for your login. Do not share this";
	
	public static final String SMS_URL = "<sms url>?key=<sms key>&campaign=0&routeid=13&"
			+ "type=text&contacts=<mobile number>&senderid=<sender id>&msg=<message>";
	public static final String OTP_EXCEPTION_MESSAGE = "We are unable to send otp to your mobile::";

	public static final String MPIN_SAVE = "Teacher mpin saved successfully..!";
	
}
