package com.demo.jdk8.lambda.exams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** 对集合中每个元素应用函数 */
public class LambdaExam08 {

	public static void main(String[] args) {
		// Convert String to Uppercase and join them using coma
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		// 将字符串转换为大写，然后使用逗号串起来
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(G7Countries);
	}

}
