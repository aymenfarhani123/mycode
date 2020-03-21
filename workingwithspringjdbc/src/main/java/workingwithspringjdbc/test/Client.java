package workingwithspringjdbc.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import workingwithspringjdbc.dao.StudentDao;
import workingwithspringjdbc.domain.Student;

public class Client {
	static StudentDao studentDao;

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("context-beans.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate) context.getBean("jdbctemplate");
		studentDao.dropTableIfExists();
		studentDao.createTable();
		Student s1=new Student(1,"Aymen","aymenfarhani28@gmail.com");
		Student s2=new Student(2,"Java","java28@gmail.com");
		Student s3=new Student(3,"spring","spring28@gmail.com");
		Student s4=new Student(4,"jdbctemplate","jdbctemplate28@gmail.com");
		List<Student> ss=new ArrayList<>();
		ss.add(s1);
		ss.add(s2);
		ss.add(s3);
		ss.add(s4);
		getStudentDao().saveStudent(ss);
	
		Student student=getStudentDao().findStudentById(1);
		System.out.println(student);
		System.out.println("==========================================================");
		List<Student> students=getStudentDao().findStudents();
		students.stream().forEach(System.out::println);
	}

	public static StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	

}
