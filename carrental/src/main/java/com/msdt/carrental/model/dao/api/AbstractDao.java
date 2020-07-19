package com.msdt.carrental.model.dao.api;

/**
 * Class which will share the same functionality between all the DAO classes which will extend it 
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
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

	/**
	 * 
	 * @param query      To be performed
	 * @param rowMapper  which we will use to map the java class object with the
	 *                   database table
	 * @param parameters SQL parameters of the query if it is exists
	 * @return List of the specified object depends on which class calling that
	 *         method
	 * @throws DaoException
	 */
	protected List<T> queryForObjects(final String query, final GenericMapper<T> rowMapper, final String... parameters)
			throws DaoException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<T> items = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			fillPreparedStatmentWithObjects(statement, parameters);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				T item = rowMapper.rowMapper(resultSet);
				items.add(item);
			}
		} catch (SQLException e) {
			LOGGER.error("Unabling to perform the query: " + e);
			throw new DaoException("Unabling to perform the query: " + e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
					LOGGER.info("Result set Closed Successfully");
				} catch (SQLException e) {
					LOGGER.error("Unabling to Close Result Set: " + e);
					throw new DaoException("Unabling to Close Result Set: " + e);
				}
			}

			if (statement != null) {
				try {
					statement.close();
					LOGGER.info("Prepared Statement Closed Successfully");
				} catch (SQLException e) {
					LOGGER.error("Unabling to Close Prepared Statement: " + e);
					throw new DaoException("Unabling to Close Prepared Statement: " + e);
				}
			}

		}

		return items;
	}

	/**
	 * 
	 * @param query      To be performed
	 * @param rowMapper  which we will use to map the java class object with the
	 *                   database table
	 * @param parameters SQL parameters of the query if it is exists
	 * @return Object depends on which class calling that method
	 * @throws DaoException
	 */
	protected T queryForObject(final String query, final GenericMapper<T> rowMapper, final String... parameters)
			throws DaoException {
		List<T> items = queryForObjects(query, rowMapper, parameters);
		if (items.size() == 1) {
			return items.get(0);
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @param query      To be Performed
	 * @param parameters SQL parameters of the query to use it for object update
	 * @return
	 * @throws DaoException
	 */
	protected int executeUpdate(final String query, final String... parameters) throws DaoException {
		try (PreparedStatement statement = connection.prepareStatement(query)) {

			fillPreparedStatmentWithObjects(statement, parameters);
			return statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("Unabling to perform the query: " + e);
			throw new DaoException("Unabling to perform the query: " + e);
		}
	}

	/**
	 * HELPER METHOD will be used only inside that calss!!
	 * 
	 * @param preparedStatement Empty instance of prepared statement to be filled
	 *                          with the bedded parameters
	 * @param parameters        Which we will use it to fill the prepared statement
	 *                          instance
	 * @throws SQLException In case if something wrong happens during the filling
	 *                      process
	 */
	private void fillPreparedStatmentWithObjects(final PreparedStatement preparedStatement, final String... parameters)
			throws SQLException {
		for (int i = 1; i < (parameters.length + 1); i++) {
			preparedStatement.setObject(i, parameters[i - 1]);
		}
	}

}
