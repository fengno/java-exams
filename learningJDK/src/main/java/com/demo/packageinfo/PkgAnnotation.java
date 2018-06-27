package com.demo.packageinfo;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 定义一个标注在包上的注解定义 <br>
 * 项目中可以放置在包上的常用注解有：
 * <li>Struts的@namespace</li>
 * <li>Hibernate的@FilterDef和@TypeDef等</li>
 */
@Retention(RUNTIME)
@Target(PACKAGE)
public @interface PkgAnnotation {

	public String version() default "";
}
