package com.school.canvasing.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.exception.InValidInputException;
import com.school.canvasing.request.UpdateTeacherLocation;
import com.school.canvasing.service.SchoolMemberService;
import com.school.canvasing.view.ViewResponse;

@Service
public class UpdateTeacherLocationCommand implements Command<UpdateTeacherLocation, ResponseEntity<ViewResponse>> {

	@Autowired
	SchoolMemberService schoolMemberService;

	@Override
	public ResponseEntity<ViewResponse> execute(UpdateTeacherLocation request) {
		if (request != null) {

			try {
				Double.valueOf(request.getLatitude());
				Double.valueOf(request.getLongitude());
			} catch (Exception e) {
				throw new InValidInputException("Invalid Latitude or Longitude input please check");
			}

			return schoolMemberService.updateTeacherLocation(request);
		} else {
			throw new InValidInputException("");
		}

	}

}
