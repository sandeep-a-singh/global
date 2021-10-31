package com.sunny.enterprise.target;

import com.sunny.enterprise.target.repo.RoleRepository;
import com.sunny.enterprise.target.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
class TargetApplicationTests {

	@Test
	void contextLoads() {

	}

}
