package com.br.random;

public class LongTest {
	public static void main(String[] args) {
		Long a = 2L;
		Long b = 1L + a;
		Long c = 1L + 2L;
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(b == c);
	}
}
