package com.msdt.carrental.model.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.model.dao.AbstractDao;
import com.msdt.carrental.model.mapping.impl.CarMapper;

public class CarDao extends AbstractDao<Car> {

	private Connection connection;

	public CarDao() {
	}

	public CarDao(final Connection connection) {
		super(connection);
	}

	@Override
	public int insertItem(final Car item) {

		return 0;
	}

	@Override
	public List<Car> getAllItems() {

		return queryForObjects("SELECT * FROM car_table", new CarMapper());
	}

	@Override
	public Car getItemById(final long id) {

		return queryForObject("SELECT * FROM car_table WHERE car_id = ?::BIGINT", new CarMapper(), String.valueOf(id));
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
