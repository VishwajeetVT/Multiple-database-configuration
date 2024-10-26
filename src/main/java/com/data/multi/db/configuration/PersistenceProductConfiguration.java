package com.data.multi.db.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = { "com.data.multi.db.product.repository"},
        transactionManagerRef = "productTransactionManager",
        entityManagerFactoryRef = "productEntityManager"
)
public class PersistenceProductConfiguration {

    @Bean(name = "productDataSource")
    @ConfigurationProperties(prefix = "spring.product.datasource")
    public DataSource productDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "productEntityManager")
    public LocalContainerEntityManagerFactoryBean productEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("productDataSource") DataSource productDataSource) {

        return builder
                .dataSource(productDataSource)
                .packages("com.data.multi.db.product.model")
                .persistenceUnit("Product")
                .build();
    }

    @Bean(name = "productTransactionManager")
    public PlatformTransactionManager productTransactionManager(
            @Qualifier("productEntityManager") EntityManagerFactory productEntityManager) {
        return new JpaTransactionManager(productEntityManager);
    }
}
