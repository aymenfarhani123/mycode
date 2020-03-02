package com.example.demobatchlistener;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setFirstName(resultSet.getString("firstName"));
        user.setMiddleName(resultSet.getString("middleName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setCity(resultSet.getString("city"));
        user.setId(resultSet.getInt("id"));
        return user;
    }
}
