package com.dao;

import java.util.List;

import com.bean.Assignment;
import com.bean.Course;
import com.bean.Resource;
import com.bean.Schedule;
import com.bean.TA;

public interface CourseDao {

	public Course getCourse(int courseId);
	
	public List<Course> getAllCourse();

	public void addCourse(Course course);
	
	public void updateCourse(Course course);

	public void deleteCourse(int courseId);
	
	public List<Resource> getCourseResource(int courseId);
	
	public List<TA> getCourseTA(int courseId);
	
	public List<Schedule> getCourseSchedule(int courseId);
	
	public List<Assignment> getCourseAssignment(int courseId);
}
