package com.msdt.carrental.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.msdt.carrental.model.mapping.GenericMapper;

public abstract class AbstractDao<T> implements GenericDao<T> {
	private static final Logger LOGGER = LogManager.getLogger();

	protected Connection connection;

	public AbstractDao() {
	}

	public AbstractDao(final Connection connection) {
		this.connection = connection;
	}

	protected List<T> queryForObjects(final String query, final GenericMapper<T> rowMapper,
			final String... parameters) {

		System.out.println("Query: " + query);
		List<T> items = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			fillPreparedStatmentWithObjects(preparedStatement, parameters);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				T item = rowMapper.rowMapper(resultSet);
				items.add(item);
			}
		} catch (SQLException e) {
			LOGGER.error("Unabling to proccess the query: " + e);
		}

		return items;
	}

	protected T queryForObject(final String query, final GenericMapper<T> rowMapper, final String... parameters) {
		List<T> items = queryForObjects(query, rowMapper, parameters);
		if (items.size() == 1) {
			return items.get(0);
		} else {
			return null;
		}

	}


	private void fillPreparedStatmentWithObjects(final PreparedStatement preparedStatement, final String... parameters) throws SQLException {
		for(int i = 1; i < (parameters.length + 1); i++) {
			preparedStatement.setObject(i, parameters[i - 1]);
		}
	}

}
