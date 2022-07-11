package com.zyh.todo;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void dataSourceTest() {
		System.out.printf(String.valueOf(dataSource.getClass()));
	}

}
