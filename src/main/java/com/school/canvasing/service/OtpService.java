package com.school.canvasing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.canvasing.common.Constants;
import com.school.canvasing.entity.MemberOtp;
import com.school.canvasing.repository.MemberOtpRepository;
import com.school.canvasing.repository.SchoolMemberRepository;
import com.school.canvasing.view.ViewResponse;

@Service
public class OtpService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OtpService.class);

	@Autowired
	SchoolMemberRepository schoolMemberRepository;

	@Autowired
	MemberOtpRepository memberOtpRepository;

	public ViewResponse sendOtp(String mobileNumber) {
		MemberOtp memberOtp = memberOtpRepository.findByMobileNumber(mobileNumber);
		ViewResponse response = new ViewResponse();
		response.setStatus(Constants.SUCCESS);
		if (memberOtp != null) {			
			
			response.setMessage(Constants.VERIFY_MPIN);
		} else {
			// write 
			response.setMessage(Constants.OTP_SENT);
		}
		return response;
	}

	private String getMessage(String number, String message) {
		String string = "http://sms.bookurl.in/app/smsapi/index.php?key=25E103340373C0&campaign=0&routeid=13&type=text&contacts=98012XXXXX&"
				+ "senderid=TXTDMO&msg=Hello+People%2C+have+a+great+day";

		return null;

	}

}
