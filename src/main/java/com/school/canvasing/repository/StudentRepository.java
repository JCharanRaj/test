package com.school.canvasing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.school.canvasing.entity.Student;

@RepositoryRestResource
public interface StudentRepository extends CrudRepository<Student,Long> {


}