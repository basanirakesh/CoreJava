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
		String string12 = new String();
		String string13 = null;
		String string14 = "rakesh";
		StringBuilder stringBuilder1 = new StringBuilder();

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
		System.out.println("----------------------");

		passString(string12);
		System.out.println(string12);
		System.out.println("----------------------");

		passString(string13);
		System.out.println(string13);
		System.out.println("----------------------");

		passString(stringBuilder1);
		System.out.println(stringBuilder1.toString());
		
		compareAndPrint(string14);
	}

	private static void passString(String string) {
		fillString(string);
	}

	private static void fillString(String string) {
		string = "rakesh";
	}

	private static void passString(StringBuilder string) {
		fillString(string);
	}

	private static void fillString(StringBuilder string) {
		string.append("rakesh");
	}

	private static void compareAndPrint(String string) {
		String testString = "rakesh";
		System.out.println("-----------compareAndPrint-----------");
		System.out.println(string == testString);
	}
}
