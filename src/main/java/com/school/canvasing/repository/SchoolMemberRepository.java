package com.school.canvasing.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.school.canvasing.entity.SchoolMember;

@RepositoryRestResource
public interface SchoolMemberRepository extends CrudRepository<SchoolMember,Long> {

	SchoolMember findByMobileNumber(String mobileNumber);

}
