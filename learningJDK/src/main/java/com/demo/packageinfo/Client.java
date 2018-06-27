package com.demo.packageinfo;

import java.lang.annotation.Annotation;

public class Client {

	public static void main(String[] args) {
		// 可以通过I/O操作或配置项获得包名
		String pkgName = "com.demo.packageinfo";
		
		Package pkg = ClassLoader.getSystemClassLoader().getDefinedPackage(pkgName);
		
		if (pkg != null && pkg.isAnnotationPresent(PkgAnnotation.class)) {
			PkgAnnotation annotation = pkg.getAnnotation(PkgAnnotation.class);
			if (null != annotation) {
				System.out.println("package version: " + annotation.version());
			}
		}
		
		// 获得包上的注解
		Annotation[] annotations = pkg.getAnnotations();
		// 遍历注解数组 
		for (Annotation annotation : annotations) {
			if (annotation instanceof PkgAnnotation) {
				System.out.println("Hi, I'm the PkgAnnotation");
				/*
				 * 注解操作
				PkgAnnotation pkgAnnotation = (PkgAnnotation)annotation;
				 */
			}
		}

	}

}
