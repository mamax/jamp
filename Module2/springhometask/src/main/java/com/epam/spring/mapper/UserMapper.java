package com.epam.spring.mapper;

import com.epam.spring.model.User;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

 @Override
 public User mapRow(ResultSet resultSet, int i) throws SQLException {
  return null;
 }
}
