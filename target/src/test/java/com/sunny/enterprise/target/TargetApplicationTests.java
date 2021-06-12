package com.sunny.enterprise.target;

import com.sunny.enterprise.target.repo.RoleRepository;
import com.sunny.enterprise.target.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class TargetApplicationTests {
	@MockBean
	RoleRepository roleRepository;

	@MockBean
	UserRepository userRepository;

	@Test
	void contextLoads() {

	}

}
