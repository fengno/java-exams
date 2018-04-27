package com.demo;

import org.junit.Assert;
import org.junit.Test;

public class MethodUtilsTest {

	@Test
	public void testTwoIntMultiply() {
		String num1 = "200";
		String num2 = "10";
		String actual = MethodUtils.twoIntMultiply(num1, num2);
		Assert.assertEquals("2000", actual);
		
//		num1 = "0.6";
//		num2 = "0.3";
//		actual = MethodUtils.twoIntMultiply(num1, num2);
//		Assert.assertEquals("0.18", actual);
	}

}
