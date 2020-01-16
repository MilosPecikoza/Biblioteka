package com.iteh.dao.rowmapper;

import com.iteh.dao.RoleDao;
import com.iteh.dao.util.AbstractMapper;
import com.iteh.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class UserRowMapper extends AbstractMapper {
    @Autowired
    @Lazy
    private RoleDao roleDao;

    @Override
    protected Object mapRow() throws SQLException {
        User u = new User();
        u.setId(getInteger("id"));
        u.setUsername(getString("username"));
        u.setPassword(getString("password"));
        u.setRole(roleDao.getById(getInteger("id")));
        return u;
    }
}
