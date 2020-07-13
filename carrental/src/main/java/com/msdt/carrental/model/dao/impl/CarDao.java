package com.msdt.carrental.model.dao.impl;

import java.util.List;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.model.dao.GenericDao;

public class CarDao implements GenericDao<Car>{

	@Override
	public int insertItem(final Car item) {
		
		return 0;
	}

	@Override
	public List<Car> getAllItems() {
		
		return null;
	}

	@Override
	public Car getItemById(final long id) {
		
		return null;
	}

	@Override
	public int updateItem(final Car item) {
		
		return 0;
	}

	@Override
	public int deleteItem(final long id) {
		
		return 0;
	}

}
