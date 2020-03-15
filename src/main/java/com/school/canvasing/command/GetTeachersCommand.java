package com.school.canvasing.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.service.SchoolMemberService;
import com.school.canvasing.view.ViewResponse;

@Service
public class GetTeachersCommand implements Command<Long, ResponseEntity<ViewResponse>> {

    @Autowired
    SchoolMemberService schoolMemberService;

	@Override
	public ResponseEntity<ViewResponse> execute(Long request) {
		return schoolMemberService.getTeachers(request);
	}
    
	

}
