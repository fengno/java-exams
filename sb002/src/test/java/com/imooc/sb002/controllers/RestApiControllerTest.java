package com.imooc.sb002.controllers;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.sb002.Sb002Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Sb002Application.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class RestApiControllerTest {
	
	@Autowired
	private TestRestTemplate temp;

	@Test
	public void get() {
		String url = "/test/get?username= {username}&passwd= {passwd}";
		Map<String, String> map = new HashMap<>();
		map.put("username", "lake");
		map.put("passwd", "west");
		String result = temp.getForObject(url , String.class, map);
		System.out.println(result);
		
		/*
		 *  缺少参数报错
		url = "/test/get?username= {username}";
		map = new HashMap<>();
		map.put("username", "lake");
		result = temp.getForObject(url , String.class, map);
		System.out.println(result);
		 */
	}
	
	@Test
	public void post() {
		String url = "/test/post/westlake";
		String result = temp.postForObject(url, null, String.class);
		System.out.println(result);
	}

}
