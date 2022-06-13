package com.java.crud.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaveServlet")
public class StudentSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StudentSave() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String rollNumber = request.getParameter("rollnumber");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tmarks = request.getParameter("tmarks");
		String grade = request.getParameter("grade");
		
		
		Students s = new Students();
		s.setRollNumber(rollNumber);
		s.setName(name);
		s.setAge(Integer.parseInt(age));
		s.setTotalMarks(Integer.parseInt(tmarks));
		s.setGrade(grade);
		
		int flag = StudentDb.save(s);
		if (flag > 0) {
			out.print("<p>Student Data saved successfully</p>");
			request.getRequestDispatcher("Student.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}
		out.close();
	}
}


