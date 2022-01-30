package com.msdt.carrental.util.constants;

public class OrderConstant {

	//////////////
	// DB Query //
	//////////////
	public static final String DELETE_ORDER_BY_ID = "DELETE FROM order_table WHERE order_id = ?::BIGINT";
	public static final String SELECT_ORDER_BY_ID = "SELECT * FROM order_table WHERE order_id = ?::BIGINT";
	public static final String SELECT_ALL_ORDERS = "SELECT * FROM order_table";
	public static final String INSERT_ORDER = "INSERT INTO order_table (user_id, car_id, order_date, return_date, car_returned, rental_cost)"
			+ " VALUES(?::BIGINT, ?::BIGINT, ?::date, ?::date, ?::BOOL, ?::NUMERIC)";
	public static final String UPDATE_ORDER = "UPDATE order_table SET user_id = ?::BIGINT, car_id = ?::BIGINT, order_date = ?::date, return_date = ?::date, car_returned = ?::BOOL, rental_cost = ?::NUMERIC WHERE order_id = ?::BIGINT";

	///////////////
	// DB Column //
	///////////////
	public static final String TABLE_ORDER_ID = "order_id";
	public static final String TABLE_ORDER_USER_ID = UserConstant.TABLE_USER_ID;
	public static final String TABLE_ORDER_CAR_ID = CarConstant.TABLE_CAR_ID;
	public static final String TABLE_ORDER_DATE = "order_date";
	public static final String TABLE_ORDER_RETURN_DATE = "return_date";
	public static final String TABLE_ORDER_CAR_RETURNED = "car_returned";
	public static final String TABLE_ORDER_RENTAL_COST = "rental_cost";

	
	private OrderConstant() {

	}
}
