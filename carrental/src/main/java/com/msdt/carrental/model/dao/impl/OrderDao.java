package com.msdt.carrental.model.dao.impl;

import java.util.List;

import com.msdt.carrental.domain.Order;
import com.msdt.carrental.model.dao.api.GenericDao;

/**
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
public class OrderDao implements GenericDao<Order> {

	@Override
	public int insertItem(final Order item) {

		return 0;
	}

	@Override
	public List<Order> getAllItems() {

		return null;
	}

	@Override
	public Order getItemById(final long id) {

		return null;
	}

	@Override
	public int updateItem(final Order item) {

		return 0;
	}

	@Override
	public int deleteItem(final long id) {

		return 0;
	}

}
