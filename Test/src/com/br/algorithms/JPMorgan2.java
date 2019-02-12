package com.br.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class JPMorgan2 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        Map<Character, String> map = new HashMap<>();
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
//        while ((line = in.readLine()) != null) {
            StringBuilder result = new StringBuilder();
            buildResult("234", 0, 0, map, "", result);
            System.out.print(result);
//        }
    }

    public static String buildResult(String telephoneNumber, int telIndex, int strIndex, Map<Character, String> map, String singleString, StringBuilder result) {
        char digit = telephoneNumber.charAt(telIndex);
        String str = map.get(digit);
        singleString = singleString + str.charAt(strIndex);
        if (singleString.length() < telephoneNumber.length()) {
            String tempResult = buildResult(telephoneNumber, telIndex + 1, strIndex, map, singleString, result);
            if (tempResult != null) {
                result.append(tempResult).append(",");
            }

            if (map.get(telephoneNumber.charAt(telIndex + 1)).length() > strIndex) {
                tempResult = buildResult(telephoneNumber, telIndex + 1, strIndex + 1, map, singleString, result);
                if (tempResult != null) {
                    result.append(tempResult).append(",");
                }
            }
        } else {
            return singleString;
        }
        return null;
    }
}