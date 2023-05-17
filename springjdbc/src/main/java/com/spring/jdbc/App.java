package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        // Insert
//        Student student=new Student();
//        student.setId(333);
//        student.setName("Raj");
//        student.setCity("Noida");
//        int result=studentDao.insert(student);
        
        // Update
//        Student student=new Student();
//        student.setId(222);
//        student.setName("Rahul Shah");
//        student.setCity("Fiji");
//        int result=studentDao.change(student);
//        System.out.println(result);
        
//        Delete
//        int result=studentDao.delete(222);
        
        // Selecting one object
//        Student student=studentDao.getStudent(333);
//        System.out.println(student);
        
        // Selecting multiple objects
        List<Student> students=studentDao.getAllStudents();
        for(Student s:students)
        {
        	System.out.println(s);
        }
}
}
