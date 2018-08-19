package com.boot.config;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Bean
    @Primary
    public DataSource dataSource() {
        return createDasBootDataSource();
    }

    @Bean
    @FlywayDataSource
    public DataSource flywayDataSource() {
        return createDasBootDataSource();
    }

    private DataSource createDasBootDataSource() {
        return GenericBuilder.of(DriverManagerDataSource::new)
                .setProperty(DriverManagerDataSource::setDriverClassName, "org.h2.Driver")
                .setProperty(DriverManagerDataSource::setUrl, "jdbc:h2:file:~/dasboot")
                .setProperty(DriverManagerDataSource::setUsername, "sa")
                .build();
    }

}
