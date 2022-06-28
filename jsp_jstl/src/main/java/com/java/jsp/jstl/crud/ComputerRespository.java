package com.java.jsp.jstl.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.java.computer.Computer;

public class ComputerRespository implements CrudRepository<Computer> {
	private List<Computer> computerList;

	public ComputerRespository() {
		super();
		this.computerList = new ArrayList<Computer>();
	}

	@Override
	public Computer add(Computer t) {
		boolean isadded = this.computerList.add(t);
		if (isadded) {
			return t;
		} else {
			return null;
		}
	}

	@Override
	public List<Computer> findall() {
		// TODO Auto-generated method stub
		List<Computer> list = new ArrayList<Computer>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * FROM computer;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				Computer c = new Computer();
				c.setId(rs.getInt(1));
				c.setBrand(rs.getString(2));
				c.setModel(rs.getString(3));
				c.setProcessor(rs.getString(4));
				c.setPrice(rs.getDouble(5));
				list.add(c);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public Computer FindByBrand(int id) {
		// TODO Auto-generated method stub
		Optional<Computer> found = this.computerList.stream().filter(e-> e.getBrand().equals(id)).findFirst();
		return found.get();
	}

	@Override
	public Computer insert(Computer t) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Computer values (?,?,?,?,?)");
			ps.setInt(1, t.getId());
			ps.setString(2, t.getBrand());
			ps.setString(3, t.getModel());
			ps.setString(4, t.getProcessor());
			ps.setDouble(5, t.getPrice());
			ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return t;
	}

}
