package com.pranav.demo;
import com.pranav.demo.dao.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJpaApplicationTests {

	@Autowired
	AlienRepo repo;
	@Test
	public void testeDelete()
	{
		repo.deleteById(1);
		assertThat(repo.existsById(1)).isFalse();
	}
}
