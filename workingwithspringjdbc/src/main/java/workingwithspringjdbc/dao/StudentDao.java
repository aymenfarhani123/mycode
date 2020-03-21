package workingwithspringjdbc.dao;

import java.util.List;

import workingwithspringjdbc.domain.Student;

public interface StudentDao {
	
	public void dropTableIfExists();
	public void createTable();
	public int[] saveStudent(List<Student> students);
	public Student findStudentById(long id);
	public List<Student> findStudents();

}
