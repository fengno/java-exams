package com.demo.jdk8.lambda.exams;

import java.util.Arrays;
import java.util.List;

/** 使用Lambda表达式遍历List集合 */
public class LambdaExam03 {

	public static void main(String[] args) {
		// Prior Java 8 :
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}

		// In Java 8:
		features.forEach(n -> System.out.println(n));

		// Even better use Method reference feature of Java 8
		// method reference is denoted by :: (double colon) operator
		// looks similar to score resolution operator of C++
		features.forEach(System.out::println);// 方法引用使用两个冒号::这个操作符
	}
}
