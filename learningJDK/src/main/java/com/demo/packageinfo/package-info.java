/**
 * 参考：http://strong-life-126-com.iteye.com/blog/806246 <br>
 * 包目录下“package-info.java”，是一个类文件，会被编译成package-info.class，<br>
 * 但该文件中只能声明默认访问权限的类。<br>
 * 其作用有三个：<br>
 * <p>为标注在包上Annotation提供便利</p>
 * <p>声明友好类和包常量</p>
 * <p>提供包的整体注释说明（描述和记录本包信息）</p>
 */
@com.demo.packageinfo.PkgAnnotation(version="1.0")
package com.demo.packageinfo;

// 这里是包类，声明一个包使用的公共类，强调的是包访问权限
class PkgClass {
	public void common() {
		System.out.println("common");
	}
}

// 定义了泛型
class PackageInfoGeneric<T extends Throwable> {
	private T obj;
	public void set(T obj) {
		this.obj = obj;
	}
	public void common() {
		System.out.println(obj + " common");
	}
}

// 定义了接口
interface PackageInfoInterface {
	void test();
}

// 包常量，包内访问，适用于分包开发
class PkgConst {
	static final String PACKAGE_CONST="ABC";
}