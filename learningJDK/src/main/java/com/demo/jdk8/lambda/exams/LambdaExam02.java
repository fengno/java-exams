package com.demo.jdk8.lambda.exams;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 实现事件处理：使用Lambda表达式替代丑陋的匿名类
 */
public class LambdaExam02 {

	public static void main(String[] args) {

		// Before Java 8:
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("without lambda expression is boring");
			}
		});

		// Java 8 way:
		show.addActionListener((e) -> {
			System.out.println("Action !! Lambda expressions Rocks");
		});
	}
}
