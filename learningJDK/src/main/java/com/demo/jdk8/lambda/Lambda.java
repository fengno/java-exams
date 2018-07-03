package com.demo.jdk8.lambda;

import java.util.Objects;

public class Lambda {

	final static String salutation = "Hello! ";
	static int outerStaticNum;
	int outerNum;

	public static void main(String[] args) {
		Objects.hashCode(new Lambda());
		Lambda tester = new Lambda();

		// 类型声明
		MathOperation addition = (int a, int b) -> a + b;

		// 不用类型声明
		MathOperation subtraction = (a, b) -> a - b;

		// 大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// 没有大括号及返回语句
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		// 不用括号
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// 用括号
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Runoob");
		greetService2.sayMessage("Google");
		
		// 无参
		HelloWorld hello = () -> System.out.println("Hello World");
		hello.helloWorld();

		/* 访问局部变量  */
		// lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
		GreetingService greetService3 = message -> System.out.println(salutation + message);
		greetService3.sayMessage("Runoob");

		// 可以直接在 lambda 表达式中访问外层的局部变量（可以不用声明为final，但必须不可被后面的代码修改[即隐性的具有final的语义])
		final int num = 1;
		ConverterTest s = (param) -> System.out.println(String.valueOf(param + num));
		s.convert(2); // 输出结果为 3
		int notFinalNum = 2;
		s = (param) -> System.out.println(String.valueOf(param + notFinalNum));
		s.convert(2); // 输出结果为 4
//		notFinalNum = 2; // 一旦被写入了Lambda表达式的变量不能再被修改了，否则lambda表达式会编译错误
		
	}
	
	void testScopes() {
		/* 访问字段和静态变量  
		 * 在Lambda表达式中可以对实例的字段和静态变量进行读和写
		 */
		Converter<Integer, String> strConverter1 = (from) -> {
			outerNum = 23;
			return String.valueOf(from);
		};
		outerNum = 32;
		System.out.println(strConverter1.convert(321));
		Converter<Integer, String> strConverter2 = (from) -> {
			outerStaticNum = 72;
			return String.valueOf(from);
		};
		outerStaticNum = 27;
		System.out.println(strConverter2.convert(456));
	}

	public interface ConverterTest {
		void convert(int i);
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}
	
	interface HelloWorld {
		void helloWorld();
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
