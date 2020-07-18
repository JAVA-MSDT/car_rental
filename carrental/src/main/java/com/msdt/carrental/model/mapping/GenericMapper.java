package com.msdt.carrental.model.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
public interface GenericMapper <T>{

	T rowMapper(ResultSet resultSet) throws SQLException ;
}
