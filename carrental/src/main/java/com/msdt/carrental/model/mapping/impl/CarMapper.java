package com.msdt.carrental.model.mapping.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.model.mapping.GenericMapper;

/**
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
public class CarMapper implements GenericMapper<Car> {

	@Override
	public Car rowMapper(final ResultSet resultSet) throws SQLException {
		long carId = resultSet.getLong("car_id");
		String carModel = resultSet.getString("car_model");
		String carReleaseYear = resultSet.getString("car_release_year");
		String carColor = resultSet.getString("car_color");
		String carCompany = resultSet.getString("car_company");

		return new Car(carId, carModel, carReleaseYear, carColor, carCompany);
	}

}
