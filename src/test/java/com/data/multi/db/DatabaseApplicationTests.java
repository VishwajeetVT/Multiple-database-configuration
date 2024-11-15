package com.data.multi.db;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DatabaseApplication.class, FlywayTestConfiguration.class})
class DatabaseApplicationTests {

	@Test
	void contextLoads() {
	}

}
