package com.jangni.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/2/25/025 17:05
 */
@Configuration
public class DataSourceConfig {
    @Bean(name="dataSource")
    public DataSource datasource(Environment environment){
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        ds.setUsername(environment.getProperty("spring.datasource.username"));
        ds.setPassword(environment.getProperty("spring.datasource.password"));
        ds.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }
}
