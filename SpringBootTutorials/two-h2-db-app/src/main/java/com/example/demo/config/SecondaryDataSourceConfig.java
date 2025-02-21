package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class SecondaryDataSourceConfig {

    @Bean(name = "secondaryDataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:db2;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL")
                .username("sa")
                .password("password")
                .driverClassName("org.h2.Driver")
                .build();
    }

    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("secondaryDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.example.demo.model");
        return factoryBean;
    }
}
