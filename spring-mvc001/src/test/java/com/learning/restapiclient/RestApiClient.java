package com.learning.restapiclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSON;

public class RestApiClient {
	
	@Test
	public void doGet001() {
		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建一个GET对象
		HttpGet getRequest = new HttpGet("http://localhost:9988/spring-mvc002/rest/members");
		CloseableHttpResponse response = null;
		try {
			//执行请求
			response = client.execute(getRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//取响应的结果
		StatusLine statusLine = response.getStatusLine();
		System.out.println(ReflectionToStringBuilder.toString(statusLine, ToStringStyle.MULTI_LINE_STYLE));
		HttpEntity entity = response.getEntity();
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//关闭httpclient
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doGet002() {
		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建一个GET对象
		HttpGet getRequest = new HttpGet("http://localhost:9988/spring-mvc002/rest/members/1236");
		CloseableHttpResponse response = null;
		try {
			//执行请求
			response = client.execute(getRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//取响应的结果
		StatusLine statusLine = response.getStatusLine();
		System.out.println(ReflectionToStringBuilder.toString(statusLine, ToStringStyle.MULTI_LINE_STYLE));
		HttpEntity entity = response.getEntity();
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//关闭httpclient
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doGet003() {
		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建一个GET对象
		HttpGet getRequest = new HttpGet("http://localhost:9988/spring-mvc002/rest/members/id?id=123678");
		CloseableHttpResponse response = null;
		try {
			//执行请求
			response = client.execute(getRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//取响应的结果
		StatusLine statusLine = response.getStatusLine();
		System.out.println(ReflectionToStringBuilder.toString(statusLine, ToStringStyle.MULTI_LINE_STYLE));
		HttpEntity entity = response.getEntity();
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//关闭httpclient
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doPostWithJson() {
		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建一个POST对象
		HttpPost postRequest = new HttpPost("http://localhost:9988/spring-mvc002/rest/members");
		// or
//		HttpPost postRequest = new HttpPost("http://localhost:9988/spring-mvc002/rest/members/json");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "zhangsan123");
		map.put("phoneNumber", "12387654321");
		
		CloseableHttpResponse response = null;
		try {
			//包装成一个Entity对象
			StringEntity entityStr = new StringEntity(JSON.toJSONString(map), "utf-8");
			entityStr.setContentType("application/json");
			//设置请求的内容
			postRequest.setEntity(entityStr);
			
			//执行请求
			response = client.execute(postRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//取响应的结果
		StatusLine statusLine = response.getStatusLine();
		System.out.println(ReflectionToStringBuilder.toString(statusLine, ToStringStyle.MULTI_LINE_STYLE));
		HttpEntity entity = response.getEntity();
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//关闭httpclient
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doPostWithKeyValue() {
		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建一个POST对象
		HttpPost postRequest = new HttpPost("http://localhost:9988/spring-mvc002/rest/members/form");
		
		List<NameValuePair> kvList = new ArrayList<>();
		kvList.add(new BasicNameValuePair("name","zhangsan"));
		kvList.add(new BasicNameValuePair("phoneNumber","12387654321"));
		kvList.add(new BasicNameValuePair("pageNo","132"));
		
		CloseableHttpResponse response = null;
		try {
			//包装成一个Entity对象
			StringEntity entityStr = new UrlEncodedFormEntity(kvList,"utf-8");
			//设置请求的内容
			postRequest.setEntity(entityStr);
			
			//执行请求
			response = client.execute(postRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//取响应的结果
		StatusLine statusLine = response.getStatusLine();
		System.out.println(ReflectionToStringBuilder.toString(statusLine, ToStringStyle.MULTI_LINE_STYLE));
		HttpEntity entity = response.getEntity();
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//关闭httpclient
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doPostWithFormUrlencoded() {
		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建一个POST对象
		HttpPost postRequest = new HttpPost("http://localhost:9988/spring-mvc002/rest/members/form");
		
		String postDataEncode = "name=1&pageNo=132" ;
		
		CloseableHttpResponse response = null;
		try {
			//包装成一个Entity对象
			StringEntity entityStr = new StringEntity(postDataEncode, "utf-8");
			entityStr.setContentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE.toString());
			//设置请求的内容
			postRequest.setEntity(entityStr);
			
			//执行请求
			response = client.execute(postRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//取响应的结果
		StatusLine statusLine = response.getStatusLine();
		System.out.println(ReflectionToStringBuilder.toString(statusLine, ToStringStyle.MULTI_LINE_STYLE));
		HttpEntity entity = response.getEntity();
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//关闭httpclient
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doPostWithXML() {
		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建一个POST对象
		HttpPost postRequest = new HttpPost("http://localhost:9988/spring-mvc002/rest/members/json");
		
		String xmlStr = "<root><name>1</name><pageNo>132</pageNo></root>" ;
		
		CloseableHttpResponse response = null;
		try {
			//包装成一个Entity对象
			StringEntity entityStr = new StringEntity(xmlStr, "utf-8");
			entityStr.setContentType(MediaType.APPLICATION_XML_VALUE.toString());
			//设置请求的内容
			postRequest.setEntity(entityStr);
			
			//执行请求
			response = client.execute(postRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//取响应的结果
		StatusLine statusLine = response.getStatusLine();
		System.out.println(ReflectionToStringBuilder.toString(statusLine, ToStringStyle.MULTI_LINE_STYLE));
		HttpEntity entity = response.getEntity();
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//关闭httpclient
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doPutWithJson() {
		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建一个PUT对象
		HttpPut putRequest = new HttpPut("http://localhost:9988/spring-mvc002/rest/members/432");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "zhangsan123");
		map.put("phoneNumber", "12387654321");
		
		CloseableHttpResponse response = null;
		try {
			//包装成一个Entity对象
			StringEntity entityStr = new StringEntity(JSON.toJSONString(map), "utf-8");
			entityStr.setContentType("application/json");
			//设置请求的内容
			putRequest.setEntity(entityStr);
			
			//执行请求
			response = client.execute(putRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//取响应的结果
		StatusLine statusLine = response.getStatusLine();
		System.out.println(ReflectionToStringBuilder.toString(statusLine, ToStringStyle.MULTI_LINE_STYLE));
		HttpEntity entity = response.getEntity();
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//关闭httpclient
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doDelete() {
		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建一个PUT对象
		HttpDelete putRequest = new HttpDelete("http://localhost:9988/spring-mvc002/rest/members/54321");
		
		CloseableHttpResponse response = null;
		try {
			//执行请求
			response = client.execute(putRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//取响应的结果
		StatusLine statusLine = response.getStatusLine();
		System.out.println(ReflectionToStringBuilder.toString(statusLine, ToStringStyle.MULTI_LINE_STYLE));
		HttpEntity entity = response.getEntity();
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//关闭httpclient
			response.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
