package com.br.algorithms;

public class ZolandoTask2 {

    public static void main(String[] args) {
        System.out.println(solution(3, 3));
    }

    public static String solution(int A, int B) {
        // write your code in Java SE 8
        String primaryString = "";
        String secondaryString = "";
        StringBuilder result = new StringBuilder();
        int primaryNumber = 0;
        int secondaryNumber = 0;
        if (A > B) {
            primaryString = "aa";
            secondaryString = "bb";
            primaryNumber = A;
            secondaryNumber = B;
        } else {
            primaryString = "bb";
            secondaryString = "aa";
            primaryNumber = B;
            secondaryNumber = A;
        }

        int primaryStringDivisions = (primaryNumber / 2) + (primaryNumber % 2);
        int secondaryStringDivisions = primaryStringDivisions - 1;
        if (primaryNumber == secondaryNumber || (secondaryNumber % 2 == 1 && primaryNumber - secondaryNumber == 1)) {
            secondaryStringDivisions = primaryStringDivisions;
        }
        int secondaryStringRepetitions = secondaryNumber - secondaryStringDivisions;

        boolean isPrimaryNumberOdd = primaryNumber % 2 == 1;
        for (int i = 1; i <= primaryStringDivisions; i++) {
            // Adding primary string part
            if (i == primaryStringDivisions && isPrimaryNumberOdd) {
               result.append(getSingleLetterString(primaryString));
            } else {
                result.append(primaryString);
            }

            // Adding secondary string part
            if (i <= secondaryStringDivisions) {
                if (secondaryStringRepetitions != 0) {
                    result.append(secondaryString);
                    secondaryStringRepetitions--;
                } else {
                    result.append(getSingleLetterString(secondaryString));
                }
            }
        }
        return result.toString();
    }

    public static String getSingleLetterString(String string) {
        if (string.equals("aa")) {
            return "a";
        } else {
            return "b";
        }
    }
}
