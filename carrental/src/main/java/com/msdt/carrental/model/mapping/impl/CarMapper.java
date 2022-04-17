package com.msdt.carrental.model.mapping.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.model.mapping.GenericMapper;
import com.msdt.carrental.util.constants.CarConstant;

/**
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
public class CarMapper implements GenericMapper<Car> {

	@Override
	public Car rowMapper(final ResultSet resultSet) throws SQLException {
		long carId = resultSet.getLong(CarConstant.TABLE_CAR_ID);
		String carModel = resultSet.getString(CarConstant.TABLE_CAR_MODEL);
		String carReleaseYear = resultSet.getString(CarConstant.TABLE_CAR_RELEASE_YEAR);
		String carColor = resultSet.getString(CarConstant.TABLE_CAR_COLOR);
		String carCompany = resultSet.getString(CarConstant.TABLE_CAR_COMPANY);
		int quantity = resultSet.getInt(CarConstant.TABLE_CAR_QUANTITY);

		return new Car(carId, carModel, carReleaseYear, carColor, carCompany, quantity);
	}

}
