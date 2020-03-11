package com.school.canvasing.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.canvasing.entity.SchoolMember;
import com.school.canvasing.entity.TeacherLocation;

public interface TeacherLocationRepository extends JpaRepository<TeacherLocation,Long> {

	TeacherLocation findByTeacherAndDate(SchoolMember member, LocalDate localDate);

}
