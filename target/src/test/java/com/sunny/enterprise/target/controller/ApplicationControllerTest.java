package com.sunny.enterprise.target.controller;

import com.sunny.enterprise.target.repo.RoleRepository;
import com.sunny.enterprise.target.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApplicationControllerTest {

    @Container
    MySQLContainer mySQLContainer = (MySQLContainer) new MySQLContainer("mysql:latest")
            .withDatabaseName("spring-reddit-test-db")
            .withUsername("testuser")
            .withPassword("pass");

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Test
    void testGetUsers()
    {
        Assertions.assertNotNull(userRepository.getUsers());
    }
}
