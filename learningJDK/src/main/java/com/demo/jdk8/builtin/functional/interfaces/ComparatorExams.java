package com.demo.jdk8.builtin.functional.interfaces;

import java.util.Comparator;

/**
 * Comparator 是老版本比较器在Java8应用，Java 8加了默认方法，可以作为Lambda表达式使用，不再需要以前老式专门做一个Comparator实现类了。
 */
public class ComparatorExams {

	public static void main(String[] args) {
		Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");
		System.out.println(comparator.compare(p1, p2)); // > 0
		System.out.println(comparator.reversed().compare(p1, p2)); // < 0
	}

}
