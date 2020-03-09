package com.school.canvasing.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.canvasing.entity.SchoolMember;

@Repository
public interface SchoolMemberRepository extends JpaRepository<SchoolMember,Long> {

	SchoolMember findByMobileNumber(String mobileNumber);

	List<SchoolMember> findByRole(String string);

	SchoolMember findByIdAndRole(long teacherId, String string);

}
