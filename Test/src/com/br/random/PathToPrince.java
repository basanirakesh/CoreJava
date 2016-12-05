package com.br.random;

import java.util.Scanner;

public class PathToPrince {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Character[][] input = new Character[n][n];
		for (int i = 0; i < n; i++) {
			String line = scanner.next();
			for (int j = 0; j < n; j++) {
				input[i][j] = line.charAt(j);
			}
		}
		displayPathtoPrincess(n, input);
	}

	public static void displayPathtoPrincess(int n, Character[][] input) {
		Integer row = 0;
		Integer column = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] == 'p') {
					row = i;
					column = j;
					break;
				}
			}
			if (row > 0 || column > 0)
				break;
		}
		for (int i = 0; i < n / 2; i++) {
			if(row == 0)
				System.out.println("UP");
			else 
				System.out.println("DOWN");
			if(column ==0)
				System.out.println("LEFT");
			else
				System.out.println("RIGHT");
		}
	}
}