package com.school.canvasing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.common.Constants;
import com.school.canvasing.common.DateAndTimeUtil;
import com.school.canvasing.entity.SchoolMember;
import com.school.canvasing.exception.LoginException;
import com.school.canvasing.exception.UserNotException;
import com.school.canvasing.repository.SchoolMemberRepository;
import com.school.canvasing.request.CreateMemberRequest;
import com.school.canvasing.request.LoginRequest;
import com.school.canvasing.view.ViewResponse;

@Service
public class SchoolMemberService {

	@Autowired
	SchoolMemberRepository schoolMemberRepository;

	public ResponseEntity<ViewResponse> loginSchoolMember(LoginRequest loginRequest) {
		SchoolMember schoolMember = schoolMemberRepository.findByMobileNumber(loginRequest.getMobileNumber());
		if (schoolMember == null) {
			throw new UserNotException(Constants.USER_NOT_FOUND + loginRequest.getMobileNumber());
		}

		if (!loginRequest.getMobileNumber().equalsIgnoreCase(schoolMember.getMobileNumber())) {
			throw new LoginException(Constants.INCORRECT_MOBILE);
		}
		if (!loginRequest.getPassword().equals(schoolMember.getPassword())) {
			throw new LoginException(Constants.INCORRECT_PASSWORD);
		}

		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(schoolMember.getRowId());
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.USER_LOGIN.replace("<role>", schoolMember.getRole()));
		viewResponse.setRole(schoolMember.getRole());
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	public ResponseEntity<ViewResponse> createMember(CreateMemberRequest createMemberRequest) {
		SchoolMember schoolMember = schoolMemberRepository.findByMobileNumber(createMemberRequest.getMobileNumber());
		if (schoolMember != null) {
			throw new LoginException(Constants.USER_EXIST + createMemberRequest.getMobileNumber());
		}

		SchoolMember member = new SchoolMember();
		member.setCreatedTime(DateAndTimeUtil.now());
		member.setUpdatedTime(DateAndTimeUtil.now());
		member.setMobileNumber(createMemberRequest.getMobileNumber());
		member.setPassword(createMemberRequest.getPassword());
		member.setRole(createMemberRequest.getRole().toString());
		schoolMemberRepository.save(member);
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(member.getRowId());
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.USER_CREATED.replace("<role>", member.getRole()));
		viewResponse.setRole(member.getRole());
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}
	
}
