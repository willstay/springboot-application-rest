package com.willstay.springbootapplicationrest.mapper;

import com.willstay.springbootapplicationrest.domain.Owner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerRowMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Owner(
                resultSet.getLong("id"),
                resultSet.getLong("companyId"),
                resultSet.getString("firstName"),
                resultSet.getString("secondName")
        );
    }
}
