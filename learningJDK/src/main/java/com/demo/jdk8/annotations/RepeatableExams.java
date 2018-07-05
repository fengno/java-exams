package com.demo.jdk8.annotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class RepeatableExams {

	public static void main(String[] args) {
		RepeatedAnnotations repeatedAnnotationObj = new RepeatedAnnotations();
		OldAnnotationWay oldAnnotationObj = new OldAnnotationWay();
		Annotation[] annotations = repeatedAnnotationObj.getClass().getAnnotations();
		System.out.println(annotations.length);
		Arrays.stream(annotations).forEach(System.out::println);
		annotations = oldAnnotationObj.getClass().getAnnotations();
		System.out.println(annotations.length);
		Arrays.stream(annotations).forEach(System.out::println);
		Hint hint = repeatedAnnotationObj.getClass().getAnnotation(Hint.class);
		System.out.println(hint);
		hint = oldAnnotationObj.getClass().getAnnotation(Hint.class);
		System.out.println(hint);
		Hints hints1 = repeatedAnnotationObj.getClass().getAnnotation(Hints.class);
		System.out.println(hints1.value().length);  // 2
		hints1 = oldAnnotationObj.getClass().getAnnotation(Hints.class);
		System.out.println(hints1.value().length);  // 2
		Hint[] hints2 = repeatedAnnotationObj.getClass().getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);          // 2
		hints2 = oldAnnotationObj.getClass().getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);          // 2
	}

}
