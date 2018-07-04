package com.demo.jdk8.stream.exams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamExams {
	public static List<Integer> buildIntRange() {
		List<Integer> numbers = new ArrayList<>(5);
		for (int i = 0; i < 600; i++) {
			numbers.add(i);
		}
		return Collections.unmodifiableList(numbers);
	}

	public static void main(String[] args) {
		List<Integer> source = buildIntRange();

		// 传统方式的遍历
		long start = System.currentTimeMillis();
		long t0 = System.nanoTime();
		for (int i = 0; i < source.size(); i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("传统方式 : " + (System.currentTimeMillis() - start) + "ms");
		long t1 = System.nanoTime();
		System.out.println("传统方式 : " + (TimeUnit.NANOSECONDS.toMillis(t1 - t0)) + "ms");

		// 单管道stream
		start = System.currentTimeMillis();
		t0 = System.nanoTime();
		source.stream().forEach(r -> {
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		System.out.println("stream : " + (System.currentTimeMillis() - start) + "ms");
		t1 = System.nanoTime();
		System.out.println("stream : " + (TimeUnit.NANOSECONDS.toMillis(t1 - t0)) + "ms");

		// 多管道parallelStream
		start = System.currentTimeMillis();
		t0 = System.nanoTime();
		source.parallelStream().forEach(r -> {
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		System.out.println("parallelStream : " + (System.currentTimeMillis() - start) + "ms");
		t1 = System.nanoTime();
		System.out.println("parallelStream : " + (TimeUnit.NANOSECONDS.toMillis(t1 - t0)) + "ms");

	}

	public static void main1(String[] args) {
		//TODO 顺序比并行高效？不解
		int max = 1000000;
		List<String> values = new ArrayList<>(max);

		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		sequenceCount(values);

		parallelCount(values);
	}

	// 顺序排序
	private static void sequenceCount(List<String> values) {
		long t0 = System.nanoTime();

		long count = values.stream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("顺序排序花了: %d ms", millis));
	}

	// 并行排序
	private static void parallelCount(List<String> values) {

		long t0 = System.nanoTime();

		long count = values.parallelStream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("并行排序花了: %d ms", millis));
	}

}
