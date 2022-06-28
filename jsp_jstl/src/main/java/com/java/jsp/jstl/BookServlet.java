package com.java.jsp.jstl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.computer.Computer;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {

		service = new BookService();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
//		case "/":
////			showComputerFirstPage(request,response);
//			break;
		case "/books":
			printBooks(request, response);
			break;
		case "/find":
			printFindByName(request, response);
			break;
		default:
			break;
		}
//	

	}

	private void printBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//	Book java = new Book(1010,"Head First java","Kathy Sieera",450);

		List<Book> bookList = service.findAll();

		request.setAttribute("books", bookList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
		dispatcher.forward(request, response);

	}

	private void printFindByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bookName = request.getParameter("bookName");
		System.out.println(bookName);

		Book brandFind = service.FindByBrand(bookName);

		request.setAttribute("find", brandFind);
		System.out.println("Service Method called");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/findDisplayBook.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String author = request.getParameter("authorName");
		String bookName = request.getParameter("bookName");
		int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
		double price = Double.parseDouble(request.getParameter("price"));

		Book entity = new Book(bookNumber, bookName, author, price);
		
//		Book addedBook = service.add(entity);
		Book addedBook = service.insert(entity);

		request.setAttribute("added", addedBook);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Success.jsp");
		dispatcher.forward(request, response);

	}

}
