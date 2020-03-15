package com.school.canvasing.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.request.UpdateTeacherLocation;
import com.school.canvasing.service.SchoolMemberService;
import com.school.canvasing.view.ViewResponse;

@Service
public class UpdateTeacherLocationCommand implements Command<UpdateTeacherLocation, ResponseEntity<ViewResponse>> {

    @Autowired
    SchoolMemberService schoolMemberService;

	@Override
	public ResponseEntity<ViewResponse> execute(UpdateTeacherLocation request) {
		return schoolMemberService.updateTeacherLocation(request);
	}
    
	

}
