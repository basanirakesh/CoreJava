package com.br.random;

import java.util.stream.IntStream;

public class Java8StreamAPI {
	public static void main(String[] args) {
		final int[] intArray = { 4, 2, 1, 5, 1, 6 };
		int[] sortedIndices = IntStream.range(0, intArray.length).boxed().sorted((i, j) -> intArray[j] - intArray[i])
				.mapToInt(ele -> ele).toArray();
		System.out.println("hi");
	}
}
