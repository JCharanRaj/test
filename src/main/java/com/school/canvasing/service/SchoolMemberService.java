package com.school.canvasing.service;

import java.util.List;
import java.util.Optional;
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
import com.school.canvasing.entity.TeacherLocation;
import com.school.canvasing.exception.ExceptionHandle;
import com.school.canvasing.exception.LoginException;
import com.school.canvasing.exception.UserNotException;
import com.school.canvasing.repository.SchoolMemberRepository;
import com.school.canvasing.repository.TeacherLocationRepository;
import com.school.canvasing.request.CreateMemberRequest;
import com.school.canvasing.request.LoginRequest;
import com.school.canvasing.request.UpdateTeacherLocation;
import com.school.canvasing.view.ViewResponse;
import com.school.canvasing.view.ViewTeacher;
import com.school.canvasing.view.ViewUser;

@Service
public class SchoolMemberService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

	@Autowired
	SchoolMemberRepository schoolMemberRepository;

	@Autowired
	TeacherLocationRepository teacherLocationRepository;

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
		schoolMember.setLoginStatus(Constants.ACTIVE);
		schoolMember.setUpdatedTime(DateAndTimeUtil.now());
		schoolMemberRepository.save(schoolMember);
		ViewUser viewUser = new ViewUser();
		viewUser.setRole(schoolMember.getRole());
		viewUser.setId(schoolMember.getId());
		viewUser.setUserName(schoolMember.getName());
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(schoolMember.getId());
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.USER_LOGIN.replace("<role>", schoolMember.getRole()));
		viewResponse.setData(viewUser);
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
		viewResponse.setId(member.getId());
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.USER_CREATED.replace("<role>", member.getRole()));

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
		List<ViewTeacher> teachers = schoolMembers.stream().map(member -> getTeacher(member))
				.collect(Collectors.toList());
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.UPDATE_TEACHER_LOCATION);
		viewResponse.setData(teachers);
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	private ViewTeacher getTeacher(SchoolMember member) {
		ViewTeacher teacher = new ViewTeacher();
		teacher.setId(member.getId());
		TeacherLocation teacherLocation = teacherLocationRepository.findByTeacherAndDate(member,
				DateAndTimeUtil.now().toLocalDate());
		if (teacherLocation != null) {
			teacher.setLatitude(teacherLocation.getCurrentLatitude());
			teacher.setLongitude(teacherLocation.getCurrentLongitude());
			teacher.setDistance(teacherLocation.getDistance());
		}
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
		TeacherLocation teacherLocation = teacherLocationRepository.findByTeacherAndDate(member,
				DateAndTimeUtil.now().toLocalDate());
		if (teacherLocation == null) {
			TeacherLocation newTeacherLocation = new TeacherLocation();
			newTeacherLocation.setInitialLatitude(updateTeacherLocation.getLatitude());
			newTeacherLocation.setInitialLongitude(updateTeacherLocation.getLongitude());
			newTeacherLocation.setCurrentLatitude(updateTeacherLocation.getLatitude());
			newTeacherLocation.setCurrentLongitude(updateTeacherLocation.getLongitude());
			newTeacherLocation.setCreatedTime(DateAndTimeUtil.now());
			newTeacherLocation.setUpdatedTime(DateAndTimeUtil.now());
			newTeacherLocation.setDate(DateAndTimeUtil.now().toLocalDate());
			newTeacherLocation.setTeacher(member);
			teacherLocationRepository.save(newTeacherLocation);
		} else {
			double distance = distance(teacherLocation.getCurrentLatitude(), teacherLocation.getCurrentLongitude(),
					updateTeacherLocation.getLatitude(), updateTeacherLocation.getLongitude());
			teacherLocation.setCurrentLatitude(updateTeacherLocation.getLatitude());
			teacherLocation.setCurrentLongitude(updateTeacherLocation.getLongitude());
			teacherLocation.setUpdatedTime(DateAndTimeUtil.now());
			teacherLocation.setDistance(teacherLocation.getDistance()+distance);
			teacherLocationRepository.save(teacherLocation);
		}
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(member.getId());
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.UPDATE_TEACHER_LOCATION);
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	public ResponseEntity<ViewResponse> logoutSchoolMember(long id) {
		Optional<SchoolMember> schoolMemberOptional = schoolMemberRepository.findById(id);

		if (!schoolMemberOptional.isPresent()) {
			throw new UserNotException(Constants.USER_NOT_FOUND_WITH_ID + id);
		}
		SchoolMember schoolMember = schoolMemberOptional.get();
		schoolMember.setLoginStatus(Constants.INACTIVE);
		schoolMember.setUpdatedTime(DateAndTimeUtil.now());
		schoolMemberRepository.save(schoolMember);
		ViewUser viewUser = new ViewUser();
		viewUser.setRole(schoolMember.getRole());
		viewUser.setId(schoolMember.getId());
		viewUser.setUserName(schoolMember.getName());
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(schoolMember.getId());
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.USER_LOGOUT.replace("<role>", schoolMember.getRole()));
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	private static double distance(double latitude1, double longitude1, double latitude2, double longitude2) {
		if ((latitude1 == latitude2) && (longitude1 == longitude2)) {
			return 0;
		} else {
			double theta = longitude1 - longitude2;
			double dist = Math.sin(Math.toRadians(latitude1)) * Math.sin(Math.toRadians(latitude2))
					+ Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
							* Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			return (dist * 1.609344);
		}
	}
}
