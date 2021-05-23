package com.sunny.enterprise.datasource.config;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PropertySourceFactory;

@Configuration
@EnableAutoConfiguration
@PropertySource(value = "classpath:config/datasource.yml", factory = PropertySourceFactory.class)
@ConfigurationProperties(prefix = "spring.secondary.datasource")
public class SecondaryDatasourceConfig extends DataSourceFileConfig {
    private static final Logger LOGGER = LogManager.getLogger(SecondaryDatasourceConfig.class.getName());

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info(this.toString());
        return this.toString();
    }
}