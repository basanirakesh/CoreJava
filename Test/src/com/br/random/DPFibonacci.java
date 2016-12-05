package com.br.random;

import java.util.HashMap;
import java.util.Map;

public class DPFibonacci {
	private static int count = 0;
	private static Map<Long, Long> set = new HashMap<>();

	public static void main(String[] args) {
		System.out.println("-------------" + fibonacci(92) + "-------------");
	}

	public static long fibonacci(long n) {
		System.out.println(++count + " - " + n);
		Long result = null;
		if (set.get(n) == null) {
			result = (n < 3) ? 1 : fibonacci(n - 2) + fibonacci(n - 1);
			set.put(n, result);
		} else {
			result = set.get(n);
		}
		return result;
	}
}
