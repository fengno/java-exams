package com.demo.jdk8.lambda;

import org.junit.Assert;
import org.junit.Test;


public class ConverterTest {

	@Test
	public void test() {
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		Assert.assertTrue(123 == converted);
	}

}
