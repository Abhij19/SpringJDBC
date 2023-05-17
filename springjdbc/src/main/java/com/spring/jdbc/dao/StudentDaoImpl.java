package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		 // Insert query
        String query="insert into student(id,name,city) values(?,?,?)";
        int r=jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}

	public int change(Student student) {
		// Update single id
		String query="update student set name=? , city=? where id=?";
        int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}

	public int delete(int studentId) {
		// Delete single id
		String query="delete from student where id=?";
        int r=this.jdbcTemplate.update(query,studentId);
		return r;
	}

	public Student getStudent(int studentId) {
		//Select one object
		String query="Select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		// Select multiple objects
		String query="Select * from student";
		List<Student> student=this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}
	
}
