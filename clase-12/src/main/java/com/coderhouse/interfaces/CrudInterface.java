package com.coderhouse.interfaces;

import java.util.List;

public interface CrudInterface <T, ID>{

	List<T> findAll();
	
	T findById(ID id);
	
	T save(T entity);
	
	T update(ID id, T entity);
	
	void deleteById(ID id);
}
