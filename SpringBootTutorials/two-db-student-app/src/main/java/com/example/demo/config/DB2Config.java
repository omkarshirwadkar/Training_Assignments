package com.example.demo.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "secondEntityMangerFactory",
		basePackages = {"com.example.demo.repo2"} ,
		transactionManagerRef = "secondTransactionManager"
		)
public class DB2Config {
     
	@Autowired
	private Environment environment;
	
	@Bean(name="secondDataSource")
	@Primary
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("second.datasource.url"));
		dataSource.setDriverClassName(environment.getProperty("second.datasource.driver-class-name"));
		dataSource.setUsername(environment.getProperty("second.datasource.username"));
		dataSource.setPassword(environment.getProperty("second.datasource.password"));
		
		return dataSource;
	}
	
	
	//entityManagerFactory
	@Bean("secondEntityMangerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFatory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.example.demo.entities");
		
		 HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		    bean.setJpaVendorAdapter(vendorAdapter);
		    
		Properties properties = new Properties();
	    properties.setProperty("hibernate.hbm2ddl.auto", "update"); // Change as needed
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

	    bean.setJpaProperties(properties);
		return bean;
	}
	
	
	
	
	
	//platformTransactionManager
	
	@Bean(name="secondTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFatory().getObject());
		return manager;
	}
}
