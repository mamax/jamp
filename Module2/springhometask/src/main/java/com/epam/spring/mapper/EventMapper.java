package com.epam.spring.mapper;

import com.epam.spring.model.Event;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {

 @Override
 public Event mapRow(ResultSet resultSet, int i) throws SQLException {
  return null;
 }
}
