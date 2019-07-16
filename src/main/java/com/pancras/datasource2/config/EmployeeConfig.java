package com.pancras.datasource2.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by lijian on 2018/4/12
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.pancras.datasource2.repository.jpa.employee"},
        transactionManagerRef = "employeeTransactionManager",
        entityManagerFactoryRef = "employeeEntityManagerFactory")
public class EmployeeConfig {

    @Bean(name = "employeeDataSource")
    @ConfigurationProperties(prefix = "employee.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "employeeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("employeeDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.pancras.datasource2.domain.employee")
                .persistenceUnit("employee")
                .build();
    }

    @Bean(name = "employeeTransactionManager")
    public PlatformTransactionManager employeeTransactionManager(@Qualifier("employeeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

   @Bean(name = "employeeEntityManager")
   public EntityManager entityManager(EntityManagerFactoryBuilder builder, DataSource dataSource) {
       return entityManagerFactory(builder, dataSource).getObject().createEntityManager();
   }
}
