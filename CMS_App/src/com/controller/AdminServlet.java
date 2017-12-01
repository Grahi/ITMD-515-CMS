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
			
		case "ADDSTUDENT":
			addStudent(request,response);		
			break;
		
		case "ADDCOURSE":
			addCourse(request,response);
			break;
			
		default:
			refreshAdminPage(request, response);
			break;
			
		}
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
