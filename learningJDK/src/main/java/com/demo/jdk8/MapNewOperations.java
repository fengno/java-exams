package com.demo.jdk8;

import java.util.HashMap;
import java.util.Map;

public class MapNewOperations {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i=0; i<10 ; i++) {
			String result = map.putIfAbsent(i, "val" + i);
			System.out.println("result" + i + ": " + result);
		}
		map.forEach((id, val) -> System.out.println(val));
		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println(map.get(3)); // val33
		
		map.computeIfPresent(9, (num, val) -> null); // key为9的记录被删除
		System.out.println(map.containsKey(9));    // false
		
		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));    // true

		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3)); // val33
		
		// 根据一个键key从map中删除，但是要被删除元素其值必须符合指定的值
		map.remove(3, "val3");
		System.out.println(map.get(3));   // val33

		map.remove(3, "val33");
		System.out.println(map.get(3));   // null
		
		System.out.println(map.getOrDefault(42, "key not found")); // key not found
		System.out.println("----------------------");
		
		// Merge定义，如果对应指定key的元素不存在，那么就插入这对键值key/value到map, 如果已经存在，那么就改变修改旧值为新的。
		System.out.println(map.get(9));            // val9
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));            // val9
		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));             // val9concat
		System.out.println(map.get(8));            // val8
		map.merge(8, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(8));             // val8concat

	}

}
