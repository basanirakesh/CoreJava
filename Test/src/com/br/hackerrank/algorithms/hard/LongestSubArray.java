package com.br.hackerrank.algorithms.hard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    public static int longestSubarray(List<Integer> arr) {
        int result = 1;
        int[] tempResult = new int[arr.size()];
        int tracker = 0;
        int resultTracker = 0;
        Set<Integer> distinctNumbers = new HashSet<>();
        distinctNumbers.add(arr.get(tracker));
        while (tracker != arr.size() - 1) {
            distinctNumbers.add(arr.get(tracker + 1));
            if (Math.abs(arr.get(tracker) - arr.get(tracker + 1)) > 1 || distinctNumbers.size() > 2) {
                if (distinctNumbers.size() > 2) {
                    tempResult[resultTracker] = result;
                    resultTracker++;
                }
                result = 1;
                distinctNumbers.clear();
                distinctNumbers.add(arr.get(tracker + 1));
            } else {
                result++;
            }
            tracker++;
        }


        int i = 0;
        while (i < tempResult.length) {
            if (tempResult[i] > result) {
                result = tempResult[i];
            }
            i++;
        }
        return result;
    }
}

public class LongestSubArray {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int arrCount = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = scanner.nextInt();
            arr.add(arrItem);
        }

        int result = Result.longestSubarray(arr);
        System.out.println(result);
    }
}