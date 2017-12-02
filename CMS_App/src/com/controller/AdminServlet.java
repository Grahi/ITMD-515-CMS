package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Course;
import com.bean.Professor;
import com.bean.Student;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.dao.ProfessorDao;
import com.dao.ProfessorDaoImpl;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the "command" parameter 
		String theCommand = request.getParameter("command");
		
		//if the command is missing, then default to listing students
		if(theCommand == null){
			theCommand = "LIST";
		}
		
		//route to the appropriate method
		switch(theCommand){
		case "LIST":
			refreshAdminPage(request, response);
			break;
				
		case "ADDPROFESSOR":
			addProfessor(request,response);
			break;
			
		case "LOADPROFESSOR":
			loadProfessor(request,response);
			break;
			
		case "UPDATEPROFESSOR":
			updateProfessor(request,response);
			break;
			
		case "DELETEPROFESSOR":
			deleteProfessor(request,response);
			break;
			
		case "ADDSTUDENT":
			addStudent(request,response);		
			break;
		
		case "LOADSTUDENT":
			loadStudent(request,response);
			break;
		
		case "UPDATESTUDENT":
			updateStudent(request,response);
			break;
		
		case "DELETESTUDENT":
			deleteStudent(request,response);
			break;
			
			
		case "ADDCOURSE":
			addCourse(request,response);
			break;
			
		case "LOADCOURSE":
			loadCourse(request,response);
			break;
			
		case "UPDATECOURSE":
			updateCourse(request,response);
			break;
			
		case "DELETECOURSE":
			deleteCourse(request,response);
			break;			
			
		default:
			refreshAdminPage(request, response);
			break;
			
		}
	}
	
	/*
	 * 
	 */
	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//read the professor info from the form data
		String theCourseIdStr = request.getParameter("courseId");
		int courseId = Integer.parseInt(theCourseIdStr);
		
		//call method to delete the professor
		CourseDao courseDao = new CourseDaoImpl();
		courseDao.deleteCourse(courseId);
		
		//Refresh admin page
		refreshAdminPage(request, response);	
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//read the professor info from the form data
		String theStudIdStr = request.getParameter("studentId");
		int studentId = Integer.parseInt(theStudIdStr);
		
		//call method to delete the professor
		StudentDao studDao = new StudentDaoImpl();
		studDao.deleteStudent(studentId);
		
		//Refresh admin page
		refreshAdminPage(request, response);		
	}

	private void deleteProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the professor info from the form data
		String theProfIdStr = request.getParameter("profId");
		int profId = Integer.parseInt(theProfIdStr);
		
		//call method to delete the professor
		ProfessorDao profDao = new ProfessorDaoImpl();
		profDao.deleteProfessor(profId);
		
		//Refresh admin page
		refreshAdminPage(request, response);		
		
	}

	private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//read the course info from the form data
		String theCourseIdStr = request.getParameter("courseId");
		int courseId = Integer.parseInt(theCourseIdStr);
		String courseCode = request.getParameter("course_code");
		String courseName = request.getParameter("course_name");
		String location = request.getParameter("location");
		
		//create new student object
		Course course = new Course(courseId,courseCode,courseName,location);
		
		//perform update on database
		CourseDao courseDao = new CourseDaoImpl();
		courseDao.updateCourse(course);
		
		//send them back to the refresh admin page
		refreshAdminPage(request, response);
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		//read the student info from the form data
		String theStudIdStr = request.getParameter("studentId");
		int studentId = Integer.parseInt(theStudIdStr);
		String firstName = request.getParameter("student_first_name");
		String lastName = request.getParameter("student_last_name");
		String contact = request.getParameter("student_contact");
		String email = request.getParameter("student_email");
		
		//create new student object
		Student stud = new Student(studentId,firstName,lastName,contact,email);
		
		//perform update on database
		StudentDao studDao = new StudentDaoImpl();
		studDao.updateStudent(stud);
		
		//send them back to the refresh admin page
		refreshAdminPage(request, response);
	}

	private void updateProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//read the professor info from the form data
		String theProfIdStr = request.getParameter("profId");
		int profId = Integer.parseInt(theProfIdStr);
		String firstName = request.getParameter("professor_first_name");
		String lastName = request.getParameter("professor_last_name");
		String contact = request.getParameter("professor_contact");
		String email = request.getParameter("professor_email");
		
		//create new professor object
		Professor prof = new Professor(profId,firstName,lastName,contact,email);
		
		//perform update on database
		ProfessorDao profDao = new ProfessorDaoImpl();
		profDao.updateProfessor(prof);
		
		//send them back to the refresh admin page
		refreshAdminPage(request, response);
		
	}

	/*
	 * 
	 */
	private void loadCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read professor id from form data 
		String theCourseIdStr = request.getParameter("courseId");
		int courseId = Integer.parseInt(theCourseIdStr);
		
		//get professor from DB
		CourseDao courseDao = new CourseDaoImpl();
		Course course  = courseDao.getCourse(courseId);
				
		//place professor in request attribute
		request.setAttribute("course", course);
		
		//send to jsp page - UpdateProfessor.jsp
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/UpdateCourse.jsp");
		rd.forward(request, response);				
	}

	/*
	 * 
	 */
	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//read professor id from form data 
			String theStudIdStr = request.getParameter("studentId");
			int studentId = Integer.parseInt(theStudIdStr);
			
			//get professor from DB
			StudentDao profDao = new StudentDaoImpl();
			Student stud  = profDao.getStudent(studentId);
					
			//place professor in request attribute
			request.setAttribute("stud", stud);
			
			//send to jsp page - UpdateProfessor.jsp
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/UpdateStudent.jsp");
			rd.forward(request, response);				
		
	}

	/*
	 * 
	 */
	private void loadProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read professor id from form data 
		String theProfIdStr = request.getParameter("profId");
		int profId = Integer.parseInt(theProfIdStr);
		
		//get professor from DB
		ProfessorDao profDao = new ProfessorDaoImpl();
		Professor prof  = profDao.getProfessor(profId);
				
		//place professor in request attribute
		request.setAttribute("prof", prof);
		
		//send to jsp page - UpdateProfessor.jsp
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/UpdateProf.jsp");
		rd.forward(request, response);				
	}

	/*
	 * 
	 */
	private void addProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//read professor info from form data
		String firstName = request.getParameter("professor_first_name");
		String lastName = request.getParameter("professor_last_name");
		String contact = request.getParameter("professor_contact");
		String email = request.getParameter("professor_email");
		
		//create a new professor object 
		Professor prodAdd = new Professor(firstName,lastName,contact,email);
		
		//add the professor to the database
		ProfessorDao profDao = new ProfessorDaoImpl();
		profDao.addProfessor(prodAdd);
		
		//send back to the main page (the professor list)
		refreshAdminPage(request, response);
		
	}
	
	/*
	 * 
	 */
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read student info from form data
		String firstName = request.getParameter("student_first_name");
		String lastName = request.getParameter("student_last_name");
		String contact = request.getParameter("student_contact");
		String email = request.getParameter("student_email");
		
		//create a new student object 
		Student studAdd = new Student(firstName,lastName,contact,email);
		
		//add the student to the database
		StudentDao studDao = new StudentDaoImpl();
		studDao.addStudent(studAdd);
		
		//send back to the main page (the student list)
		refreshAdminPage(request, response);
	}
	
	/*
	 * 
	 */
	private void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//read course info from form data
		String courseCode = request.getParameter("course_code");
		String courseName = request.getParameter("course_name");
		String location = request.getParameter("location");
		
		//create a new course object 
		Course courseAdd = new Course(courseCode,courseName,location);
		
		//add the course to the database
		CourseDao courseDao = new CourseDaoImpl();
		courseDao.addCourse(courseAdd);
		
		//send back to the main page (the course list)
		refreshAdminPage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

			refreshAdminPage(request, response);
	}

	private void refreshAdminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProfessorDao profDao = new ProfessorDaoImpl();
		StudentDao studDao = new StudentDaoImpl();
		CourseDao courseDao = new CourseDaoImpl();
		
		List<Professor> profList = new ArrayList<>();
		List<Student> studList = new ArrayList<>();	
		List<Course> courseList = new ArrayList<>();
		
		
		profList = profDao.getAllProfessor();
		studList = studDao.getAllStudent();
		courseList = courseDao.getAllCourse();
		
		if(profList.isEmpty()){
			System.out.println("Professor List is empty");
		} else{
			request.setAttribute("profList", profList);
		}
		
		if(studList.isEmpty()){
			System.out.println("Student List is empty");
		} else {
			request.setAttribute("studList", studList);
		}
		
		if(courseList.isEmpty()){
			System.out.println("Course List is empty");
		} else{
			request.setAttribute("courseList", courseList);
		}
				
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Admin.jsp");
			rd.forward(request, response);	
		
	} 

}
