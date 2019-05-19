package com.paf.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "orderEntityManagerFactory",
transactionManagerRef = "orderTransactionManager",basePackages = {"com.paf.repository.order"})

public class OrderConfig {
	
	 @Bean(name = "orderDataSource")
	  @ConfigurationProperties(prefix = "udara.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }
}
