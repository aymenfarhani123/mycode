package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/all")
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") Long id) {
		return studentRepository.findOne(id);
	}
	
	@PostMapping("/addStudent")
	public Student createStudent(@RequestBody Student s) {
		return studentRepository.save(s);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		studentRepository.delete(id);
	}

}
