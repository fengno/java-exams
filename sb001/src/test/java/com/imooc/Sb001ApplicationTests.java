package com.imooc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Sb001Application.class, webEnvironment=WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class Sb001ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
