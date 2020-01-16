package com.iteh.dao;

import com.iteh.dao.rowmapper.RoleRowMapper;
import com.iteh.dao.util.AbstractJDBCDao;
import com.iteh.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleDao extends AbstractJDBCDao {
    @Autowired
    @Lazy
    private RoleRowMapper roleRowMapper;

    public List<Role> find() {
        return jdbcTemplate.query(queries.getSQL("select.roles"), new RoleRowMapper());
    }

    public Role getById(Integer id){
        return (Role) jdbcTemplate.queryForObject(queries.getSQL("select.role.by.id"), roleRowMapper, id);
    }
}
