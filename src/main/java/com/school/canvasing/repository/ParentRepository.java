package com.school.canvasing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.school.canvasing.entity.Parent;

@RepositoryRestResource
public interface ParentRepository extends CrudRepository<Parent,Long> {


}