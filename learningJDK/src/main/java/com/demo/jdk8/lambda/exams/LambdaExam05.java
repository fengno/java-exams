package com.demo.jdk8.lambda.exams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/** 复杂的结合Predicate 使用 */
public class LambdaExam05 {

	public static void main(String[] args) {
		// java.util.function.Predicate提供and(), or() 和
		// xor()可以进行逻辑操作，比如为了得到一串字符串中以"J"开头的4个长度
		// We can even combine Predicate using and(), or() And xor() logical functions
		// for example to find names, which starts with J and four letters long, you
		// can pass combination of two Predicate
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		List<String> names = Arrays.asList("Java", "Scala", "Lisp");
		names.stream().filter(startsWithJ.and(fourLetterLong)) // 其中startsWithJ.and(fourLetterLong)是使用了AND逻辑操作
				.forEach((n) -> System.out.print("Name, which starts with 'J' and four letter long is : " + n));
	}
}
