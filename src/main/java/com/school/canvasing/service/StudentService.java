package com.school.canvasing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.exception.ExceptionHandle;
import com.school.canvasing.request.CreateStudentRequest;
import com.school.canvasing.view.ViewResponse;

@Service
public class StudentService {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

	public ResponseEntity<ViewResponse> createStudent(CreateStudentRequest studentRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
