package com.java.jsp.jstl.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.java.computer.Computer;
import com.java.jsp.jstl.Book;

public class BookRepository implements CrudRespositryBook<Book> {
	private List<Book> bookList;

	public BookRepository() {
		super();

//		this.bookList = Arrays.asList(new Book(1010, "Head First java", "Kathy Sieera", 450),
//				new Book(1011, "Thinking in java", "Bruce Erekal", 750));

		this.bookList = new ArrayList<Book>();
	}

	@Override
	public Book add(Book t) {
		boolean isAdded = this.bookList.add(t);
		if (isAdded) {
			return t;
		} else {
			return null;
		}

	}

	@Override
	public List<Book> findall() {

//		return this.bookList; 
		List<Book> list = new ArrayList<Book>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * FROM book;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setBookNumber(rs.getInt(4));
				b.setPrice(rs.getDouble(5));
				
				list.add(b);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Book FindByBrand(String name) {
		// TODO Auto-generated method stub
		Optional<Book> found = this.bookList.stream().filter(e -> e.getBookName().contains(name)).findFirst();
		return found.get();
	}

	@Override
	public Book insert(Book b) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Book values (?,?,?,?)");
//			ps.setInt(1, b.getId());
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthorName());
			ps.setInt(3, b.getBookNumber());
			ps.setDouble(4, b.getPrice());
			ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}
	

}
