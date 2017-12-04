package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Assignment;
import com.bean.Course;
import com.bean.Resource;
import com.bean.Schedule;
import com.bean.TA;
import com.util.DBConnection;

public class CourseDaoImpl implements CourseDao {

	public CourseDaoImpl() {

	}

	@Override
	public Course getCourse(int courseId) {
		Course course = new Course();

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";

		try {

			con = DBConnection.createConnection();
			query = "SELECT course_id,course_code,course_name,syllabus,location FROM Course WHERE course_id =  ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, courseId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				course.setCourseId(resultSet.getInt("course_id"));
				course.setCourseCode(resultSet.getString("course_code"));
				course.setCourseName(resultSet.getString("course_name"));
				course.setLocation(resultSet.getString("location"));
				return course;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return course;
	}

	@Override
	public void updateCourse(Course course) {
		Connection con = null;
		PreparedStatement statement = null;

		String query = "";

		try {
			con = DBConnection.createConnection();
			query = "UPDATE course " + "SET `course_code` = ?, " + "`course_name` = ?,  " + "`location` = ?"
					+ "WHERE course_id = ?";

			statement = con.prepareStatement(query);
			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getLocation());
			statement.setInt(4, course.getCourseId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCourse(int courseId) {
		Connection con = null;
		PreparedStatement statement = null;
		String query = "";

		try {

			con = DBConnection.createConnection();

			// first delete the user of the professor
			query = "DELETE FROM `cms`.`professor_course` " + "WHERE course_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, courseId);
			statement.executeUpdate();

			// first delete the courses taken by the student and then the
			// student.
			query = "DELETE FROM `cms`.`student_course` " + "WHERE course_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, courseId);
			statement.executeUpdate();

			// delete the student
			query = "DELETE FROM `cms`.`course` " + "WHERE course_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, courseId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Resource> getCourseResource(int courseId) {
		List<Resource> resourceList = new ArrayList<>();

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";

		try {
			con = DBConnection.createConnection();
			query = "SELECT resource_id,resource_name,resource_type FROM resource WHERE course_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, courseId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Resource resource = new Resource(resultSet.getInt("resource_id"), resultSet.getString("resource_name"),
						resultSet.getString("resource_type"));
				resourceList.add(resource);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resourceList;
	}

	@Override
	public List<TA> getCourseTA(int courseId) {

		List<TA> taList = new ArrayList<>();

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";

		try {
			con = DBConnection.createConnection();
			query = "SELECT ta_id,ta_first_name,ta_last_name,ta_contact,ta_email FROM ta WHERE course_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, courseId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				TA ta = new TA(resultSet.getInt("ta_id"), resultSet.getString("ta_first_name"),
						resultSet.getString("ta_last_name"), resultSet.getString("ta_contact"),
						resultSet.getString("ta_email"));

				taList.add(ta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return taList;
	}

	@Override
	public List<Schedule> getCourseSchedule(int courseId) {
		List<Schedule> assignmentList = new ArrayList<>();

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";

		try {
			con = DBConnection.createConnection();
			query = "SELECT schedule_id,schedule_title,start_time,end_time,course_id,a.room_id,room_name FROM `cms`.`schedule` as a  "
					+ "INNER JOIN `cms`.`room` as b "
					+ "ON  a.room_id = b.room_id"
					+ " WHERE course_id = ?;";

			statement = con.prepareStatement(query);
			statement.setInt(1, courseId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Schedule assignment = new Schedule(
						resultSet.getInt("schedule_id"),
						resultSet.getString("schedule_title"), 
						resultSet.getInt("room_id"),
						resultSet.getInt("course_id"),
						resultSet.getString("room_name"),
						resultSet.getDate("start_time"),
						resultSet.getDate("end_time")
						);

				assignmentList.add(assignment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return assignmentList;
	}

	@Override
	public List<Assignment> getCourseAssignment(int courseId) {
		List<Assignment> assignmentList = new ArrayList<>();

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";

		try {
			con = DBConnection.createConnection();
			query = "SELECT assignment_id,assignment_text, date_posted, due_date FROM assignment WHERE course_id = ?";

			statement = con.prepareStatement(query);
			statement.setInt(1, courseId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Assignment assignment = new Assignment(resultSet.getInt("assignment_id"),
						resultSet.getString("assignment_text"), resultSet.getDate("date_posted"),
						resultSet.getDate("due_date"));

				assignmentList.add(assignment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return assignmentList;
	}

	@Override
	public void addCourse(Course course) {
		Connection con = null;
		PreparedStatement statement = null;

		String query = "";

		try {

			con = DBConnection.createConnection();

			query = "INSERT INTO `cms`.`course`" + "(`course_code` ," + "`course_name`, " + "`location`) " + "VALUES "
					+ "(?, " + "?, " + "?);";

			statement = con.prepareStatement(query);

			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getLocation());

			System.out.println(statement.toString());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Course> getAllCourse() {

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "";

		List<Course> courseList = new ArrayList<>();

		try {

			con = DBConnection.createConnection();
			query = "SELECT course_id,course_code,course_name,syllabus,location FROM Course";

			statement = con.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getInt("course_id"));
				course.setCourseCode(resultSet.getString("course_code"));
				course.setCourseName(resultSet.getString("course_name"));
				course.setLocation(resultSet.getString("location"));
				courseList.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return courseList;
	}

}
