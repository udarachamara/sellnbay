package com.paf.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "customerEntityManagerFactory",
		transactionManagerRef = "customerTransactionManager",basePackages = {"com.paf.repository.customer"})
public class deliveryConfig {
	@Bean(name = "deliveryDataSource")
	  @ConfigurationProperties(prefix = "shasikala.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }

	  @Bean(name = "deliveryEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean deliveryEntityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("deliveryDataSource") DataSource dataSource) {
	    return builder.dataSource(dataSource).packages("com.paf.model").persistenceUnit("delivery")
	        .build();
	  }

	  @Bean(name = "deliveryTransactionManager")
	  public PlatformTransactionManager deliveryTransactionManager(
	      @Qualifier("deliveryEntityManagerFactory") EntityManagerFactory deliveryEntityManagerFactory) {
	    return new JpaTransactionManager(deliveryEntityManagerFactory);
	  }

}
