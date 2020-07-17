package com.msdt.carrental.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.model.config.DBConnection;
import com.msdt.carrental.model.dao.AbstractDao;
import com.msdt.carrental.model.mapping.impl.UserMapper;

public class UserDao extends AbstractDao<User> {

	private static final String DELETE_USER_BY_ID = "DELETE FROM user_table WHERE user_id = ?";

	private static final String SELECT_USER_BY_ID = "SELECT * FROM user_table WHERE user_id = ?";

	private static final String SELECT_ALL_USERS = "SELECT * FROM user_table";

	private Connection connection;

	private static final String INSERT_USER = "INSERT INTO user_table (user_name, user_email, user_password, user_address, user_blocked, user_role)"
			+ " VALUES(?, ?, ?, ?, ?, ?)";

	private static final String UPDATE_USER = "UPDATE user_table SET user_name = ?, user_email = ?, user_password = ?, user_address = ?, user_blocked = ?, user_role = ? WHERE user_id = ?";

	public UserDao() {
		connection = new DBConnection().getConnection();
	}

	public UserDao(final Connection connection) {
		super(connection);
		this.connection = connection;
	}

	@Override
	public int insertItem(final User item) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
			preparedStatement.setString(1, item.getUserName());
			preparedStatement.setString(2, item.getUserEmail());
			preparedStatement.setString(3, item.getUserPassword());
			preparedStatement.setString(4, item.getUserAddress());
			preparedStatement.setBoolean(5, item.isUserBlocked());
			preparedStatement.setString(6, item.getUseRole().name());

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> getAllItems() {

		return queryForObjects(SELECT_ALL_USERS, new UserMapper()); 
	}

	@Override
	public User getItemById(final long id) {
		PreparedStatement preparedStatement;
		User user = new User();
		try {
			preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setLong(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new UserMapper().rowMapper(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public int updateItem(final User item) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, item.getUserName());
			preparedStatement.setString(2, item.getUserEmail());
			preparedStatement.setString(3, item.getUserPassword());
			preparedStatement.setString(4, item.getUserAddress());
			preparedStatement.setBoolean(5, item.isUserBlocked());
			preparedStatement.setString(6, item.getUseRole().name());
			preparedStatement.setLong(7, item.getUserId());

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteItem(final long id) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
			preparedStatement.setLong(1, id);

			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
