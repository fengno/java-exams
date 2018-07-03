package com.demo.jdk8.lambda;

// 只包含一个抽象方法的接口可以作为lambda表达式
@FunctionalInterface // 函数接口（有且只有一个抽象方法）,有了该注解后，容易发现编译错误
public interface Converter<F, T> {

	T convert(F from);
}
