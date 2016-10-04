package com.br.test;

public class StringTest {
	public static void main(String[] args) {
		String string1 = "123";
		String string2 = string1;
		String string3 = new String("123");
		String string6 = "123" + "";
		String string7 = "";
		String string8 = string1 + string7;
		String string9 = new String("123");
		String string10 = string1 + "";
		String string11 = (string1 + string7).intern();
		
		System.out.println(string1 == string2);
		System.out.println("----------------------");
		System.out.println(string1 == string3);
		System.out.println("----------------------");
		System.out.println(string1 == string6);
		System.out.println("----------------------");
		System.out.println(string1 == string8);
		System.out.println("----------------------");
		System.out.println(string1 == string11);
		System.out.println("----------------------");
		System.out.println(string3 == string9);
		System.out.println("----------------------");
		System.out.println(string1 == string10);
	}
}
