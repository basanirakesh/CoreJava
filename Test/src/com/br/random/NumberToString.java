package com.br.random;

public class NumberToString {
    public static void main(String[] args) {
        int number = 0;
        System.out.println(numberToOrdinal(number));
    }

    public static String numberToOrdinal(Integer number) {
        // Capturing last 2 digits and last digit separately
        int lastTwoDigits = number % 100;
        int lastOneDigit = number % 10;
        String ordinal = "";

        // Handling corners cases at the beginning.
        // Case 1 - If number is 0
        if (number == 0) {
            // Return "0" to avoid further execution of the program.
            return "0";
        }
        // Case 2 - Special ordinal though they are ending with 1/2/3
        if (lastTwoDigits == 11 || lastTwoDigits == 12 || lastTwoDigits == 13) {
            ordinal = "th";
        } else if (lastOneDigit == 1) {
            ordinal = "st";
        } else if (lastOneDigit == 2) {
            ordinal = "nd";
        } else if (lastOneDigit == 3) {
            ordinal = "rd";
        } else {
            ordinal = "th";
        }
        return Integer.toString(number) + ordinal;
    }
}
