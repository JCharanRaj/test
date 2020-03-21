package com.school.canvasing.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.school.canvasing.common.Constants;
import com.school.canvasing.exception.MemberOtpException;

@Service
public class MemberAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberAdapter.class);

	@Value("${sms.key}")
	private String smsKey;

	@Value("${sms.service}")
	private String smsServiceUrl;
	@Value("${sender.id}")
	private String senderId;

	private RestTemplate restTemplate = new RestTemplate();


	public String sendOtp(String apiUrl,String mobileNumber) {
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);

		} catch (Exception exception) {
			LOGGER.info("Exception occured while sending otp, Cause:: "+exception.getMessage());
			throw new MemberOtpException(Constants.OTP_EXCEPTION_MESSAGE+mobileNumber);
		}
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new MemberOtpException(Constants.OTP_EXCEPTION_MESSAGE+mobileNumber);
		}
		return response.getBody();		
	}

}
