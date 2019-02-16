package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class RestFullUserApplication implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(RestFullUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.save(new Student("Aymen", "Farhani"));
		studentRepository.save(new Student("Spring", "boot"));
		studentRepository.save(new Student("Spring", "data"));
		
	}

}

