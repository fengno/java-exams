package com.demo.jdk8.lambda.exams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** 通过filtering 创建一个字符串String的集合 */
public class LambdaExam07 {

	public static void main(String[] args) {
		/*
		 * Filtering是对大型Collection操作的一个通用操作，<br>
		 * Stream提供filter()方法，接受一个Predicate对象，意味着你能传送lambda表达式作为一个过滤逻辑进入这个方法：
		 */
		List<String> strList = Arrays.asList("abc", "bcd", "defg", "jk");
		// Create a List with String more than 2 characters
		List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

	}

}
