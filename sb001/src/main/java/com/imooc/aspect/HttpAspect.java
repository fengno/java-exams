package com.imooc.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Before("execution(public * com.imooc.web.AreaController.listArea(..))")
	public void beforeListArea() {
		logger.info("before listArea......");
	}
	
	@Before("pointCut01()")
	public void before(JoinPoint jp) {
		logger.debug("test info log......");
		logger.info("test info log......");
		logger.warn("test warn log......");
		logger.error("test error log......");
		logger.info("before......");
		//记录请求
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attrs.getRequest();
		// url
		logger.info("url={}.", request.getRequestURL());
		// method
		logger.info("method={}.", request.getMethod());
		// ip
		logger.info("ip={}.", request.getRemoteAddr());
		// 类方法
		logger.info("class_method={}.", jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());
		// 参数
		logger.info("args={}.", jp.getArgs());
	}
	
	@After("pointCut01()")
	public void after() {
		logger.info("after......");
	}
	
	// 提取公共代码
	@Pointcut("execution(public * com.imooc.web.AreaController.*(..))")
	public void pointCut01() {
	}
	
	@AfterReturning(pointcut="pointCut01()", returning="object")
	public void afterReturn(Object object) {
		logger.info("response={}.", object);
	}
}
