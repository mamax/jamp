package com.epam.spring.mapper;

import com.epam.spring.model.UserAccount;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountMapper implements RowMapper<UserAccount> {
 @Override
 public UserAccount mapRow(ResultSet resultSet, int i)
   throws SQLException {
  return null;
 }
}
