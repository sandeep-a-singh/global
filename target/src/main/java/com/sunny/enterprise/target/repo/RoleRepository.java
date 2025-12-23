package com.sunny.enterprise.target.repo;

import com.sunny.enterprise.target.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoleRepository {
    JdbcTemplate jdbcTemplateSecondaryDataSource;

    @Autowired
    RoleRepository(JdbcTemplate jdbcTemplateSecondaryDataSource)
    {
        this.jdbcTemplateSecondaryDataSource =jdbcTemplateSecondaryDataSource;
    }

    public List<Role> getRoles()
    {
        String query = "Select role_id, role_name from APP_ROLE";

        return jdbcTemplateSecondaryDataSource.query(query, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
                Role role =new Role();
                role.setId(rs.getLong(1));
                role.setName(rs.getString(2));
                return role;
            }

        });

    }
}
