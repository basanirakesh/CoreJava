package com.br.hackerrank.algorithms.dp.hard;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeProblem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			// reading input and number of coins
			int input = scanner.nextInt();
			int numberOfCoins = scanner.nextInt();

			// validating and return
			if (numberOfCoins == 0 || input == 0) {
				System.out.println("0");
				return;
			}

			// reading coins
			int i = 0;
			int[] coins = new int[numberOfCoins];
			coins[i] = scanner.nextInt();
			while (i < numberOfCoins - 1) {
				coins[++i] = scanner.nextInt();
			}

			// sorting
			// sort(coins);

			// applying logic
			System.out.println(countWays(coins, numberOfCoins, input));
		} finally {
			scanner.close();
		}
	}

	private static long countWays(int s[], int m, int n) {
		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < m; i++)
			for (int j = s[i]; j <= n; j++) {
				table[j] += table[j - s[i]];
				//printTable(table);
			}

		return table[n];
	}
}
