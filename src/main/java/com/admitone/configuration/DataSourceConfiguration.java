package com.admitone.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DataSourceConfiguration {

    private BasicDataSource pooledDataSource;

    @Autowired
    Environment environment;

    @Bean(name = "dataSource")
    public BasicDataSource dataSource() {

        this.pooledDataSource = new BasicDataSource();

        final String databaseDriver = environment
                .getProperty("datasource.driver-class-name");
        final String databaseUrl = environment
                .getProperty("datasource.url");
        final String databaseUsername = System
                .getProperty("user");
        final String databasePassword = System.getProperty("pass");
        final String poolSize = environment
                .getProperty("connectionpool.maxSize");

            pooledDataSource.setDriverClassName(databaseDriver);
            pooledDataSource.setUrl(databaseUrl);
            pooledDataSource.setUsername(databaseUsername);
            pooledDataSource.setPassword(databasePassword);
            pooledDataSource.setInitialSize(Integer.parseInt(poolSize));

        return pooledDataSource;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource());

        // Classpath scanning of @Component, @Service, etc annotated class
        entityManagerFactory.setPackagesToScan("com.admitone");

        // Vendor adapter
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);


        entityManagerFactory.setJpaProperties(mySQLHibernateProperties());

        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager =
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactory().getObject());
        return transactionManager;
    }


    Properties mySQLHibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                setProperty("hibernate.jdbc.batch_size", "1000");
                setProperty("hibernate.enable_lazy_load_no_trans", "true");
            }
        };
    }
}
