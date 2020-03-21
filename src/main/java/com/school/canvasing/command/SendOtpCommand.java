package com.school.canvasing.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.service.OtpService;
import com.school.canvasing.service.SchoolMemberService;
import com.school.canvasing.view.ViewResponse;

@Service
public class SendOtpCommand implements Command<String, ResponseEntity<ViewResponse>> {

    @Autowired
    OtpService otpService;

	@Override
	public ResponseEntity<ViewResponse> execute(String mobileNumber) {
		
		return ResponseEntity.status(HttpStatus.OK).body(otpService.sendOtp(mobileNumber));
	}

}
