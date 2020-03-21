package com.school.canvasing.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.school.canvasing.view.ViewResponse;


public class MemberAdapter {
	
	@Value("${sms.otp.service}")
	private String sms_service_url;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberAdapter.class);

	@Value("${customer.api.service}")
	private String customerApiUrl;

	private RestTemplate restTemplate = new RestTemplate();

	private String getApiUrl(String apiUrl, long id) {
		StringBuffer buffer = new StringBuffer(apiUrl);
		buffer.append(id);
		return apiUrl;
	}
	
		public void getCustomerDetails(String mobileNumber) {
		//logger.info("getCustomerDetails method started");
		String apiUrl = sms_service_url+"/"+mobileNumber;
		try {
			ResponseEntity<String> result = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);

		} catch (Exception e) {
			//throw new CustomerNotFoundException(Constants.CUSTOMER_ID_NOT_FOUND + customerId);
		}
			//return customerResponse.getBody();
	}

}
