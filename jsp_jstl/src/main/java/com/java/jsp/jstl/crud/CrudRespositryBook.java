package com.java.jsp.jstl.crud;

import java.util.List;

public interface CrudRespositryBook<T> {


	public T add(T t);

	public List<T> findall();
	
	public T FindByBrand(String Name);
	
	public T insert(T t);
	
}
