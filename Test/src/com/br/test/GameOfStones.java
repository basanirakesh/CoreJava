package com.br.test;

import java.util.Scanner;

public class GameOfStones {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			int numberOfInputs = scanner.nextInt();
			Integer[] inputs = new Integer[numberOfInputs];
			for (int i = 0; i < numberOfInputs; i++) {
				inputs[i] = scanner.nextInt();
			}

			for (int i = 0; i < inputs.length; i++) {
				int remainder = inputs[i] % 7;
				if (remainder == 0 || remainder == 1) {
					System.out.println("Second");
				} else {
					System.out.println("First");
				}
			}
		} finally {
			scanner.close();
		}
	}
}
