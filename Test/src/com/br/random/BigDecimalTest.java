package com.br.random;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalTest {
    public static void main(String[] args) {
        test3();
    }

    public static void test3() {
        BigDecimal b1 = new BigDecimal(99999999.99);
        System.out.println(b1.toString());
    }

    public static void test2() {
        Double d = new Double("0");
        System.out.println("test - " + BigDecimal.valueOf(0).equals(d));
    }

    public static void test1() {
        BigDecimal payment = new BigDecimal(2.00);
        BigDecimal cost = new BigDecimal(1.10);
        System.out.println("Change received ::" + new DecimalFormat("#.##").format(payment.subtract(cost)));
        int i = 4;
        System.out.println(String.format("%4d", i));
        List<Integer> li = new ArrayList<Integer>();
        li.add(1);

        BigDecimal test1 = new BigDecimal("100000");
        BigDecimal test2 = test1;
//		test1 = test1.subtract(new BigDecimal("100"));

        System.out.println("test1 - " + test1 + ", test2 - " + test2 + ",test1==test2" + (test1 == test2));
    }

}
