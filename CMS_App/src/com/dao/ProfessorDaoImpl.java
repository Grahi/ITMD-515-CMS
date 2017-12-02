package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Course;
import com.bean.Professor;
import com.util.DBConnection;

/*
 * 
 */

public class ProfessorDaoImpl implements ProfessorDao {

	public ProfessorDaoImpl() {

	}
	
	@Override
	public void addProfessor(Professor professor) {
		Connection con = null;
		PreparedStatement statement = null;
		
		String query = "";
		
		try {

			con = DBConnection.createConnection();
			
			query = "INSERT INTO `cms`.`professor`"
					+"(`professor_first_name` ,"
					+"`professor_last_name`, "
					+"`professor_contact`, "
					+"`professor_email`) "
					+"VALUES "
					+"(?, "
					+"?, "
					+"?, "
					+"?);";

			statement = con.prepareStatement(query);			
			
			statement.setString(1,professor.getProfFirstName());
			statement.setString(2,professor.getProfLastName());
			statement.setString(3,professor.getProfContact());
			statement.setString(4,professor.getProfEmail());	
			
			System.out.println(statement.toString());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Professor getProfessor(int professorId) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";
		
		Professor prof = new Professor();
		
		try {

			con = DBConnection.createConnection();
			query = "SELECT professor_id,professor_first_name, professor_last_name, professor_contact, professor_email FROM professor WHERE professor_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, professorId);			
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				prof.setProfId(resultSet.getInt("professor_id"));
				prof.setProfFirstName(resultSet.getString("professor_first_name"));
				prof.setProfLastName(resultSet.getString("professor_last_name"));
				prof.setProfContact(resultSet.getString("professor_contact"));
				prof.setProfEmail(resultSet.getString("professor_email"));				
				return prof;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Professor> getAllProfessor() {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";
		
		
		List<Professor> profList = new ArrayList<>();
		
		try {

			con = DBConnection.createConnection();
			query = "SELECT professor_id,professor_first_name, professor_last_name, professor_contact, professor_email FROM professor";

			statement = con.prepareStatement(query);					
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Professor prof = new Professor();
				prof.setProfId(resultSet.getInt("professor_id"));
				prof.setProfFirstName(resultSet.getString("professor_first_name"));
				prof.setProfLastName(resultSet.getString("professor_last_name"));
				prof.setProfContact(resultSet.getString("professor_contact"));
				prof.setProfEmail(resultSet.getString("professor_email"));				
				profList.add(prof);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profList;
	}
	
	@Override
	public void updateProfessor(Professor professor) {
		Connection con = null;
		PreparedStatement statement = null;
		
		String query = "";
		
		try {

			con = DBConnection.createConnection();
			query = "UPDATE professor "
				+"SET professor_first_name = ?, "
				+"professor_last_name = ?,  "
				+"professor_contact = ?, "
				+"professor_email= ? "
				+"WHERE professor_id = ?";

			statement = con.prepareStatement(query);
			statement.setString(1,professor.getProfFirstName());
			statement.setString(2,professor.getProfLastName());
			statement.setString(3,professor.getProfContact());
			statement.setString(4,professor.getProfEmail());					
			statement.setInt(5, professor.getProfId());			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProfessor(int professorId) {
		Connection con = null;
		PreparedStatement statement = null;		
		String query = "";	
			
		try {

			con = DBConnection.createConnection();
			
			//first delete the user of the professor.
			query = "DELETE FROM `cms`.`users` WHERE role = \"Professor\""
						+"AND roleId = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, professorId);		
			statement.executeUpdate();
			
			System.out.println("Deleted from the Users table.");
			
			//first delete the courses taken by the professor and then the professor.
			query = "DELETE FROM `cms`.`professor_course` "
						+"WHERE professor_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, professorId);		
			statement.executeUpdate();
			
			System.out.println("Deleted from the Professor_Course table.");
			
			//delete the professor
			query = "DELETE FROM `cms`.`professor` "
					+"WHERE professor_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, professorId);		
			statement.executeUpdate();
			
			System.out.println("Deleted from the Professor table.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Course> getProfessorCourse(int rollId) {
		
		List<Course> courseList = new ArrayList<>();
				
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";		
		
				
		try {
			con = DBConnection.createConnection();
			query = "select c.course_id,c.course_code,c.course_name from professor_course pf inner join Course c on pf.course_id = c.course_id where professor_id = ?";
			
			statement = con.prepareStatement(query);
			statement.setInt(1, rollId);			
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Course course = new Course();
				course.setCourseName(resultSet.getString("course_name"));
				course.setCourseCode(resultSet.getString("course_code"));
				course.setCourseId(resultSet.getInt("course_id"));
				
				courseList.add(course);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return courseList;
	}

	

	

}
