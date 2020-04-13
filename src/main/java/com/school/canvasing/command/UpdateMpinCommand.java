package com.school.canvasing.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.canvasing.common.Constants;
import com.school.canvasing.exception.InValidInputException;
import com.school.canvasing.request.UpdateMpinRequest;
import com.school.canvasing.service.SchoolMemberService;
import com.school.canvasing.view.ViewResponse;

@Service
public class UpdateMpinCommand implements Command<UpdateMpinRequest, ResponseEntity<ViewResponse>> {

    @Autowired
    SchoolMemberService schoolMemberService;

	@Override
	public ResponseEntity<ViewResponse> execute(UpdateMpinRequest request) {
		
		if(request!=null && request.getMpin().length()>4) {
			throw new InValidInputException(Constants.INCORRECT_MPIN);
		}
		return schoolMemberService.updateMpin(request);
	}

}
