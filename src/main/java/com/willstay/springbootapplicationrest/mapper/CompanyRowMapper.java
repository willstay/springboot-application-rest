package com.willstay.springbootapplicationrest.mapper;

import com.willstay.springbootapplicationrest.domain.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRowMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Company(
                resultSet.getLong("id"),
                resultSet.getString("title")
        );
    }
}
