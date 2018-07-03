package com.demo.jdk8.builtin.functional.interfaces;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Predicates是一个只有一个参数的返回boolean值的函数<br>
 * 该接口包含了各种默认方法，用来组合predicates完成复杂的逻辑表达（and，or，negate）<br>
 */
public class PredicatesExams {

	public static void main(String[] args) {
		Predicate<String> p = (s) -> s.length() > 0;
		System.out.println(p.test("foo"));// true
		System.out.println(p.negate().test("foo"));// false
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		System.out.println(nonNull.test(Boolean.TRUE)); // true
		System.out.println(isNull.test(null)); // true
		
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		System.out.println(isEmpty.test("")); //  true
		System.out.println(isNotEmpty.test("abc")); // true
	}
}
