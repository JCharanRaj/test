package com.school.canvasing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.canvasing.entity.MemberOtp;


@Repository
public interface MemberOtpRepository extends JpaRepository<MemberOtp,Long> {

	MemberOtp findByMobileNumber(String mobileNumber);
  

}
