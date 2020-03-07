package com.school.canvasing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.common.Constants;
import com.school.canvasing.repository.StudentRepository;
import com.school.canvasing.request.CreateStudentRequest;
import com.school.canvasing.view.ViewResponse;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

	public ResponseEntity<ViewResponse> createStudent(CreateStudentRequest studentRequest) {
		
		
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setStatus(Constants.SUCCESS);
		viewResponse.setMessage(Constants.UPDATE_TEACHER_LOCATION);
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}
	

}
