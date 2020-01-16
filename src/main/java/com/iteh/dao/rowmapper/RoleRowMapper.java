package com.iteh.dao.rowmapper;

import com.iteh.dao.util.AbstractMapper;
import com.iteh.domain.Role;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class RoleRowMapper extends AbstractMapper {
    @Override
    protected Object mapRow() throws SQLException {
        Role r = new Role();
        r.setId(getInteger("id"));
        r.setName(getString("name"));
        return r;
    }
}
