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
import javax.servlet.http.HttpSession;

import com.bean.Course;
import com.bean.Student;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String roleIdStr = session.getAttribute("roleId").toString();
		
		int roleId = Integer.parseInt(roleIdStr);

		Student stud = new Student();
		StudentDao studDao = new StudentDaoImpl();
		List<Course> courseList = new ArrayList<Course>();

		try {

			stud = studDao.getStudent(roleId);
			
			System.out.println("I got Student with name -" + stud.getStudentFirstName());
			stud.setCourse(studDao.getStudentCourse(roleId));
			courseList = stud.getCourse();			
		
			request.setAttribute("courseList", courseList);
			session.setAttribute("roleId", roleId);
			session.setAttribute("userName", stud.getStudentFirstName() + " " + stud.getStudentLastName());
						
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Student.jsp");
			rd.forward(request, response);
			

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

}
