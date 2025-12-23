package com.sunny.enterprise.target.repo;

import com.sunny.enterprise.target.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    JdbcTemplate jdbcTemplatePrimaryDataSource;

    @Autowired
    UserRepository(JdbcTemplate jdbcTemplatePrimaryDataSource) {
        this.jdbcTemplatePrimaryDataSource = jdbcTemplatePrimaryDataSource;
    }

    public List<User> getUsers() {
        String query = "select id, name, address, age, salary from emp";
        return jdbcTemplatePrimaryDataSource.query(query, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setAddress(rs.getString(3));
                user.setAge(rs.getInt(4));
                user.setSalary(rs.getLong(5));
                return user;
            }
        });
    }
}
