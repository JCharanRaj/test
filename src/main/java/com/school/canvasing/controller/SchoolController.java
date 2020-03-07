package com.school.canvasing.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.canvasing.command.LoginSchoolMemberCommand;
import com.school.canvasing.exception.ErrorResponse;
import com.school.canvasing.request.CreateMemberRequest;
import com.school.canvasing.request.LoginRequest;
import com.school.canvasing.service.SchoolMemberService;
import com.school.canvasing.view.ViewResponse;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1")
@CrossOrigin(origins = "*")
public class SchoolController {
	
	@Autowired
	LoginSchoolMemberCommand loginSchoolMemberCommand;
	
	@Autowired
	SchoolMemberService schoolMemberService;
	
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
}
