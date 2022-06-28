package com.java.computer;

import java.util.Arrays;
import java.util.List;

import com.java.jsp.jstl.crud.ComputerRespository;
import com.java.jsp.jstl.crud.CrudRepository;

public class ComputerService 
{
//	private List<Computer> computerList;
	private CrudRepository<Computer> reppo;
	

	public ComputerService() {
		super();
//		this.computerList = Arrays.asList(new Computer("i5","2021","Dell",30000),
//										  new Computer("i7","2022","HP",45000)  array list
//										);
		this.reppo = new ComputerRespository();
		
	}
	public List<Computer> findComputers()
	{
//		return this.computerList;
//		return this.findAll();
		return this.reppo.findall();
		
	}
	public Computer add(Computer system) {
		// TODO Auto-generated method stub
		return this.reppo.add(system);
	}
	public Computer findComputer(int id)
	{
		return this.reppo.FindByBrand(id);
		
	}
	public Computer insert(Computer com) {
		
		return this.reppo.insert(com);
	}

}
