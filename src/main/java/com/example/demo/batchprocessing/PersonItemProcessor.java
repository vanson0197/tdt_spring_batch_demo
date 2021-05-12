package com.example.demo.batchprocessing;

import com.example.demo.entity.PersonEntity;
import org.springframework.batch.item.ItemProcessor;


public class PersonItemProcessor implements ItemProcessor<PersonEntity, PersonEntity> {

    @Override
    public PersonEntity process(PersonEntity personEntity) throws Exception {
        return personEntity;
    }
}
