package com.br.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal payment = new BigDecimal(2.00);
		BigDecimal cost = new BigDecimal(1.10);
		System.out.println("Change received ::" + new DecimalFormat("#.##").format(payment.subtract(cost)));
		int i =4;
		System.out.println(String.format("%4d", i));
		List<Integer> li = new ArrayList<Integer>();
		li.add(1);
	}
	
}
