package com.imooc.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value= {Exception.class})
	@ResponseBody
	private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", false);
		modelMap.put("errMsg", e.getMessage());
		return modelMap;
	}
}
