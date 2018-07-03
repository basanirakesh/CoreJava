package com.br.random;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashSet;
import java.util.Set;

public class ZemosoTask1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 4, 1, 1, 3, 3, 4, 4, 5, 5}));
    }

    public static int solution(int[] A) {
        int inputArraySize = A.length;
        // Default shortest vacation to input array size
        int shortestVacation = inputArraySize;
        // Fetching number of distinct vacations
        int distinctVacationsSize = getNumberOfDistinctVacations(A);
        // Creating a set and counter for calculation purpose
        Set<Integer> tempDistinctVacations = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < inputArraySize - distinctVacationsSize + 1; i++) {
            // Resetting the counter and temp set every time for recalculation
            counter = 0;
            tempDistinctVacations.clear();
            for (int j = i; j < inputArraySize; j++) {
                tempDistinctVacations.add(A[j]);
                counter++;
                // Once all distinct vacations are found consecutively
                if (tempDistinctVacations.size() == distinctVacationsSize) {
                    // Resetting shortestVacation if consecutive days are less than previous calculation
                    if (counter < shortestVacation) {
                        shortestVacation = counter;
                    }
                    // Exiting inner loop and continuing with next calculation
                    break;
                }
            }
        }
        return shortestVacation;
    }

    /**
     * calculating distinct vacations
     *
     * @param array
     * @return
     */
    public static int getNumberOfDistinctVacations(int[] array) {
        Set<Integer> distinctVacations = new HashSet<>();
        for (int i : array) {
            distinctVacations.add(i);
        }
        return distinctVacations.size();
    }
}