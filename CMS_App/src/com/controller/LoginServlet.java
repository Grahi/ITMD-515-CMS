package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Login;
import com.dao.LoginDao;
import com.dao.LoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String errorMsg = "";

		Login loginBean = new Login(userName,password);
		LoginDao loginDao = new LoginDaoImpl();
	
		try {

			Login userValidate = loginDao.authenticateUser(loginBean);

			if (userValidate != null) {
					
				//pass the roleId to the request
				session.setAttribute("roleId", userValidate.getRoleId());
				session.setAttribute("roleName", userValidate.getRole());
				
				if (userValidate.getRole().equals("Admin")) {

					System.out.println("Admin's Home");	
					session.setAttribute("userName", userName);
					request.getRequestDispatcher("/AdminServlet").forward(request, response);

				} else if (userValidate.getRole().equals("Professor")) {

					System.out.println("Professor's Home");					
					request.getRequestDispatcher("/ProfessorServlet").forward(request, response);

				} else if (userValidate.getRole().equals("Student")) {

					System.out.println("Student's Home");				
					request.getRequestDispatcher("/StudentServlet").forward(request, response);
					
				} else{
					errorMsg = "Page cannot be displayed for this role";
					System.out.println("Error message = " + errorMsg);
					request.setAttribute("errMessage", errorMsg);
					request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);					
				}
			}
			else {
				errorMsg = "Invalid user credentials";
				System.out.println("Error message = " + errorMsg);
				request.setAttribute("errMessage", errorMsg);
				request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

}