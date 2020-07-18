package com.msdt.carrental.model.dao.api;

import java.util.List;
/**
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
public interface GenericDao<T> {


	// CREATE
	int insertItem(T item);

	// READ
	List<T> getAllItems();

	T getItemById(long id);

	// UPDATE
	int updateItem(T item);

	// DELETE
	int deleteItem(long id);

}
