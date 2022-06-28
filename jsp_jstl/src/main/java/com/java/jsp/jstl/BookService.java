package com.java.jsp.jstl;

import java.util.*;

import com.java.computer.Computer;
import com.java.jsp.jstl.crud.BookRepository;
import com.java.jsp.jstl.crud.CrudRespositryBook;

public class BookService {

	private CrudRespositryBook<Book> repo;

	public BookService() {
		super();
		
		
		this.repo = new BookRepository();

	}

	public List<Book> findAll() {
		
//		return this.findAll();
		return this.repo.findall();

	}

	public Book add(Book entity) {
		
//		return this.add(entity);
		return this.repo.add(entity);
	}

	public Book FindByBrand(String bookName) {
		// TODO Auto-generated method stub
		return this.repo.FindByBrand(bookName);
	}
	
	public Book insert(Book add) {
		
		return this.repo.insert(add);
	}



}
