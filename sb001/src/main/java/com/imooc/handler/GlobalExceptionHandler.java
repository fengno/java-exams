package com.imooc.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.AreaRuntimeException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(value= {Exception.class})
	@ResponseBody
	private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) {
		logger.error("【异常】", e);
		Map<String, Object> modelMap = new HashMap<>();
		if (e instanceof AreaRuntimeException) {
			// 这部分代码可提取成单独一个方法（areaExceptionHandler）
			logger.error("【区域运行时异常】");
			modelMap.put("result", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		modelMap.put("result", false);
		modelMap.put("errMsg", e.getMessage());
		return modelMap;
	}
	
	/*
	@ExceptionHandler(value= {AreaRuntimeException.class})
	@ResponseBody
	private Map<String, Object> areaExceptionHandler(HttpServletRequest req, Exception e) {
		logger.error("【区域运行时异常】", e);
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", false);
		modelMap.put("errMsg", e.getMessage());
		return modelMap;
	}
	*/
}
