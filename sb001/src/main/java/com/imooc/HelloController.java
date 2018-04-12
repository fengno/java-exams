package com.imooc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value= {"/hello", "/hi"})
	public Object hello() {
		return "Hello, Spring Boot";
	}
}
