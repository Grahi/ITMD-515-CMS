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
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.bean.Assignment;
import com.bean.Course;
import com.bean.Resource;
import com.bean.TA;
import com.dao.CourseDaoImpl;
import com.dao.CourseDao;


/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();
		
		//read the course id from the professor.jsp page
		String courseIdStr = request.getParameter("courseId");

		//test whether the course id received
		System.out.println("Got the courseId:"+ courseIdStr);
				
		//pass the course id to the DB to retrieve the course details
		int courseId = Integer.parseInt(courseIdStr);
		
		Course course = new Course();
		CourseDao crdao = new CourseDaoImpl(); 
		String taName = "";
		String assName = "";
		List<TA> taList = new ArrayList<TA>();
		List<Resource> rscList = new ArrayList<Resource>();
		List<Assignment> assmtList = new ArrayList<Assignment>();
		
		try {
			
			course = crdao.getCourse(courseId);				
			taList = crdao.getCourseTA(courseId);
			rscList = crdao.getCourseResource(courseId);
			assmtList = crdao.getCourseAssignment(courseId);
			
			String courseName = course.getCourseCode() + ": " + course.getCourseName();		
			
			if(!taList.isEmpty()){
				taName = taList.get(0).getTaFirstName()+" "+taList.get(0).getTaLastName();
			}else{
				taName = "No TA assigned to this course";
			}		
						
			if(!assmtList.isEmpty()){
				assName = assmtList.get(0).getAssignmentText();
			}else{
				assName = "No assignments.";
			}		
			
			System.out.println("Got the course:"+courseName);			
			//request.setAttribute("courseName", courseName);
			request.setAttribute("taName", taName);
			request.setAttribute("assignmentName", assName);
			
			if(!rscList.isEmpty()){
				request.setAttribute("rscList", rscList);
			}				
			
			session.setAttribute("courseId",courseId);
			session.setAttribute("courseName", courseName);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Course.jsp");
			rd.forward(request, response);					
										
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
	}

}
