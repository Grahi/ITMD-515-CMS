package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Course;
import com.bean.Student;
import com.util.DBConnection;

/*
 * 
 */
public class StudentDaoImpl implements StudentDao {

	public StudentDaoImpl() { }

	@Override
	public Student getStudent(int studentId) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";
		
		Student stud = new Student();
		
		try {

			con = DBConnection.createConnection();
			query = "SELECT Student_id,Student_first_name, Student_last_name, Student_contact, Student_email FROM Student WHERE Student_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, studentId);			
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				stud.setStudentId(resultSet.getInt("Student_id"));
				stud.setStudentFirstName(resultSet.getString("Student_first_name"));
				stud.setStudentLastName(resultSet.getString("Student_last_name"));
				stud.setStudentContact( resultSet.getString("Student_contact"));
				stud.setStudentEmail(resultSet.getString("Student_email"));				
				return stud;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public void addStudent(Student Student) {
		Connection con = null;
		PreparedStatement statement = null;
		
		String query = "";
		
		try {

			con = DBConnection.createConnection();
			query = "INSERT INTO `cms`.`student`"
					+"(`student_first_name`, "
					+"`student_last_name`, "
					+"`student_contact`, "
					+"`student_email`) "
					+"VALUES "
					+"(?, "
					+"?, "
					+"?, "
					+"?);";

			statement = con.prepareStatement(query);
			statement.setString(1,Student.getStudentFirstName());
			statement.setString(2,Student.getStudentLastName());
			statement.setString(3,Student.getStudentContact());
			statement.setString(4,Student.getStudentEmail());					
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student Student) {
		Connection con = null;
		PreparedStatement statement = null;
		
		String query = "";
		
		try {

			con = DBConnection.createConnection();
			query = "UPDATE Student "
				+"SET student_first_name = ?, "
				+"student_last_name = ?,  "
				+"student_contact = ?, "
				+"student_email = ? "
				+"WHERE student_id = ?";

			statement = con.prepareStatement(query);
			statement.setString(1,Student.getStudentFirstName());
			statement.setString(2,Student.getStudentLastName());
			statement.setString(3,Student.getStudentContact());
			statement.setString(4,Student.getStudentEmail());
			statement.setInt(5, Student.getStudentId());		
			
			System.out.println(statement.toString());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(int studentId) {
		Connection con = null;
		PreparedStatement statement = null;		
		String query = "";	
			
		try {

			con = DBConnection.createConnection();
			
			//first delete the courses taken by the student and then the student.
			query = "DELETE FROM student_course "
						+"WHERE student_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, studentId);		
			statement.executeUpdate();
			
			//delete the student
			query = "DELETE FROM student "
					+"WHERE student_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, studentId);		
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> getStudentCourse(int rollId) {
		
		List<Course> courseList = new ArrayList<>();
				
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";		
		
				
		try {
			con = DBConnection.createConnection();
			query = "select c.course_id,c.course_code,c.course_name from Student_course pf inner join Course c on pf.course_id = c.course_id where Student_id = ?";
			
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

	@Override
	public List<Student> getAllStudent() {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";
		
		
		List<Student> studList = new ArrayList<>();
		
		try {

			con = DBConnection.createConnection();
			query = "SELECT Student_id,Student_first_name, Student_last_name, Student_contact, Student_email FROM Student";

			statement = con.prepareStatement(query);					
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Student stud = new Student();
				stud.setStudentId(resultSet.getInt("Student_id"));
				stud.setStudentFirstName(resultSet.getString("Student_first_name"));
				stud.setStudentLastName(resultSet.getString("Student_last_name"));
				stud.setStudentContact(resultSet.getString("Student_contact"));
				stud.setStudentEmail(resultSet.getString("Student_email"));				
				studList.add(stud);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return studList;
	}

	

}
