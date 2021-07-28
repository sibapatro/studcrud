package com.studentapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studentapi.entity.Student;
import com.studentapi.repository.StudentRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Operation(summary = "Retrieve all Students")
	@GetMapping("/all")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	@Operation(summary = "Find student by id ")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public Student showStudent(@PathVariable Integer id) {
		Student student = studentRepository.getById(id);
		return student;
	}
	
	@Operation(summary = "Add student")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return new ResponseEntity("Student saved successfully", HttpStatus.OK);
	}

	@Operation(summary = "Update student")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		Student studentDb = studentRepository.getById(id);
		studentDb.setFirstName(student.getFirstName());
		studentDb.setLastName(student.getLastName());
		studentDb.setNationality(student.getNationality());
		studentDb.setStudentClass(student.getStudentClass());
		studentRepository.save(studentDb);
		return new ResponseEntity("Student updated successfully", HttpStatus.OK);
	}

	@Operation(summary = "Delete a student")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
		studentRepository.deleteById(id);
		return new ResponseEntity("Student deleted successfully", HttpStatus.OK);
	}

}
