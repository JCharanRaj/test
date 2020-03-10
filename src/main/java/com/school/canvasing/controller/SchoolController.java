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

import com.school.canvasing.command.LoginSchoolMemberCommand;
import com.school.canvasing.exception.ErrorResponse;
import com.school.canvasing.request.CreateMemberRequest;
import com.school.canvasing.request.CreateStudentRequest;
import com.school.canvasing.request.LoginRequest;
import com.school.canvasing.request.UpdateTeacherLocation;
import com.school.canvasing.service.SchoolMemberService;
import com.school.canvasing.service.StudentService;
import com.school.canvasing.view.ViewResponse;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class SchoolController {
	
	@Autowired
	LoginSchoolMemberCommand loginSchoolMemberCommand;
	
	@Autowired
	SchoolMemberService schoolMemberService;
	
	@Autowired
	StudentService studentService;
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, response = ErrorResponse.class, message = "Invalid Token / Without Token"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, response = ErrorResponse.class, message = "UnAuthorized Access") })
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> login(@RequestBody LoginRequest loginRequest) {
		return loginSchoolMemberCommand.execute(loginRequest);
	}


	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, response = ErrorResponse.class, message = "Invalid Token / Without Token"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, response = ErrorResponse.class, message = "UnAuthorized Access") })
	@PostMapping(value = "/createMember", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> createMember(@RequestBody CreateMemberRequest createMemberRequest) {
		return schoolMemberService.createMember(createMemberRequest);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, response = ErrorResponse.class, message = "Invalid Token / Without Token"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, response = ErrorResponse.class, message = "UnAuthorized Access") })
	@PostMapping(value = "/createStudent", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> createStudent(@RequestBody CreateStudentRequest studentRequest) {
		return studentService.createStudent(studentRequest);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, response = ErrorResponse.class, message = "Invalid Token / Without Token"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, response = ErrorResponse.class, message = "UnAuthorized Access") })
	@GetMapping(value = "/getTeachers/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getTeachers(@PathVariable long id) {
		return schoolMemberService.getTeachers(id);
	}
	
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, response = ErrorResponse.class, message = "Invalid Token / Without Token"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, response = ErrorResponse.class, message = "UnAuthorized Access") })
	@PostMapping(value = "/updateTeacherLocation", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> updateTeacherLocation(@RequestBody UpdateTeacherLocation updateTeacherLocation) {
		return schoolMemberService.updateTeacherLocation(updateTeacherLocation);
	}
}
