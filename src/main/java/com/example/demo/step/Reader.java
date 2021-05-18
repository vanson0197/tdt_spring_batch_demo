package com.example.demo.step;


import com.example.demo.entity.PersonEntity;
import com.example.demo.mapper.PersonRowMapper;
import org.springframework.batch.item.*;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;


public class Reader implements ItemReader {
    @Autowired
    DataSource dataSource;

    @Autowired
    private EntityManager em;

    @Override
    public PersonEntity read() throws Exception {
//        JdbcCursorItemReader<PersonEntity> reader = new JdbcCursorItemReader<>();
//        reader.setDataSource(dataSource);
//        reader.setSql("SELECT person_id, name, age, address From person");
//        reader.setRowMapper(new PersonRowMapper());
//
//        return reader;

        List<PersonEntity> persons = em.createNativeQuery(
                "SELECT person_id, name, age, address " +
                        "FROM person", PersonEntity.class).getResultList();


        return persons.get(0);

    }

}


