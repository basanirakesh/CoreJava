package com.br.algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pramathi1 {


    // Complete the whichSweetShouldIBring function below.
    static int maximalDifference(List<Integer> a) {
        int result = -1 ;
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if ((a.get(i) < a.get(j)) && ((a.get(j) - a.get(i)) > result)) {
                    result = a.get(j) - a.get(i);
                }
            }
        }
        return  result;
    }

    public static void main(String[] args) throws IOException {
    }
}