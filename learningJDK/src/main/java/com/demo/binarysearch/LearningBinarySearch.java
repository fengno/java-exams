package com.demo.binarysearch;

import java.util.Comparator;

/**
 * 参照JDK源码
 */
public class LearningBinarySearch {

	public static void main(String[] args) {
		
	}

	/**
	 * Checks that {@code fromIndex} and {@code toIndex} are in the range and throws
	 * an exception if they aren't.
	 */
	private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
		}
		if (fromIndex < 0) {
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		}
		if (toIndex > arrayLength) {
			throw new ArrayIndexOutOfBoundsException(toIndex);
		}
	}

	public static int binarySearch0(Object[] a, int fromIndex, int toIndex, Object key) {
		if (a == null) {
			throw new NullPointerException("the specific array is null");
		}
		rangeCheck(a.length, fromIndex, toIndex);
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			@SuppressWarnings("rawtypes")
			Comparable midVal = (Comparable) a[mid];
			@SuppressWarnings("unchecked")
			int cmp = midVal.compareTo(key);

			if (cmp < 0)
				low = mid + 1;
			else if (cmp > 0)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	public static int binarySearch0(short[] a, int fromIndex, int toIndex, short key) {
		if (a == null) {
			throw new NullPointerException("the specific array is null");
		}
		rangeCheck(a.length, fromIndex, toIndex);
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			short midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	public static <T> int binarySearch0(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
		if (a == null) {
			throw new NullPointerException("the specific array is null");
		}
		rangeCheck(a.length, fromIndex, toIndex);
		if (c == null) {
			return binarySearch0(a, fromIndex, toIndex, key);
		}
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			T midVal = a[mid];
			int cmp = c.compare(midVal, key);
			if (cmp < 0)
				low = mid + 1;
			else if (cmp > 0)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}
}
