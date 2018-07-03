package com.demo.jdk8.lambda.exams;

/** 
 * 实现Runnable线程：使用() -> {} 替代匿名类
 */
public class LambdaExam01 {

	public static void main(String[] args) {
		// Before Java8
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Before Java8");
			}
		}).start();
		
		// Java 8 way
		new Thread(() -> System.out.println("In Java8!")).start();
	}
}
