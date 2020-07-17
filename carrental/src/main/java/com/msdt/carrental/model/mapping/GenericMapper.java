package com.msdt.carrental.model.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GenericMapper <T>{

	T rowMapper(ResultSet resultSet) throws SQLException ;
}
