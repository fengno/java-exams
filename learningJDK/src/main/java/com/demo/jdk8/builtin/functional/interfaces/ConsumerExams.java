package com.demo.jdk8.builtin.functional.interfaces;

import java.util.function.Consumer;

/**
 * Consumer 是对单个输入参数执行的一些操作<br>
 */
public class ConsumerExams {

	public static void main(String[] args) {
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
		greeter.accept(new Person("Luke", "Skywalker"));
	}

}
