package com.school.canvasing.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.canvasing.entity.SchoolMember;
import com.school.canvasing.entity.TeacherLocation;

public interface TeacherLocationRepository extends JpaRepository<TeacherLocation,Long> {

	TeacherLocation findByTeacherAndDate(SchoolMember member, LocalDate localDate);

	@Query(value = "select coalesce(sum(distance),0) from teacher_location where teacher_id=?1", nativeQuery = true)
	Long getTodalDistanceByTeacher(SchoolMember schoolMember);

	List<TeacherLocation> findByTeacher(SchoolMember schoolMember);


}
