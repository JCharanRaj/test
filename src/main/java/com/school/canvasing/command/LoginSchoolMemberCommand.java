package com.school.canvasing.command;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.request.LoginRequest;
import com.school.canvasing.service.SchoolMemberService;
import com.school.canvasing.view.ViewResponse;


@Service
public class LoginSchoolMemberCommand implements Command<LoginRequest, ResponseEntity<ViewResponse>> {

    @Autowired
    SchoolMemberService schoolMemberService;
    
	public ResponseEntity<ViewResponse> execute(LoginRequest loginRequest) {

	       
        return schoolMemberService.loginSchoolMember(loginRequest);
	}


}
