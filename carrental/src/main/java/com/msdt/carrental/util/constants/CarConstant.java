package com.msdt.carrental.util.constants;

public class CarConstant {

	//////////////
	// DB Query //
	//////////////
	public static final String DELETE_CAR_BY_ID = "DELETE FROM car_table WHERE car_id = ?::BIGINT";
	public static final String SELECT_CAR_BY_ID = "SELECT * FROM car_table WHERE car_id = ?::BIGINT";
	public static final String SELECT_ALL_CARS = "SELECT * FROM car_table";
	public static final String INSERT_CAR = "INSERT INTO car_table(car_model, car_release_year, car_color, car_company)"
			+ " VALUES (?, ?, ?, ?)";
	public static final String UPDATE_CAR = "UPDATE car_table SET car_model = ?, car_release_year = ?,"
			+ " car_color = ?, car_company = ? WHERE car_id = ?::BIGINT";
	///////////////
	// DB Column //
	///////////////
	public static final String TABLE_CAR_ID = "car_id";
	public static final String TABLE_CAR_MODEL = "car_model";
	public static final String TABLE_CAR_RELEASE_YEAR = "car_release_year";
	public static final String TABLE_CAR_COLOR = "car_color";
	public static final String TABLE_CAR_COMPANY = "car_company";


	
	public CarConstant() {

	}
}
