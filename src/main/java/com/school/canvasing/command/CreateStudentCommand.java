package com.school.canvasing.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.request.CreateStudentRequest;
import com.school.canvasing.service.StudentService;
import com.school.canvasing.view.ViewResponse;

@Service
public class CreateStudentCommand implements Command<CreateStudentRequest, ResponseEntity<ViewResponse>> {

	@Autowired
	StudentService studentService;
	
	@Override
	public ResponseEntity<ViewResponse> execute(CreateStudentRequest request) {
		
		return studentService.createStudent(request);
	}

    


}
