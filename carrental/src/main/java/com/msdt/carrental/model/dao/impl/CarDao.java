package com.msdt.carrental.model.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.model.dao.api.AbstractDao;
import com.msdt.carrental.model.dao.api.DaoException;
import com.msdt.carrental.model.mapping.impl.CarMapper;

/**
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
public class CarDao extends AbstractDao<Car> {

	private static final String DELETE_CAR_BY_ID = "DELETE FROM car_table WHERE car_id = ?::BIGINT";
	private static final String SELECT_CAR_BY_ID = "SELECT * FROM car_table WHERE car_id = ?::BIGINT";
	private static final String SELECT_ALL_CARS = "SELECT * FROM car_table";
	private static final String INSERT_CAR = "INSERT INTO car_table(car_model, car_release_year, car_color, car_company)"
			+ " VALUES (?, ?, ?, ?)";
	private static final String UPDATE_CAR = "UPDATE car_table SET car_model = ?, car_release_year = ?,"
			+ " car_color = ?, car_company = ? WHERE car_id = ?::BIGINT";

	CarDao() {
	}

	CarDao(final Connection connection) {
		super(connection);
	}

	@Override
	public int insertItem(final Car item) throws DaoException {
		return executeUpdate(INSERT_CAR, item.getCarModel(), item.getcarReleaseYear(), item.getCarColor(),
				item.getCarModel());
	}

	@Override
	public List<Car> getAllItems() throws DaoException {
		return queryForObjects(SELECT_ALL_CARS, new CarMapper());
	}

	@Override
	public Car getItemById(final long id) throws DaoException {
		return queryForObject(SELECT_CAR_BY_ID, new CarMapper(), String.valueOf(id));
	}

	@Override
	public int updateItem(final Car item) throws DaoException {
		return executeUpdate(UPDATE_CAR, item.getCarModel(), item.getcarReleaseYear(), item.getCarColor(),
				item.getCarModel(), String.valueOf(item.getCarId()));
	}

	@Override
	public int deleteItem(final long id) throws DaoException {
		return executeUpdate(DELETE_CAR_BY_ID, String.valueOf(id));
	}

}
