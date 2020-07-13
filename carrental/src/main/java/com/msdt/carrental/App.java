package com.msdt.carrental;

import java.util.Properties;

import com.msdt.carrental.util.PropertiesReader;

public class App {
	public static void main(final String[] args) {

		Properties properties = PropertiesReader.getProperties("src/main/resources/dbconnection.properties");

		System.out.println("File Length: " + properties.size());
		System.out.println("jdbcUrl: " + properties.getProperty("jdbcUrl"));
	}
}
