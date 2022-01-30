package com.msdt.carrental.model.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.model.dao.api.AbstractDao;
import com.msdt.carrental.model.dao.api.DaoException;
import com.msdt.carrental.model.mapping.impl.CarMapper;
import com.msdt.carrental.util.constants.CarConstant;

/**
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
public class CarDao extends AbstractDao<Car> {

	CarDao() {
	}

	CarDao(final Connection connection) {
		super(connection);
	}

	@Override
	public int insertItem(final Car item) throws DaoException {
		return executeUpdate(CarConstant.INSERT_CAR, item.getCarModel(), item.getcarReleaseYear(), item.getCarColor(),
				item.getCarModel());
	}

	@Override
	public List<Car> getAllItems() throws DaoException {
		return queryForObjects(CarConstant.SELECT_ALL_CARS, new CarMapper());
	}

	@Override
	public Car getItemById(final long id) throws DaoException {
		return queryForObject(CarConstant.SELECT_CAR_BY_ID, new CarMapper(), String.valueOf(id));
	}

	@Override
	public int updateItem(final Car item) throws DaoException {
		return executeUpdate(CarConstant.UPDATE_CAR, item.getCarModel(), item.getcarReleaseYear(), item.getCarColor(),
				item.getCarModel(), String.valueOf(item.getCarId()));
	}

	@Override
	public int deleteItem(final long id) throws DaoException {
		return executeUpdate(CarConstant.DELETE_CAR_BY_ID, String.valueOf(id));
	}

}
