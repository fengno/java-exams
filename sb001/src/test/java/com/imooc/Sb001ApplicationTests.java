package com.imooc;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Sb001Application.class, webEnvironment=WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class Sb001ApplicationTests {
	@Autowired
	private TestRestTemplate temp;

	@Test
	public void contextLoads() {
	}

	@Test
	public void hello() {
		String result = null;
		try {
			result = temp.getForObject("/hi", String.class, new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		Assert.assertNotNull(result);
		Assert.assertTrue(result.contains("Hello"));
	}
}
