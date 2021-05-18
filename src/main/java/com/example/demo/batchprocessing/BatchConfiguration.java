//package com.example.demo.batchprocessing;
//
//import com.example.demo.dao.db1.IPersonReponsitory;
//import com.example.demo.entity.PersonEntity;
//import com.example.demo.mapper.PersonRowMapper;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
//import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.core.RowMapper;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfiguration {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    public IPersonReponsitory personReponsitory;
//
//    @Autowired
//    public DataSource dataSource;
//
//    @Autowired
//    public PersonItemProcessor personItemProcessor;
//
//
////    @Bean
////    public ItemReader<PersonEntity> reader() {
////        return new FlatFileItemReaderBuilder<PersonEntity>()
////                .name("personItemReader")
////                .resource(new ClassPathResource("persons.csv"))
////                .delimited()
////                .names(new String[] {"name", "Age", "address"})
////                .fieldSetMapper(new BeanWrapperFieldSetMapper<PersonEntity>() {{
////                    setTargetType(PersonEntity.class);
////                }})
////                .build();
////    }
//
//
////    @Bean
////    public ItemWriter<PersonEntity> writer() {
////        RepositoryItemWriter<PersonEntity> writer = new RepositoryItemWriter<>();
////        writer.setRepository(personReponsitory);
////        writer.setMethodName("save");
////        return writer;
////    }
//
//    @Bean
//    @StepScope
//    public JdbcCursorItemReader<PersonEntity> reader() {
//        JdbcCursorItemReader<PersonEntity> reader = new JdbcCursorItemReader<PersonEntity>();
//        reader.setDataSource(dataSource);
//        reader.setSql("SELECT person_id,name,age,address FROM person");
//        reader.setRowMapper(new PersonRowMapper());
//
//        return reader;
//    }
//
//
//    @Bean
//    public ItemProcessor<PersonEntity, PersonEntity> processor()
//    {
//        return new PersonItemProcessor();
//    }
//
//
//
//
//    @Bean
//    public FlatFileItemWriter<PersonEntity> writerToCsv() {
//        FlatFileItemWriter<PersonEntity> writer = new FlatFileItemWriter<PersonEntity>();
//        writer.setResource(new ClassPathResource("persons.csv"));
//        writer.setLineAggregator(new DelimitedLineAggregator<PersonEntity>() {{
//            setDelimiter(",");
//            setFieldExtractor(new BeanWrapperFieldExtractor<PersonEntity>() {{
//                setNames(new String[]{"person_id", "name", "age", "address"});
//            }});
//        }});
//
//        return writer;
//    }
//
//    @Bean
//    public FlatFileItemWriter<PersonEntity> writerToPdf() {
//        FlatFileItemWriter<PersonEntity> writer = new FlatFileItemWriter<PersonEntity>();
//        writer.setResource(new ClassPathResource("persons.pdf"));
//        writer.setLineAggregator(new DelimitedLineAggregator<PersonEntity>() {{
//            setDelimiter(",");
//            setFieldExtractor(new BeanWrapperFieldExtractor<PersonEntity>() {{
//                setNames(new String[]{"person_id", "name", "age", "address"});
//            }});
//        }});
//
//        return writer;
//    }
//
//    @Bean
//    public FlatFileItemWriter<PersonEntity> writerToExcel() {
//        FlatFileItemWriter<PersonEntity> writer = new FlatFileItemWriter<PersonEntity>();
//        writer.setResource(new ClassPathResource("persons.excel"));
//        writer.setLineAggregator(new DelimitedLineAggregator<PersonEntity>() {{
//            setDelimiter(",");
//            setFieldExtractor(new BeanWrapperFieldExtractor<PersonEntity>() {{
//                setNames(new String[]{"person_id", "name", "age", "address"});
//            }});
//        }});
//
//        return writer;
//    }
//
//    @Bean
//    public Job importOrderJob() {
//        return jobBuilderFactory.get("exportPersonJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(new JobCompletionNotificationListene())
//                .start(step1())
//                .next(step2())
//                .next(step3())
//                .build();
//    }
//
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1").<PersonEntity, PersonEntity>chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writerToCsv())
//                .build();
//    }
//
//    @Bean
//    public Step step2() {
//        return stepBuilderFactory.get("step2").<PersonEntity, PersonEntity>chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writerToExcel())
//                .build();
//    }
//
//    @Bean
//    public Step step3() {
//        return stepBuilderFactory.get("step3").<PersonEntity, PersonEntity>chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writerToPdf())
//                .build();
//    }
//
//}
