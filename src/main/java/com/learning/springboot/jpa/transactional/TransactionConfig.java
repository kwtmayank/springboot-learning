package com.learning.springboot.jpa.transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
public class TransactionConfig {

    //@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        driverManagerDataSource.setUrl("jdbc:h2:mem:userDB");
        driverManagerDataSource.setUsername("sa");
        driverManagerDataSource.setPassword("password");
        return driverManagerDataSource;
    }

   // @Bean
    public PlatformTransactionManager executionTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

   // @Bean
    public TransactionTemplate executionTransactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }
}
