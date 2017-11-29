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

import com.bean.Resource;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;

/**
 * Servlet implementation class TAServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ResourceServlet" })
public class ResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceServlet() {
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

		List<Resource> rscList = new ArrayList<Resource>();
		rscList = crdao.getCourseResource(courseId);

		rscList.stream().forEach(elem -> System.out.println("Resource found " + elem.getResourceName()));
		
		if (!rscList.isEmpty()) {
			request.setAttribute("rscList", rscList);
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Resource.jsp");
		rd.forward(request, response);		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
