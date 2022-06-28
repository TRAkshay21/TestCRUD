package com.java.jsp.jstl.crud;

import java.util.List;

public interface CrudRepository<T> 
{

	public T add(T t);

	public List<T> findall();
	
	public T FindByBrand(int id);
	
	public T insert(T t);
	
	
}
