package com.msdt.carrental.model.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.model.dao.api.AbstractDao;
import com.msdt.carrental.model.dao.api.DaoException;
import com.msdt.carrental.model.mapping.impl.UserMapper;

/**
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
public class UserDao extends AbstractDao<User> {

	private static final String DELETE_USER_BY_ID = "DELETE FROM user_table WHERE user_id = ?::BIGINT";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM user_table WHERE user_id = ?::BIGINT";
	private static final String SELECT_ALL_USERS = "SELECT * FROM user_table";
	private static final String INSERT_USER = "INSERT INTO user_table (user_name, user_email, user_password, user_address, user_blocked, user_role)"
			+ " VALUES(?, ?, ?, ?, ?::BOOL, ?)";
	private static final String UPDATE_USER = "UPDATE user_table SET user_name = ?, user_email = ?, user_password = ?, user_address = ?, user_blocked = ?::BOOL, user_role = ? WHERE user_id = ?::BIGINT";

	UserDao() {
	}

	UserDao(final Connection connection) {
		super(connection);
	}

	@Override
	public int insertItem(final User item) throws DaoException {
		return executeUpdate(INSERT_USER, item.getUserName(), item.getUserEmail(), item.getUserPassword(),
				item.getUserAddress(), String.valueOf(item.isUserBlocked()), item.getUseRole().name());
	}

	@Override
	public List<User> getAllItems() throws DaoException {
		return queryForObjects(SELECT_ALL_USERS, new UserMapper());
	}

	@Override
	public User getItemById(final long id) throws DaoException {
		return queryForObject(SELECT_USER_BY_ID, new UserMapper(), String.valueOf(id));
	}

	@Override
	public int updateItem(final User item) throws DaoException {
		return executeUpdate(UPDATE_USER, item.getUserName(), item.getUserEmail(), item.getUserPassword(),
				item.getUserAddress(), String.valueOf(item.isUserBlocked()), item.getUseRole().name(),
				String.valueOf(item.getUserId()));
	}

	@Override
	public int deleteItem(final long id) throws DaoException {
		return executeUpdate(DELETE_USER_BY_ID, String.valueOf(id));
	}

}
