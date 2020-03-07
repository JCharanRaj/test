package com.school.canvasing.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.common.Constants;
import com.school.canvasing.common.DateAndTimeUtil;
import com.school.canvasing.common.SchoolMemberRole;
import com.school.canvasing.entity.SchoolMember;
import com.school.canvasing.exception.ExceptionHandle;
import com.school.canvasing.exception.LoginException;
import com.school.canvasing.exception.UserNotException;
import com.school.canvasing.repository.SchoolMemberRepository;
import com.school.canvasing.request.CreateMemberRequest;
import com.school.canvasing.request.CreateStudentRequest;
import com.school.canvasing.request.LoginRequest;
import com.school.canvasing.request.UpdateTeacherLocation;
import com.school.canvasing.view.ViewResponse;
import com.school.canvasing.view.ViewTeacher;

@Service
public class SchoolMemberService {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);
	

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
		member.setName(createMemberRequest.getName());
		schoolMemberRepository.save(member);
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(member.getRowId());
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.USER_CREATED.replace("<role>", member.getRole()));
		viewResponse.setRole(member.getRole());
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	public ResponseEntity<ViewResponse> getTeachers(long id) {
		Optional<SchoolMember> schoolMember = schoolMemberRepository.findById(id);
		if (!schoolMember.isPresent()) {
			throw new UserNotException(Constants.USER_NOT_FOUND_WITH_ID + id);
		}

		if (!schoolMember.get().getRole().equalsIgnoreCase(SchoolMemberRole.PRINCIPAL.toString())) {
			throw new LoginException(Constants.USER_NOT_PRINCIPAL);
		}

		List<SchoolMember> schoolMembers = schoolMemberRepository.findByRole(SchoolMemberRole.TEACHER.toString());
		List<ViewTeacher>  teachers= schoolMembers.stream().map(member -> getTeacher(member)).collect(Collectors.toList());
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.UPDATE_TEACHER_LOCATION);
		viewResponse.setData(teachers);
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	private ViewTeacher getTeacher(SchoolMember member) {
		ViewTeacher teacher = new ViewTeacher();
		teacher.setId(member.getRowId());
		teacher.setLatitude(member.getLatitude());
		teacher.setLongitude(member.getLongitude());
		teacher.setName(member.getName());
		return teacher;
	}

	public ResponseEntity<ViewResponse> updateTeacherLocation(UpdateTeacherLocation updateTeacherLocation) {
		Optional<SchoolMember> schoolMember = schoolMemberRepository.findById(updateTeacherLocation.getId());
		if (!schoolMember.isPresent()) {
			throw new UserNotException(Constants.USER_NOT_FOUND + updateTeacherLocation.getId());
		}

		if (!schoolMember.get().getRole().equalsIgnoreCase(SchoolMemberRole.TEACHER.toString())) {
			throw new LoginException(Constants.USER_NOT_TEACHER);
		}
		SchoolMember member = schoolMember.get();
		member.setLatitude(updateTeacherLocation.getLatitude());
		member.setLongitude(updateTeacherLocation.getLongitude());
		member.setUpdatedTime(DateAndTimeUtil.now());
		schoolMemberRepository.save(member);
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(member.getRowId());
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.UPDATE_TEACHER_LOCATION);
		viewResponse.setRole(member.getRole());
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

}
