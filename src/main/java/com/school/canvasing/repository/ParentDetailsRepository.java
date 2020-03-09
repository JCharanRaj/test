package com.school.canvasing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.canvasing.entity.ParentDetails;

@Repository
public interface ParentDetailsRepository extends JpaRepository<ParentDetails,Long> {

	ParentDetails findByFatherMobileAndMotherMobile(String fatherMobile, String motherMobile);


}