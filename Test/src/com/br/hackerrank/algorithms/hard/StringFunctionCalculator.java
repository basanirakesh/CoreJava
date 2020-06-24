package com.br.hackerrank.algorithms.hard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class StringFunctionCalculator {
    // Complete the maxValue function below.
    static int maxValue(String t) {
        int result = t.length();
        int tempResult = 1;
        char[] characters = t.toCharArray();
        List<Integer> indexList = new ArrayList<>();
//        List<Integer> tempIndexList = null;

        int i = 0;
        while (i < characters.length - 1) {
            System.out.println("String length " + characters.length);
            System.out.println(" character " + i);
            int multiplier = 1;
            do {
                int stringCount = 1;
                if (indexList.isEmpty()) {
                    for (int j = i + 1; j < characters.length; j++) {
                        if (characters[i] == characters[j]) {
                            stringCount++;
                            indexList.add(j);
                        }
                    }
                } else {
                    multiplier++;
                    ListIterator<Integer> it = indexList.listIterator();
                    while (it.hasNext()) {
                        int index = it.next();
                        if (index + multiplier <= characters.length) {
                            boolean condition = false;
                            for (int k = 0; k < multiplier; k++) {
                                if (characters[index + k] != characters[i + k]) {
                                    condition = true;
                                    break;
                                }
                            }
                            if (condition == false)
                                stringCount++;
                            else
                                it.remove();
                        } else {
                            it.remove();
                        }
                    }
                }
                tempResult = stringCount * multiplier;
                if (tempResult > result) {
                    result = tempResult;
                }
                System.out.println("string count " + stringCount);
                System.out.println("Multiplier " + multiplier);
                System.out.println("Index list size " + indexList.size());
            } while (indexList.isEmpty() == false);
            i = i + multiplier;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String t = scanner.nextLine();
        int result = maxValue(t);
        System.out.println(result);
        scanner.close();
    }
}
