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

import com.bean.Assignment;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;

/**
 * Servlet implementation class TAServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AssignmentServlet" })
public class AssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// read the course id from the professor.jsp page
		String courseIdStr = session.getAttribute("courseId").toString();
		//String courseName = session.getAttribute("courseName").toString();

		// test whether the course id received
		System.out.println("Got the courseId:" + courseIdStr);

		// pass the course id to the DB to retrieve the course details
		int courseId = Integer.parseInt(courseIdStr);

		CourseDao crdao = new CourseDaoImpl();

		List<Assignment> assmtList = new ArrayList<Assignment>();
		assmtList = crdao.getCourseAssignment(courseId);

		assmtList.stream().forEach(elem -> System.out.println("Assignment found " + elem.getAssignmentText()));
		
		if (!assmtList.isEmpty()) {
			request.setAttribute("assmtList", assmtList);
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Assignments.jsp");
		rd.forward(request, response);			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

}
