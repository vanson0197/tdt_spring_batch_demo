package com.example.demo.step;

import com.example.demo.entity.PersonEntity;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

@Data
public class Processor implements ItemProcessor<PersonEntity, PersonEntity> {

    private String threadName;

    @Override
    public PersonEntity process(PersonEntity personEntity) throws Exception {
        return  personEntity;
    }
}
