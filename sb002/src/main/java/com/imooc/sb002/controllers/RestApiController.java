package com.imooc.sb002.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

	@GetMapping(value= {"/test/get"})
	public Object get(@RequestParam String username, @RequestParam String passwd) {
		return "username = " + username + ", passwd = " + passwd;
	}
	
	@PostMapping(value= {"/test/post/{username}"})
	public Object post(@PathVariable String username, String data) {
		return "username=" + username + ", data info: " + data;
	}
}
