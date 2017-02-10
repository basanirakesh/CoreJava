package com.br.random;

import java.math.BigDecimal;

public class DoubleTest {
	public static void main(String[] args) {
		Double doubleValue = new Double("12");
		System.out.println(doubleValue);
		System.out.println(doubleValue.shortValue());
		System.out.println(doubleValue.byteValue());
		
		Double double1 = new Double("0.3");
		Double double2 = new Double("0.2");
		
		System.out.println("Double 0.3       = " + double1);
		System.out.println("Double 0.2       = " + double2);
		System.out.println("Double 0.3 - 0.2 = " + (double1 - double2));
		
		double pDouble1 = 0.3;
		double pDouble2 = 0.2;
		
		System.out.println("Primitive Double 0.3 - 0.2 = " + (pDouble1 - pDouble2));
		
		Float float1 = new Float(0.3);
		Float float2 = new Float(0.2);
		
		System.out.println("Float 0.3 - 0.2 = " + (float1 - float2));
		
		float pFloat1 = 0.3f;
		float pFloat2 = 0.2f;
		
		System.out.println("Primitive Float 0.3 - 0.2 = " + (pFloat1 - pFloat2));
		
		BigDecimal bidDecimal1 = new BigDecimal("0.3");
		BigDecimal bidDecimal2 = new BigDecimal("0.2");
		
		System.out.println("BigDecimal 0.3 - 0.2 = " + bidDecimal1.subtract(bidDecimal2));
	}
}
