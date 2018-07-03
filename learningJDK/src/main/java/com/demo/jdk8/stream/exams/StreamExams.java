package com.demo.jdk8.stream.exams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class StreamExams {
	static List<String> collection = Arrays.asList("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1", "10");

	public static void main(String[] args) {
		/*
		 * filter 接受一个predicate，然后根据其返回真或假对Stream中所有元素进行过滤，
		 * 这个操作是intermediate，所以能对结果再调用其他stream操作(如forEach)处理. ForEach能接受对
		 * stream每个元素执行函数操作 (这个例子中是filtered). ForEach是一个terminal操作. 它返回 void,
		 * 不能基于其结果再调用其他Stream操作了。
		 */
		collection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println); // "aaa2", "aaa1"
		System.out.println("---------------------");

		/*
		 * Sorted是一个intermediate操作，能够返回Stream的排序结果，元素是按自然排序规则，除非你传入一个定制的Comparator.
		 */
		collection.stream().sorted().forEach(System.out::println);
		System.out.println("---------------------");
		collection.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
		System.out.println("---------------------");
		collection.stream().filter((s) -> s.startsWith("a")).sorted().forEach(System.out::println);
		System.out.println("---------------------");

		/*
		 * Map操作也是intermediate的，按给定的函数对每个元素转换操作到一个结果。下面案例是使用函数转换字符串到大写将每个输入字符串转到到大写字符。
		 */
		collection.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
		System.out.println("---------------------");
		// 也可以使用map转换一个对象到另外一个类型，Stream的结果的泛型类型取决于传入函数的泛型类型
		collection.stream().filter((s) -> StringUtils.isNumeric(s)).map(Integer::valueOf).map((s) -> s * s)
				.forEach(System.out::println);
		System.out.println("---------------------");

		/*
		 * Match 各种匹配操作能够用于检测某个predicate是否匹配stream.
		 * 所有这些操作都是terminal，不能再被用作Stream其他操作的输入了，并且只返回一个boolean结果
		 */
		boolean anyStartsWithA = collection.stream().anyMatch((s) -> s.startsWith("a"));
		System.out.println(anyStartsWithA); // true
		boolean allStartsWithA = collection.stream().allMatch((s) -> s.startsWith("a"));
		System.out.println(allStartsWithA); // false
		boolean noneStartsWithZ = collection.stream().noneMatch((s) -> s.startsWith("z"));
		System.out.println(noneStartsWithZ); // true
		System.out.println("---------------------");

		// Count是一个terminal操作，返回Stream中元素的个数，类型是初始类型long.
		long startsWithB = collection.stream().filter((s) -> s.startsWith("b")).count();
		System.out.println(startsWithB); // 3
		System.out.println("---------------------");

		// Reduce 这个terminal操作执行对Stream元素按给定函数执行约简的操作，结果是包含约简好的元素的一个Optional。
		Optional<String> reduced = collection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);	// "10#aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
	}
}
