package com.br.random;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class ZemosoTask2 {

    public static void main(String[] args) {
        System.out.println(solution("7  n     =666"));
    }

    public static String solution(String S) {
        StringBuilder result = new StringBuilder();
        // Removing all characters except numbers
        String plainPhoneNumber = S.replaceAll("[^0-9]", "");
        int length = plainPhoneNumber.length();
        // Special handling scenarios to avoid ending up in single digit at the end
        if (length == 4) {
            return splitByHyphen(plainPhoneNumber, 2);
        } else if (length > 4 && length %3 == 1) {
            String lastFourNumbers = plainPhoneNumber.substring(length - 4);
            String remainingNumbers = plainPhoneNumber.substring(0, length - 4);
            return splitByHyphen(remainingNumbers, 3) + "-" + splitByHyphen(lastFourNumbers, 2);
        } else {
            return splitByHyphen(plainPhoneNumber, 3);
        }
    }

    /**
     * Method to sprint the given string by hyphen based on size
     *
     * @param str
     * @param size
     * @return
     */
    public static String splitByHyphen(String str, int size) {
        int length = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i += size) {
            // Condition to avoid adding hyphen at the beginning
            if (result.length() > 0) {
                result.append("-");
            }
            // Using Math min to avoid StringIndexOutOfBoundsException and to get remaining numbers
            result.append(str.substring(i, Math.min(length, i + size)));
        }
        return result.toString();
    }
}