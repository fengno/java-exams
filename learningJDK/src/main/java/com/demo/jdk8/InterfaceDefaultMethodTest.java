package com.demo.jdk8;

import org.junit.Assert;
import org.junit.Test;

public class InterfaceDefaultMethodTest {

	@Test
	public void test() {
		InterfaceDefaultMethod object = new InterfaceDefaultMethod() {
			
			@Override
			public double calculate(int a) {
				return sqrt(a * 100); // 调用了default方法
				// 接口定义的默认方法，可以被匿名对象访问，但不能在Lambda表达式中访问。
			}
		};
		Assert.assertEquals(100, object.calculate(100), 0);
		Assert.assertEquals(4, object.sqrt(16), 0);
	}

}
