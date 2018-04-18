package com.imooc.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.RestTester;
import com.imooc.Sb001Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {Sb001Application.class}, webEnvironment=WebEnvironment.DEFINED_PORT)
@EnableAutoConfiguration
public class AreaControllerTest {
	@Autowired
	private TestRestTemplate temp;
	@Autowired
	private RestTester tester;
	
	@Test
	public void testTransactionAreaRuntimeException() {
		ResponseEntity<String> respEnt = temp.getForEntity("/area/transaction/arearun", String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		Assert.assertTrue(respEnt.getBody().contains("false"));
	}
	
	@Test
	public void testTransaction() {
		ResponseEntity<String> respEnt = temp.getForEntity("/area/transaction", String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		Assert.assertTrue(respEnt.getBody().contains("false"));
	}
	
	@Test
	public void genException() {
		ResponseEntity<String> respEnt = temp.getForEntity("/area/exception", String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}
	
	@Test
	public void genAreaException() {
		ResponseEntity<String> respEnt = temp.getForEntity("/area/areaexception", String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}
	
	@Test
	public void listArea() {
		ResponseEntity<String> respEnt = temp.getForEntity("/area/list", String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}
	
	@Test
	public void getAreaById() {
		ResponseEntity<String> respEnt = temp.getForEntity("/area/byid?id=1", String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}

	@Test
	public void addArea() {
		Map<String, Object> request = new HashMap<>();
		request.put("areaName", "new area1");
		request.put("priority", 21);
		Class<?> responseType = String.class;
		Object urlVariables = null;
		ResponseEntity<?> respEnt = temp.postForEntity("/area", request, responseType, urlVariables);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}
	
	@Test
	public void addAreaJson() {
		Map<String, Object> request = new HashMap<>();
		request.put("name", "new area2");
		request.put("priority", 22);
		Class<?> responseType = String.class;
		Object urlVariables = null;
		ResponseEntity<?> respEnt = temp.postForEntity("/area/json", request, responseType, urlVariables);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}
	
	@Test
	public void modifyArea001() {
		int areaId = 5;
		ResponseEntity<String> respEnt = temp.getForEntity("/area/byid?id=" + areaId, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
		
		Map<String, Object> request = new HashMap<>();
		request.put("areaName", "update area");
		request.put("areaId", areaId);
		temp.put("/area", request, new Object[] {});

		respEnt = temp.getForEntity("/area/byid?id=" + areaId, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}
	
	@Test
	public void modifyArea002() {
		int areaId = 5;
		ResponseEntity<String> respEnt = temp.getForEntity("/area/byid?id=" + areaId, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
		
		tester.set("areaName", "update area2");
		tester.set("areaId", "" + areaId);
		respEnt = tester.exchange("http://127.0.0.1:8082/demo/area", HttpMethod.PUT, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
		
		respEnt = temp.getForEntity("/area/byid?id=" + areaId, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}
	
	@Test
	public void removeArea001() {
		int areaId = 7;
		ResponseEntity<String> respEnt = temp.getForEntity("/area/byid?id=" + areaId, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
		
		temp.delete("/area/" + areaId);
		
		respEnt = temp.getForEntity("/area/byid?id=" + areaId, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}
	
	@Test
	public void removeArea002() {
		int areaId = 6;
		ResponseEntity<String> respEnt = temp.getForEntity("/area/byid?id=" + areaId, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
		
		respEnt = tester.exchange("http://127.0.0.1:8082/demo/area/" + areaId, HttpMethod.DELETE, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
		
		respEnt = temp.getForEntity("/area/byid?id=" + areaId, String.class);
		Assert.assertEquals(respEnt.getStatusCode(), HttpStatus.OK);
		System.out.println(respEnt.getBody());
	}
}
