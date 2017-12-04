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

import com.bean.Schedule;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		// read the course id from the professor.jsp page
		String courseIdStr = session.getAttribute("courseId").toString();
		
		// test whether the course id received
		System.out.println("Got the courseId:" + courseIdStr);
		
		// pass the course id to the DB to retrieve the course details
		int courseId = Integer.parseInt(courseIdStr);
		
		CourseDao crdao = new CourseDaoImpl();
		
		List<Schedule> schList  = new ArrayList<Schedule>();
		
		schList = crdao.getCourseSchedule(courseId);
		
		schList.stream().forEach(elem -> System.out.println("Schedule found " + elem.getScheduleTitle()));
		
		if (!schList.isEmpty()) {
			request.setAttribute("schList", schList);
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Schedule.jsp");
		rd.forward(request, response);					

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
