package com.demo.systeminfo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

public class SystemInfo {
	public static void main(String[] args) {
		Map<String, String> map = System.getenv();
		System.out.println("用户名:    " + map.get("USERNAME"));
		System.out.println("计算机名:    " + map.get("COMPUTERNAME"));
		System.out.println("计算机域名:    " + map.get("USERDOMAIN"));

		try {
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println("本地主机名:    " + addr.getHostName());
			String ip = addr.getHostAddress();
			System.out.println("本地ip地址:    " + ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		Runtime r = Runtime.getRuntime();
		System.out.println("JVM可以使用的总内存:    " + r.totalMemory());
		System.out.println("JVM可以使用的剩余内存:    " + r.freeMemory());
		System.out.println("JVM可以使用的处理器个数:    " + r.availableProcessors());

		Properties props = System.getProperties();
		System.out.println("用户的账户名称：    " + props.getProperty("user.name"));
		System.out.println("用户的主目录：    " + props.getProperty("user.home"));
//		System.out.println("用户的当前工作目录：    " + props.getProperty("user.dir"));
		System.out.println("操作系统的名称：    " + props.getProperty("os.name"));
		System.out.println("操作系统的构架：    " + props.getProperty("os.arch"));
		System.out.println("操作系统的版本：    " + props.getProperty("os.version"));
		System.out.println("文件分隔符：    " + props.getProperty("file.separator"));
		System.out.println("路径分隔符：    " + props.getProperty("path.separator"));
		String lineSeparator = props.getProperty("line.separator");
		switch (lineSeparator) {
		case "\r\n":
			System.out.println("Windows 行分隔符：   \\r\\n");
			break;
		case "\r":
			System.out.println("Mac 行分隔符：    \\r");
			break;
		case "\n":
			System.out.println("Unix/Linux 行分隔符：    \\n");
			break;
		default:
			System.out.println("other 行分隔符：    //n");
			break;
		}
		
		System.out.println("Java的运行环境版本：    " + props.getProperty("java.version"));
		System.out.println("Java的运行环境供应商：    " + props.getProperty("java.vendor"));
		System.out.println("Java供应商的URL：    " + props.getProperty("java.vendor.url"));
		// System.out.println("Java的安装路径： " + props.getProperty("java.home"));
		System.out.println("Java的虚拟机规范版本：    " + props.getProperty("java.vm.specification.version"));
		System.out.println("Java的虚拟机规范供应商：    " + props.getProperty("java.vm.specification.vendor"));
		System.out.println("Java的虚拟机规范名称：    " + props.getProperty("java.vm.specification.name"));
		System.out.println("Java的虚拟机实现版本：    " + props.getProperty("java.vm.version"));
		System.out.println("Java的虚拟机实现供应商：    " + props.getProperty("java.vm.vendor"));
		System.out.println("Java的虚拟机实现名称：    " + props.getProperty("java.vm.name"));
		System.out.println("Java运行时环境规范版本：    " + props.getProperty("java.specification.version"));
		// System.out.println("Java运行时环境规范供应商： " +
		// props.getProperty("java.specification.vender"));
		System.out.println("Java运行时环境规范名称：    " + props.getProperty("java.specification.name"));
		System.out.println("Java的类格式版本号：    " + props.getProperty("java.class.version"));
		// System.out.println("Java的类路径： " + props.getProperty("java.class.path"));
		// System.out.println("加载库时搜索的路径列表： " + props.getProperty("java.library.path"));
		// System.out.println("默认的临时文件路径： " + props.getProperty("java.io.tmpdir"));
		// System.out.println("要使用的 JIT 编译器的名称 ： " +
		// props.getProperty("java.compiler"));
		// System.out.println("一个或多个扩展目录的路径： " + props.getProperty("java.ext.dirs"));
	}
}
