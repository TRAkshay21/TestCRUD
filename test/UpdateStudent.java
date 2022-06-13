package com.java.crud.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServelt
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		
		String sid = request.getParameter("rollnumber");
		String tmarks = request.getParameter("tmarks");
		int m = Integer.parseInt(tmarks);
		String grade = request.getParameter("grade");
		
		Students s = new Students();
		s.setRollNumber(sid);
		s.setTotalMarks(m);
		s.setGrade(grade);

		int status = StudentDb.updateStudents(s);
		if (status > 0) {
			response.sendRedirect("ViewStudent");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
