package com.br.hackerrank.algorithms.hard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MorganAndString {
    // Complete the morganAndString function below.
    static String morganAndString(String a, String b) {
        char[] jackArray = a.toCharArray();
        char[] danielArray = b.toCharArray();
        StringBuffer result = new StringBuffer();
        int jackLetterCount = jackArray.length;
        int danielLetterCount = danielArray.length;

        int jackArrayTracker = 0, danielArrayTracker = 0;
        do {
            if (jackArrayTracker != jackLetterCount && (danielArrayTracker == danielLetterCount || jackArray[jackArrayTracker] < danielArray[danielArrayTracker])) {
                result.append(jackArray[jackArrayTracker]);
                jackArrayTracker++;
            } else if (danielArrayTracker != danielLetterCount && (jackArrayTracker == jackLetterCount || danielArray[danielArrayTracker] < jackArray[jackArrayTracker])) {
                result.append(danielArray[danielArrayTracker]);
                danielArrayTracker++;
            } else {
                int tempJackArrayTracker = jackArrayTracker;
                int tempDanielArrayTracker = danielArrayTracker;
                result.append(jackArray[tempJackArrayTracker]);
                int subStringCount = 1;
                boolean subStringTracker = true;
                do {
                    tempJackArrayTracker++;
                    tempDanielArrayTracker++;
                    if (tempDanielArrayTracker == danielLetterCount || (tempJackArrayTracker != jackLetterCount && jackArray[tempJackArrayTracker] < danielArray[tempDanielArrayTracker])) {
                        jackArrayTracker = jackArrayTracker + subStringCount;
                        break;
                    } else if (tempJackArrayTracker == jackLetterCount || danielArray[tempDanielArrayTracker] < jackArray[tempJackArrayTracker]) {
                        danielArrayTracker = danielArrayTracker + subStringCount;
                        break;
                    } else if (jackArray[tempJackArrayTracker] == jackArray[tempJackArrayTracker - 1] && subStringTracker) {
                        subStringCount++;
                        result.append(jackArray[tempJackArrayTracker]);
                    } else if (jackArray[tempJackArrayTracker] != jackArray[tempJackArrayTracker - 1]) {
                        subStringTracker = false;
                    }
                } while (true);
            }
        } while (jackArrayTracker != jackLetterCount || danielArrayTracker != danielLetterCount);
        return result.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<List<String>> inputList = new ArrayList<>();
        for (int tItr = 0; tItr < t; tItr++) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            List input = new ArrayList<>();
            input.add(a);
            input.add(b);
            inputList.add(input);
        }
        scanner.close();

        for (List<String> input : inputList) {
            System.out.println(morganAndString(input.get(0), input.get(1)));
        }
    }
}
