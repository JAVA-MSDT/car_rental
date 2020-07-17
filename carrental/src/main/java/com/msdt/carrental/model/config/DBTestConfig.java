package com.msdt.carrental.model.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

public class DBTestConfig {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * 
	 * @return connection which extracted from the Embedded Postgres
	 */
	public Connection getConnection() {
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			LOGGER.error("Unabling to get Connection: " + e);
			throw new RuntimeException("Unabling to Start Connection: ");
		}
	}

	/**
	 * 
	 * @return Datasource Ready to be used for testing and full of data
	 */
	private DataSource getDataSource() {

		DataSource dataSource = null;
		EmbeddedPostgres postgres = null;

		try {
			postgres = EmbeddedPostgres.builder().start();
			dataSource = postgres.getPostgresDatabase();
		} catch (IOException e) {
			LOGGER.error("Unabling to Start EmbededPostgress: " + e);
		}

		// Passing the Datasource to Flyway to fill the database with data
		Flyway flyway = getFlyway(dataSource);

		// Clean the database before using it to make sure that you will have un
		// corrupted data
		flyway.clean();

		// Migrating the scripts from that path src/main/resources/db/migration
		flyway.migrate();

		return dataSource;
	}

	/**
	 * 
	 * @param dataSource
	 * @return instance of Flyway including datasource to be manipulated
	 */
	private Flyway getFlyway(final DataSource dataSource) {
		FluentConfiguration configuration = Flyway.configure().dataSource(dataSource);
		return new Flyway(configuration);
	}

}
