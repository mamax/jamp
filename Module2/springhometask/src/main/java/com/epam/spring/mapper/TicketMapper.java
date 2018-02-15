package com.epam.spring.mapper;


import com.epam.spring.model.Ticket;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements RowMapper<Ticket> {
 @Override
 public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
  return null;
 }
}
