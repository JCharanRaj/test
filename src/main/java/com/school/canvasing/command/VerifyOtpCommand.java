package com.school.canvasing.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.request.VerifyOtpRequest;
import com.school.canvasing.service.OtpService;
import com.school.canvasing.view.ViewResponse;
@Service
public class VerifyOtpCommand implements Command<VerifyOtpRequest, ResponseEntity<ViewResponse>> {

	    @Autowired
	    OtpService otpService;

		@Override
		public ResponseEntity<ViewResponse> execute(VerifyOtpRequest verifyOtpRequest) {
			
			return ResponseEntity.status(HttpStatus.OK).body(otpService.verifyOtp(verifyOtpRequest));
		}

	}
