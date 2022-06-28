package com.java.computer;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComputerServlet
 */
@WebServlet("/computers")
public class ComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComputerService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stubs
		service = new ComputerService();
		super.init();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/":
//			showComputerFirstPage(request,response);
			break;
		case "/computers":
			printComputers(request,response);
			break;
		case "/find":
			printFindByBrand(request,response);
			break;
		default:
			break;
		}
			
	}
	
	private void printFindByBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String strid = request.getParameter("id");
		int id = Integer.parseInt(strid);
		System.out.println(id);
		
		Computer brandFind = service.findComputer(id);
	
		request.setAttribute("find",brandFind);
		System.out.println("Service Method called");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/findDisplayComputer.jsp");
		dispatcher.forward(request, response);
		
	}

	private void printComputers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		Computer com = new Computer("i5","2022","Dell",45000);

		List<Computer> computerList = service.findComputers();
		
		request.setAttribute("computer",computerList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/showComputer.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
//		doGet(request, response);
		String strid = request.getParameter("id");
		int id = Integer.parseInt(strid);
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String processor = request.getParameter("processor");
		String strprice = request.getParameter("price");
		double price = Double.parseDouble(strprice);
		
		Computer system = new Computer(id, model, brand, processor, price);
		
		Computer addedComputer = service.insert(system);
		
		request.setAttribute("system", addedComputer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SuccessComputer.jsp");
		dispatcher.forward(request, response);
		
	}

}
