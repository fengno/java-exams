package com.demo.jdk8.builtin.functional.interfaces;

import java.util.function.Supplier;

/**
 * Supplier 产生一个给定泛型类型的结果，不像Function，Supplier 并不接受输入参数<br>
 */
public class SupplierExams {

	public static void main(String[] args) {
		Supplier<Person> personSupplier = Person::new;
		Person p1 = personSupplier.get(); // new Person
		Person p2 = personSupplier.get();
		System.out.println(p1 == p2); // false
	}

}
