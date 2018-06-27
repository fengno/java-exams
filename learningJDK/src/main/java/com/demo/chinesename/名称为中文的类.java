package com.demo.chinesename;

public class 名称为中文的类 {

	private String 字符串变量 = "Java是支持中文名称的变量的，类名也是";
	
	public static void main(String[] args) {
		名称为中文的类 名称为中文的类实例 = new 名称为中文的类();
		System.out.println(名称为中文的类实例.get字符串变量());
	}

	public String get字符串变量() {
		return 字符串变量;
	}

	public void set字符串变量(String 字符串变量) {
		this.字符串变量 = 字符串变量;
	}
}
