package com.br.test;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal payment = new BigDecimal(2.00);
		BigDecimal cost = new BigDecimal(1.10);
		System.out.println("Change received ::" + payment.subtract(cost));
	}
}
