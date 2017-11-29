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
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
				
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
		}
		
		request.setAttribute("profList", profList);
		request.setAttribute("studList", studList);
		request.setAttribute("courseList", courseList);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Admin.jsp");
			rd.forward(request, response);	

	}

}
