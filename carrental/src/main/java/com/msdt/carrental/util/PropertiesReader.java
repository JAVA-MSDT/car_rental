package com.msdt.carrental.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesReader {

	private static final Logger LOGGER = LogManager.getLogger();

	public static Properties getProperties(final String filePath) {
		Properties properties = new Properties();
		try (FileInputStream inputStream = new FileInputStream(filePath)) {
			properties.load(inputStream);
			LOGGER.info("Done Reading from file: " + filePath);
		} catch (FileNotFoundException e) {
			LOGGER.error("Error Reading from file: " + filePath + e);
		} catch (IOException e) {
			LOGGER.error("Error while Reading from file: " + filePath + e);
		}
		return properties;
	}
}
