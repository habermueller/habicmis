package com.habi.habicmis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.hateoas.EntityModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositoryRestRequestsTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void PlainGetShouldAtLeastReturnOk() throws Exception{
		// assertThat(this.restTemplate.getForEntity("http://localhost:" + port + "/repository", EntityModel<Repository>.class).contains("200"));
	}
	
}
