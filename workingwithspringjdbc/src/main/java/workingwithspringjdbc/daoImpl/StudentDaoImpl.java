package workingwithspringjdbc.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import workingwithspringjdbc.dao.StudentDao;
import workingwithspringjdbc.domain.Student;


public class StudentDaoImpl implements StudentDao{
	JdbcTemplate jdbctemplate;
	DataSource dataSource;

	
	@Override
	public void dropTableIfExists() {
		String sql="DROP TABLE IF EXISTS STUDENT";
		jdbctemplate.execute(sql);
		
	}

	@Override
	public void createTable() {
		String sql="CREATE TABLE STUDENT (id bigint not null, name character varying(30),email character varying(50))";
		jdbctemplate.execute(sql);
	}
	
	@Override
	public int[] saveStudent(List<Student> students) {
		jdbctemplate=new JdbcTemplate(dataSource);
		String sqlInsert="insert into student(id,name,email) values(?,?,?)";
		int[] updateCounts = 	jdbctemplate.batchUpdate(sqlInsert, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, students.get(i).getId());
                ps.setString(2, students.get(i).getName());
                ps.setString(3, students.get(i).getEmail());
            }

            public int getBatchSize() {
                return students.size();
            }
        } );
		return updateCounts;
	}

	@Override
	public Student findStudentById(long id) {
		String selectSql="select * from student where id=?";
		Object[] params= {id};
		Student student=(Student) jdbctemplate.queryForObject(selectSql,params, new BeanPropertyRowMapper(Student.class));
		return student;
	}

	@Override
	public List<Student> findStudents() {
		String selectSql="select * from student";
		List<Student> students=jdbctemplate.query(selectSql, new BeanPropertyRowMapper(Student.class));
		return students;
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public javax.sql.DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(javax.sql.DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	
	

}
