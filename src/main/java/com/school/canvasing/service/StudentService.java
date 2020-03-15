package com.school.canvasing.service;

import java.util.List;
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
import com.school.canvasing.entity.ParentDetails;
import com.school.canvasing.entity.SchoolMember;
import com.school.canvasing.entity.Student;
import com.school.canvasing.exception.LoginException;
import com.school.canvasing.exception.StudentException;
import com.school.canvasing.repository.ParentDetailsRepository;
import com.school.canvasing.repository.SchoolMemberRepository;
import com.school.canvasing.repository.StudentRepository;
import com.school.canvasing.request.CreateStudentRequest;
import com.school.canvasing.request.StudentRequest;
import com.school.canvasing.view.ViewResponse;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ParentDetailsRepository parentDetailsRepository;

	@Autowired
	SchoolMemberRepository schoolMemberRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

	public ResponseEntity<ViewResponse> createStudent(CreateStudentRequest createStudentRequest) {
		checkRequest(createStudentRequest);
		SchoolMember teacher = schoolMemberRepository.findByIdAndRole(createStudentRequest.getTeacherId(),
				SchoolMemberRole.TEACHER.toString());

		if (teacher == null) {
			throw new LoginException(Constants.USER_NOT_TEACHER_TO_ADD_STUDENT);
		}

		ParentDetails parentDetails = parentDetailsRepository.findByFatherMobileAndMotherMobile(
				createStudentRequest.getFatherMobile(), createStudentRequest.getMotherMobile());
		
		if (parentDetails != null) {
			createStudentRequest.getStudentRequests().forEach(studentRequest -> {
				Student student = new Student();
				student = studentRepository.findByParentDetailsAndName(parentDetails, studentRequest.getName());
				if (student != null) {
					throw new StudentException(Constants.STUDENT_EXISTS);
				} else {
					studentRepository.save(saveStudent(parentDetails, studentRequest, teacher));
				}
			});
			ViewResponse viewResponse = new ViewResponse();
			viewResponse.setStatus(Constants.SUCCESS);
			viewResponse.setMessage(Constants.STUDENT_CREATED);
			return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
		}
		ParentDetails newParentDetails = saveParentDetails(createStudentRequest);
		List<Student> students = createStudentRequest.getStudentRequests().stream()
				.map(studentRequest -> saveStudent(newParentDetails, studentRequest, teacher)).collect(Collectors.toList());		
		studentRepository.saveAll(students);
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.STUDENT_CREATED);
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	private void checkRequest(CreateStudentRequest studentRequest) {
		if(studentRequest.getFatherAadhar().length()!=Constants.AADHAR_LENGTH) {
			
		}

	}

	private ParentDetails saveParentDetails(CreateStudentRequest studentRequest) {
		ParentDetails parentDetails = new ParentDetails();
		parentDetails.setCreatedTime(DateAndTimeUtil.now());
		parentDetails.setUpdatedTime(DateAndTimeUtil.now());
		parentDetails.setAddress(studentRequest.getAddress());
		parentDetails.setDoorNo(studentRequest.getDoorNo());
		parentDetails.setFatherAadhar(studentRequest.getFatherAadhar());
		parentDetails.setFatherMobile(studentRequest.getFatherMobile());
		parentDetails.setFatherName(studentRequest.getFatherName());
		parentDetails.setLandMark(studentRequest.getLandMark());
		parentDetails.setMotherAadhar(studentRequest.getMotherAadhar());
		parentDetails.setMotherMobile(studentRequest.getMotherMobile());
		parentDetails.setMotherName(studentRequest.getMotherName());
		parentDetails.setNoOfChildren(studentRequest.getNoOfChildren());
		return parentDetailsRepository.save(parentDetails);
	}

	private Student saveStudent(ParentDetails parentDetails, StudentRequest studentRequest, SchoolMember teacher) {
		Student student = new Student();
		student.setAdmissionClass(studentRequest.getAdmissionClass());
		student.setAge(studentRequest.getAge());
		student.setCreatedTime(DateAndTimeUtil.now());
		student.setUpdatedTime(DateAndTimeUtil.now());
		student.setDateOfBirth(studentRequest.getDateOfBirth());
		student.setGender(studentRequest.getGender());
		student.setName(studentRequest.getName());
		student.setTeacher(teacher);
		student.setParentDetails(parentDetails);
		student.setParentOrGuardianRemark(studentRequest.getParentOrGuardianRemark());
		student.setPreviousClass(studentRequest.getPreviousClass());
		student.setPreviousSchool(studentRequest.getPreviousSchool());
		student.setRelationship(studentRequest.getRelationship());
		student.setWillingness(studentRequest.getWillingness());
		return student;
	}

}
