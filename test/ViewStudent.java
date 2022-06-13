package com.java.crud.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='Student.html'>Add New Student</a>");
		out.println("<h1>Student List</h1>");

		List<Students> list = StudentDb.getAllStudent();

		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>StudentID</th><th>RollNumber</th><th>Name</th><th>TotalMarks</th><th>Grade</th><th>Age</th><th>Update</th><th>Delete</th><th>Grade S View</th></tr>");
		for (Students s : list) {
			out.print("<tr><td>" + s.getId() + "</td><td>" + s.getRollNumber() + "</td><td>" + s.getName() + "</td><td>"
					+ s.getTotalMarks() + "</td><td>" + s.getGrade() + "</td><td>" + s.getAge()
					+ "</td><td><a href='UpdateStudent?rollnumber=" + s.getRollNumber()
					+ "'>Update</a></td><td><a href='StudentDelete?rollnumber=" + s.getRollNumber()
					+ "'>Delete</a></td><td><a href='ViewStudentS?grade=" + s.getGrade()+ "'>Grade S View</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
