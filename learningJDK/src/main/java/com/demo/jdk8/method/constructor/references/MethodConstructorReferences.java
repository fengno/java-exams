package com.demo.jdk8.method.constructor.references;

import com.demo.jdk8.lambda.Converter;

/**
 * Java 8 使用符号 :: 传递方法或构造器的引用
 */
public class MethodConstructorReferences {

	public static void main(String[] args) {
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted); // 123

		Something something = new Something();
		Converter<String, String> converter2 = something::starsWith; // 相当于用something::startsWith实现了接口Converter的convert方法
		System.out.println(converter2.convert("Java"));// J

		// 符号::也可以用在构造器方法中
		// 使用::将接口和实现粘合在一起。
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		// 使用Person::new创建了一个指向Person构造器的引用，Java编译器将会自动挑选匹配PersonFactory.create方法签名的构造器。
		System.out.println(person.getFirstName());
	}
}
