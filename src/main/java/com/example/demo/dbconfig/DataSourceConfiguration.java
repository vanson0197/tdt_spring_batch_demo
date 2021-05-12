
package com.example.demo.dbconfig;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
public class DataSourceConfiguration {
    @Autowired
    private Environment env;


    @Bean
    @ConfigurationProperties(prefix = "spring.product")
    public DataSource productDataSource() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.product.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.product.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.product.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.product.datasource.password"));
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.person")
    public DataSource personDataSource() throws SQLException {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(env.getProperty("spring.person.datasource.driver-class-name"));
            dataSource.setUrl(env.getProperty("spring.person.datasource.url"));
            dataSource.setUsername(env.getProperty("spring.person.datasource.username"));
            dataSource.setPassword(env.getProperty("spring.person.datasource.password"));
            return dataSource;
    }


    @Bean
    public JdbcTemplate mysqlJdbcTemplate(@Qualifier("personDataSource") final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

