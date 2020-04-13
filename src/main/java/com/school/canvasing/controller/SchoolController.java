package com.school.canvasing.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.canvasing.command.CreateMemberCommand;
import com.school.canvasing.command.CreateStudentCommand;
import com.school.canvasing.command.GetStudentDetailsCommand;
import com.school.canvasing.command.GetStudentsCommand;
import com.school.canvasing.command.GetTeacherDetailsCommand;
import com.school.canvasing.command.GetTeacherInfoCommand;
import com.school.canvasing.command.GetTeachersCommand;
import com.school.canvasing.command.LoginSchoolMemberCommand;
import com.school.canvasing.command.LogoutCommand;
import com.school.canvasing.command.MpinCommand;
import com.school.canvasing.command.ResendOtpCommand;
import com.school.canvasing.command.SendOtpCommand;
import com.school.canvasing.command.UpdateMpinCommand;
import com.school.canvasing.command.UpdateTeacherLocationCommand;
import com.school.canvasing.command.VerifyOtpCommand;
import com.school.canvasing.exception.ErrorResponse;
import com.school.canvasing.request.CreateMemberRequest;
import com.school.canvasing.request.CreateStudentRequest;
import com.school.canvasing.request.LoginRequest;
import com.school.canvasing.request.MpinRequest;
import com.school.canvasing.request.UpdateMpinRequest;
import com.school.canvasing.request.UpdateTeacherLocation;
import com.school.canvasing.request.VerifyOtpRequest;
import com.school.canvasing.view.ViewResponse;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class SchoolController {
	
	@Autowired
	LoginSchoolMemberCommand loginSchoolMemberCommand;	
	
	@Autowired
	CreateStudentCommand createStudentCommand;
	
	@Autowired
	GetTeachersCommand getTeachersCommand;
	
	@Autowired
	CreateMemberCommand createMemberCommand;
	
	@Autowired
	UpdateTeacherLocationCommand updateTeacherLocationCommand;
	
	@Autowired
	GetTeacherInfoCommand getTeacherInfoCommand;
	
	@Autowired
	LogoutCommand logoutCommand;
	
	@Autowired
	SendOtpCommand sendOtpCommand;
	
	@Autowired
	MpinCommand mpinCommand;
	
	@Autowired
	VerifyOtpCommand verifyOtpCommand;
	
	@Autowired
	ResendOtpCommand resendOtpCommand;
	
	@Autowired
	GetStudentsCommand getStudentsCommand;
	
	@Autowired
	GetStudentDetailsCommand getStudentDetailsCommand;
	
	@Autowired
	UpdateMpinCommand updateMpinCommand;
	
	@Autowired
	GetTeacherDetailsCommand getTeacherDetailsCommand;
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> login(@RequestBody LoginRequest loginRequest) {
		return loginSchoolMemberCommand.execute(loginRequest);
	}


	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@PostMapping(value = "/createMember", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> createMember(@RequestBody CreateMemberRequest createMemberRequest) {
		return createMemberCommand.execute(createMemberRequest);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@PostMapping(value = "/createStudent", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> createStudent(@RequestBody CreateStudentRequest studentRequest) {
		return createStudentCommand.execute(studentRequest);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@GetMapping(value = "/getTeachers/{principalId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getTeachers(@PathVariable long principalId) {
		return getTeachersCommand.execute(principalId);
	}
	
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@PostMapping(value = "/updateTeacherLocation", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> updateTeacherLocation(@RequestBody UpdateTeacherLocation updateTeacherLocation) {
		return updateTeacherLocationCommand.execute(updateTeacherLocation);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters")})
	@GetMapping(value = "/getTeacherInfo/{teacherId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getTeacherInfo(@PathVariable long teacherId) {
		return getTeacherInfoCommand.execute(teacherId);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@GetMapping(value = "/logout/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> logoutSchoolMember(@PathVariable long id) {
		return logoutCommand.execute(id);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@GetMapping(value = "/sendOtp/{mobileNumber}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> updateTeacherLocation(@PathVariable String mobileNumber) {
		return sendOtpCommand.execute(mobileNumber);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@PostMapping(value = "/saveMpin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> mpinRequest(@RequestBody MpinRequest mpinRequest) {
		return mpinCommand.execute(mpinRequest);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@PostMapping(value = "/verifyOtp", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> verifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest) {
		return verifyOtpCommand.execute(verifyOtpRequest);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@GetMapping(value = "/resendOtp/{mobileNumber}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> resendOtp(@PathVariable String mobileNumber) {
		return resendOtpCommand.execute(mobileNumber);
	}
	
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@GetMapping(value = "/getStudents/{teacherId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getStudents(@PathVariable Long teacherId) {
		return getStudentsCommand.execute(teacherId);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@GetMapping(value = "/getStudentDetails/{studentId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getStudentDetails(@PathVariable Long studentId) {
		return getStudentDetailsCommand.execute(studentId);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@PostMapping(value = "/updateMpin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> verifyOtp(@RequestBody UpdateMpinRequest mpinRequest) {
		return updateMpinCommand.execute(mpinRequest);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@GetMapping(value = "/getTeacherDetails/{teacherId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getTeacherDetails(@PathVariable Long teacherId) {
		return getTeacherDetailsCommand.execute(teacherId);
	}
	
}
