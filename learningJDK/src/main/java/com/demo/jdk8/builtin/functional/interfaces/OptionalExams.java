package com.demo.jdk8.builtin.functional.interfaces;

import java.util.Optional;

/**
 * Optional 并不是函数接口，它是一个能够阻止空指针错误NullPointerException小巧的工具。<br>
 * Optional是一个值容器，这个值可以是空或不空。过去我们一个方法应该返回不空的值，但是可能返回空，那么现在我们可以使用Java 8，返回一个Optional即可
 */
public class OptionalExams {

	public static void main(String[] args) {
		Optional<String> optional = Optional.of("bam");
		System.out.println(optional.isPresent()); // true
		System.out.println(optional.get()); // "bam"
		System.out.println(optional.orElse("fallback")); // "bam"
		optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"
		
		optional = Optional.empty();
		System.out.println(optional.isPresent());
		System.out.println(optional.orElse("fallback"));
	} 

}
