package com.dao;

import com.bean.Professor;
import java.util.List;
import com.bean.Course;

/*
 * 
 */
public interface ProfessorDao {

	public Professor getProfessor(int professorId);
	
	public List<Professor> getAllProfessor();

	public void addProfessor(Professor professor);
	
	public void updateProfessor(Professor professor);

	public void deleteProfessor(int professorId);
	
	public List<Course> getProfessorCourse(int roleId);
}
