package com.dao;

import com.bean.Student;
import java.util.List;
import com.bean.Course;


/*
 * 
 */
public interface StudentDao {

	public List<Student> getAllStudent();
	
	public Student getStudent(int studentId);

	public void addStudent(Student Student);
	
	public void updateStudent(Student Student);

	public void deleteStudent(int studentId);

	public List<Course> getStudentCourse(int roleId);
}
