package com.sunny.enterprise.datasource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {
    PrimaryDatasourceConfig primaryDatasourceConfig = null;
    SecondaryDatasourceConfig secondaryDatasourceConfig = null;

    @Autowired
    DataSourceConfiguration(PrimaryDatasourceConfig primaryDatasourceConfig, SecondaryDatasourceConfig secondaryDatasourceConfig) {
        this.primaryDatasourceConfig = primaryDatasourceConfig;
        this.secondaryDatasourceConfig = secondaryDatasourceConfig;
    }

    @Bean
    @Primary
    public DataSourceProperties primaryDataSourceProperties() {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUsername(primaryDatasourceConfig.getUsername());
        dataSourceProperties.setPassword(primaryDatasourceConfig.getPassword());
        dataSourceProperties.setDriverClassName(primaryDatasourceConfig.getDriverClassName());
        dataSourceProperties.setUrl(primaryDatasourceConfig.getUrl());
        return dataSourceProperties;
    }

    @Bean
    @Primary
    @DependsOn({"primaryDataSourceProperties"})
    public DataSource primaryDataSource() {
        return primaryDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean
    public DataSourceProperties secondaryDataSourceProperties() {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUsername(secondaryDatasourceConfig.getUsername());
        dataSourceProperties.setPassword(secondaryDatasourceConfig.getPassword());
        dataSourceProperties.setDriverClassName(secondaryDatasourceConfig.getDriverClassName());
        dataSourceProperties.setUrl(secondaryDatasourceConfig.getUrl());
        return dataSourceProperties;
    }

    @Bean
    @DependsOn({"secondaryDataSourceProperties"})
    public DataSource secondaryDataSource() {

        return secondaryDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean
    public JdbcTemplate jdbcTemplatePrimaryDataSource(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
        return new JdbcTemplate(primaryDataSource);
    }

    @Bean
    @DependsOn({"secondaryDataSource"})
    public JdbcTemplate jdbcTemplateSecondaryDataSource(@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        return new JdbcTemplate(secondaryDataSource);
    }
}