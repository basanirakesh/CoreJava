package com.br.hackerrank.algorithms.hard;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StringFunctionCalculatorCopied {

    static int Area(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.length - 1) {

            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {

                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek();
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek();
            max = Math.max(h * w, max);
        }

        return max;
    }


    static class suffi implements Comparable<suffi> {
        int first;
        int second;
        int original;

        public int compareTo(suffi s1) {

            if (this.first == s1.first) {
                return this.second - s1.second;
            } else {
                return this.first - s1.first;
            }


        }

    }


    public static void main(String[] args) {
        // long t1=System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //  String save=s;
        int len = s.length();
        //s=s+s;
        //int len=s.length();
        int l[][] = new int[20][len];
        suffi suf[] = new suffi[len];
        for (int i = 0; i < len; i++) {
            suf[i] = new suffi();
            l[0][i] = (int) s.charAt(i) - 97;
        }

        for (int cnt = 1, stp = 1; cnt < len; cnt = cnt * 2, stp++) {

            for (int i = 0; i < len; ++i) {
                suf[i].first = l[stp - 1][i];
                suf[i].second = i + cnt < len ? l[stp - 1][i + cnt] : -1;
                suf[i].original = i;
            }
            Arrays.sort(suf);
            l[stp][suf[0].original] = 0;

            for (int i = 1, currRank = 0; i < len; ++i) {


                if (suf[i - 1].first != suf[i].first || suf[i - 1].second != suf[i].second)
                    ++currRank;

                l[stp][suf[i].original] = currRank;
            }


        }

        int lcp[] = new int[len];
        int rank[] = new int[len];

        for (int j = 0; j < len; j++) {
            rank[suf[j].original] = j;
        }
        int k = 0;
        for (int g = 0; g < len; g++) {
            if (rank[g] == len - 1) {
                k = 0;
                continue;
            }
            int j = suf[rank[g] + 1].original;
            while (g + k < len && j + k < len && s.charAt(g + k) == s.charAt(j + k)) {
                k++;
            }
            lcp[rank[g]] = k;
            if (k == 0) {
                k = 0;
            } else {
                k--;
            }
        }
//suf lcp
        lcp[len - 1] = len;

        int area = Area(lcp);
        if (area > len) {
            System.out.println(area);
        } else {
            System.out.println(len);
        }

        //long t2=System.currentTimeMillis();
        //System.out.println(t2-t1);
    }
}