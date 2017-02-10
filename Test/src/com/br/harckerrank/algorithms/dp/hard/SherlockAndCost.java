package com.br.harckerrank.algorithms.dp.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SherlockAndCost {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		try {
			// Reading input and number of coins
			int noOfTestCases = scanner.nextInt();
			List<int[]> testCases = new ArrayList<>();

			// Reading inputs
			for (int i = 1; i <= noOfTestCases; i++) {
				int noOfElements = scanner.nextInt();
				int[] testCase = new int[noOfElements];
				for (int j = 0; j < noOfElements; j++) {
					testCase[j] = scanner.nextInt();
				}
				testCases.add(testCase);
			}

			// Applying logic
			for (int[] testCase : testCases) {
				if (testCase.length == 1) {
					System.out.println("0");
					continue;
				} else if (testCase.length == 2) {
					System.out.println(Math.abs(testCase[0] - testCase[1]));
					continue;
				}
				createResultArray(testCase);
				System.out.println(calculateSum(testCase));
			}

		} finally {
			scanner.close();
		}
	}

	private static void createResultArray(int[] testCase) {
		int[] sortedIndicesInDesc = IntStream.range(0, testCase.length).boxed()
				.sorted((i, j) -> testCase[j] - testCase[i]).mapToInt(ele -> ele).toArray();
		for (int i = 0; i < sortedIndicesInDesc.length; i++) {
			int index = sortedIndicesInDesc[i];
			
			if (testCase[index] == 1)
				continue;
			
			int temp1 = testCase[index];
			testCase[index] = 1;
			int result1 = getModulo(testCase, index - 2, index + 2);
			testCase[index] = temp1;

			int temp2 = 0;
			if (index != 0) {
				temp1 = testCase[index - 1];
				testCase[index - 1] = 1;
			}
			if (index != testCase.length - 1) {
				temp2 = testCase[index + 1];
				testCase[index + 1] = 1;
			}
			int result2 = getModulo(testCase, index - 2, index + 2);

			if (result1 - result2 > 0) {
				testCase[index] = 1;
				if (index != 0) {
					testCase[index - 1] = temp1;
				}
				if (index != testCase.length - 1) {
					testCase[index + 1] = temp2;
				}
			}
		}
	}

	private static int getModulo(int[] subArray, int startIndex, int endIndex) {
		int result = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			if (i <= 0 || i >= subArray.length)
				continue;
			result = result + Math.abs(subArray[i] - subArray[i - 1]);
			if (i == endIndex)
				break;

		}
		return result;
	}

	private static int calculateSum(int[] resultArray) {
		int result = 0;
		for (int i = 1; i < resultArray.length; i++) {
			result = result + Math.abs(resultArray[i] - resultArray[i - 1]);
		}
		return result;
	}
}
