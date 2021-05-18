package com.example.demo.mapper;

import com.example.demo.entity.PersonEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonRowMapper implements RowMapper<PersonEntity> {
    @Override
    public PersonEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setPerson_id(rs.getInt("person_id"));
        personEntity.setName(rs.getString("name"));
        personEntity.setAge(rs.getInt("age"));
        personEntity.setAddress(rs.getString("address"));

        return personEntity;
    }
}
