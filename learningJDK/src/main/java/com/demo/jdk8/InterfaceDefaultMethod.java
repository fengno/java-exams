package com.demo.jdk8;

// 接口可以定义默认方法
public interface InterfaceDefaultMethod {

	double calculate(int a);
	// 使用default增加非抽象方法实现到接口中
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
