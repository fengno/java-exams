package com.demo.jdk8.lambda.exams;

import java.util.Arrays;
import java.util.List;

/** 使用Lambda实现Map 和 Reduce */
public class LambdaExam06 {
	public static void main(String[] args) {
		// 最流行的函数编程概念是map，它允许你改变你的对象
		// applying 12% VAT on each purchase
		// Without lambda expressions:
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			System.out.println(price);
		}

		// With Lambda expression:
		costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);

		// reduce() 是将集合中所有值结合进一个，Reduce类似SQL语句中的sum(), avg() 或count(),
		// Old way:
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			total = total + price;

		}
		System.out.println("Total : " + total);

		// New way:
		double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
	}
}
