package com.school.canvasing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.canvasing.entity.ParentDetails;
import com.school.canvasing.entity.SchoolMember;
import com.school.canvasing.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

	Student findByParentDetailsAndName(ParentDetails parentDetails, String name);


	@Query(value = "select coalesce(count(id),0) from student where teacher_id=?1", nativeQuery = true)
	Long getTodalStudentsByTeacher(SchoolMember schoolMember);


	List<Student> findByTeacher(SchoolMember schoolMember);


}