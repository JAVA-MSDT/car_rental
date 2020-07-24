package com.msdt.carrental.model.service.impl;

import java.util.List;

import com.msdt.carrental.domain.Order;
import com.msdt.carrental.model.service.api.GenericService;
import com.msdt.carrental.model.service.api.ServiceException;

public class OrderService implements GenericService<Order>{

	@Override
	public int insertItem(final Order item) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> getAllItems() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getItemById(final long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateItem(final Order item) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(final long id) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
