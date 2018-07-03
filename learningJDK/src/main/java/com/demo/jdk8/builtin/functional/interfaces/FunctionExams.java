package com.demo.jdk8.builtin.functional.interfaces;

import java.util.function.Function;

/**
 * Function 接受一个输入参数，产生一个结果，<br>
 * 默认方法能被多个函数一起作为链条一样使用（compose，andThen）<br>
 */
public class FunctionExams {

	public static void main(String[] args) {
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		System.out.println(backToString.apply("123")); // "123"
	}

}
