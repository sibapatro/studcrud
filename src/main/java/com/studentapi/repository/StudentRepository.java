package com.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}
