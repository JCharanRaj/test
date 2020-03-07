package com.school.canvasing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.canvasing.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


}