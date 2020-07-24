package com.msdt.carrental.model.service.impl;

import java.util.List;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.model.service.api.GenericService;
import com.msdt.carrental.model.service.api.ServiceException;

public class CarService implements GenericService<Car> {

	@Override
	public int insertItem(final Car item) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Car> getAllItems() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getItemById(final long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateItem(final Car item) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(final long id) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
