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

import com.bean.Professor;
import com.dao.ProfessorDao;
import com.dao.ProfessorDaoImpl;
import com.bean.Course;

/**
 * Servlet implementation class ProfessorServlet
 */
@WebServlet("/ProfessorServlet")
public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfessorServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String roleIdStr = session.getAttribute("roleId").toString();
		
		int roleId = Integer.parseInt(roleIdStr);

		Professor prof = new Professor();
		ProfessorDao profDao = new ProfessorDaoImpl();
		List<Course> courseList = new ArrayList<Course>();

		try {

			prof = profDao.getProfessor(roleId);
			
			System.out.println("I got professor with name -" + prof.getProfFirstName());
			prof.setCourse(profDao.getProfessorCourse(roleId));
			courseList = prof.getCourse();			
		
			request.setAttribute("courseList", courseList);
			session.setAttribute("roleId", roleId);
			session.setAttribute("userName", prof.getProfFirstName() + " " + prof.getProfLastName());
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Professor.jsp");
			rd.forward(request, response);
			

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

}
