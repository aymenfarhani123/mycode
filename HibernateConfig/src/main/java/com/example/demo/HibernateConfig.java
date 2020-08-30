package com.example.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class HibernateConfig implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateConfig.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Optional<Student> s=studentRepository.findById(2L);
		
		logger.info("Student with id 2 is {}",s.get());
		logger.info("**********************************");
		
		long nombreOfStudents=studentRepository.count();
		logger.info("The number of students is {}",nombreOfStudents);
		
	}

}
