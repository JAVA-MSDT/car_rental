package com.msdt.carrental.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Used To read properties value from Properties File
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
public class PropertiesReader {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * 
	 * @param filePath Properties file Path to extract the value of the properties key
	 * @return properties object full of properties {Key:Value}
	 */
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
