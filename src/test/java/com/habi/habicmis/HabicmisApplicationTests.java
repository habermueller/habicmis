package com.habi.habicmis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.habi.habicmis.controller.CMISRepositoryController;

@SpringBootTest
class HabicmisApplicationTests {

	@Autowired
	private CMISRepositoryController controller;
	
	@Test
	void contextLoads() {
		
		assertThat(controller).isNotNull();
	}
	
	

}
