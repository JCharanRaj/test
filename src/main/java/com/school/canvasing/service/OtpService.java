package com.school.canvasing.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.school.canvasing.adapter.MemberAdapter;
import com.school.canvasing.common.Constants;
import com.school.canvasing.common.DateAndTimeUtil;
import com.school.canvasing.entity.MemberOtp;
import com.school.canvasing.entity.SchoolMember;
import com.school.canvasing.exception.UserNotException;
import com.school.canvasing.repository.MemberOtpRepository;
import com.school.canvasing.repository.SchoolMemberRepository;
import com.school.canvasing.request.VerifyOtpRequest;
import com.school.canvasing.view.ViewResponse;

@Service
public class OtpService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OtpService.class);

	@Value("${sms.key}")
	private String smsKey;

	@Value("${sms.service}")
	private String smsServiceUrl;
	@Value("${sender.id}")
	private String senderId;

	@Autowired
	SchoolMemberRepository schoolMemberRepository;

	@Autowired
	MemberOtpRepository memberOtpRepository;

	@Autowired
	MemberAdapter memberAdapter;

	public ViewResponse sendOtp(String mobileNumber) {
		SchoolMember schoolMember = schoolMemberRepository.findByMobileNumber(mobileNumber);
		if (schoolMember == null) {
			throw new UserNotException(Constants.USER_NOT_FOUND);
		}

		MemberOtp memberOtp = memberOtpRepository.findByMobileNumber(mobileNumber);
		ViewResponse response = new ViewResponse();
		response.setStatus(Constants.SUCCESS);
		if (memberOtp != null) {
			response.setMessage(Constants.VERIFY_MPIN);
		} else {
			String otp = generateOtp(4);
			String otpResponse = memberAdapter.sendOtp(getSmsApiUrl(mobileNumber, otp), mobileNumber);
			if (otpResponse != null) {
				response.setMessage(Constants.OTP_SENT);
				MemberOtp newMemberOtp = new MemberOtp();
				newMemberOtp.setCreatedTime(DateAndTimeUtil.now());
				newMemberOtp.setMobileNumber(mobileNumber);
				newMemberOtp.setOtp(otp);
				newMemberOtp.setUpdatedTime(DateAndTimeUtil.now());
				memberOtpRepository.save(newMemberOtp);
			}
		}
		return response;
	}

	private String getSmsApiUrl(String mobileNumber, String otp) {
		String otpUrl = Constants.SMS_URL;
		String otpMessage = Constants.OTP_MESSAGE;
		otpMessage = otpMessage.replace("<otp>", otp);
		otpUrl = otpUrl.replace("<sms url>", smsServiceUrl);
		otpUrl = otpUrl.replace("<sms key>", smsKey);
		otpUrl = otpUrl.replace("<mobile number>", mobileNumber);
		otpUrl = otpUrl.replace("<sender id>", senderId);
		otpUrl = otpUrl.replace("<message>", otpMessage);
		return otpUrl;
	}

	private String generateOtp(int length) {
		String numbers = "0123456789";
		Random rndmMethod = new Random();
		char[] otp = new char[length];
		for (int i = 0; i < length; i++) {
			otp[i] = numbers.charAt(rndmMethod.nextInt(numbers.length()));
		}
		return String.valueOf(otp);
	}

	public ViewResponse get() {
		return null;
	}

	public ViewResponse verifyOtp(VerifyOtpRequest verifyOtpRequest) {
		String mobileNumber = verifyOtpRequest.getMobileNumber();
		SchoolMember schoolMember = schoolMemberRepository.findByMobileNumber(mobileNumber);
		if (schoolMember == null) {
			throw new UserNotException(Constants.USER_NOT_FOUND);
		}
		MemberOtp memberOtp = memberOtpRepository.findByMobileNumber(mobileNumber);
		ViewResponse response = new ViewResponse();
		if (memberOtp != null && verifyOtpRequest.getOtp().equalsIgnoreCase(memberOtp.getOtp())) {
			response.setStatus(Constants.SUCCESS);
			response.setMessage(Constants.OTP_VERIFIED);
		} else {
			response.setStatus(Constants.FAILED);
			response.setMessage(Constants.INCORRECT_OTP);
		}
		return response;
	}

	public ViewResponse resendOtp(String mobileNumber) {
		SchoolMember schoolMember = schoolMemberRepository.findByMobileNumber(mobileNumber);
		if (schoolMember == null) {
			throw new UserNotException(Constants.USER_NOT_FOUND);
		}
		MemberOtp memberOtp = memberOtpRepository.findByMobileNumber(mobileNumber);
		ViewResponse response = new ViewResponse();

		if (memberOtp != null) {
			String otpResponse = memberAdapter.sendOtp(getSmsApiUrl(mobileNumber, memberOtp.getOtp()), mobileNumber);
			if (otpResponse != null) {
				response.setStatus(Constants.SUCCESS);
				response.setMessage(Constants.OTP_SENT);
			} else {
				response.setStatus(Constants.FAILED);
				response.setMessage("Please try after sometime");
			}
		}
		 else {
				response.setStatus(Constants.FAILED);
				response.setMessage("Please check your mobile number");
			}
		return response;
	}

}
