package com.msdt.carrental.model.service.api;

import java.util.List;

public interface GenericService<T> {

	// CREATE
	int insertItem(T item) throws ServiceException;

	// READ
	List<T> getAllItems() throws ServiceException;

	T getItemById(long id) throws ServiceException;

	// UPDATE
	int updateItem(T item) throws ServiceException;

	// DELETE
	int deleteItem(long id) throws ServiceException;
}
