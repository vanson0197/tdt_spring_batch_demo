package com.example.demo.step;

import com.example.demo.entity.PersonEntity;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;



public class Writer  {

    public static FlatFileItemWriter<PersonEntity> writer(String path) {
        FlatFileItemWriter<PersonEntity> writer = new FlatFileItemWriter<PersonEntity>();
        writer.setResource(new ClassPathResource(path));
        writer.setLineAggregator(new DelimitedLineAggregator<PersonEntity>() {{
            setDelimiter(",");
            setFieldExtractor(new BeanWrapperFieldExtractor<PersonEntity>() {{
                setNames(new String[]{"person_id", "name", "age", "address"});
            }});
        }});

        return writer;
    }


}
