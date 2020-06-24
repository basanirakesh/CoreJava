package com.br.hackerrank.algorithms.dp.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EqualChocolates {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		try {
			// Reading input and number of coins
			int noOfTestCases = scanner.nextInt();
			List<int[]> testCases = new ArrayList<>();

			// Reading inputs
			for (int i = 1; i <= noOfTestCases; i++) {
				int noOfColleagues = scanner.nextInt();
				int[] testCase = new int[noOfColleagues];
				for (int j = 0; j < noOfColleagues; j++) {
					testCase[j] = scanner.nextInt();
				}
				testCases.add(testCase);
			}

			// Applying logic
			for (int[] testCase : testCases) {
				System.out.println(calculateSteps(testCase));
			}

		} finally {
			scanner.close();
		}
	}

	private static int calculateSteps(int[] testCase) {
		int baseLine = findLeastElement(testCase);
		int result = 0;

		for (int j = 0; j < 3; j++) {
			int steps = 0;
			for (int i = 0; i < testCase.length; i++) {
				if (testCase[i] != baseLine) {
					steps = steps + (testCase[i] - baseLine) / 5;
					int remainder = (testCase[i] - baseLine) % 5;
					steps = steps + remainder / 2 + remainder % 2;
				}
			}
			if (j == 0 || steps < result)
				result = steps;
			if (--baseLine < 0)
				return result;
		}

		return result;
	}

	private static int findLeastElement(int[] array) {
		int result = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < result)
				result = array[i];
		}
		return result;
	}
}
