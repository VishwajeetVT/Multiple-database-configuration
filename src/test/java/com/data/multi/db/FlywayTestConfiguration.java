package com.data.multi.db;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class FlywayTestConfiguration {

    @Bean(initMethod = "migrate")
    public Flyway userFlyway(@Qualifier("userDataSource") DataSource userDataSource) {
        return Flyway.configure()
                .dataSource(userDataSource)
                .locations("classpath:db/migration/user")
                .load();
    }

    @Bean(initMethod = "migrate")
    public Flyway productFlyway(@Qualifier("productDataSource") DataSource productDataSource) {
        return Flyway.configure()
                .dataSource(productDataSource)
                .locations("classpath:db/migration/product")
                .load();
    }
}
