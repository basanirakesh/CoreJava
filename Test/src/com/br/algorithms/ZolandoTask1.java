package com.br.algorithms;

public class ZolandoTask1 {
    public static void main(String[] args) {
        int[] temperatues = new int[] {-1,-15,18,-19,-20,1,-7,4};
        System.out.println(solution(temperatues));
    }

    public static String solution(int[] T) {
        // write your code in Java SE 8
        int numberOfTemps = T.length / 4;
        int startIndex = 0;
        int endIndex = numberOfTemps - 1;
        int highestAmplitude = 0;
        Season resultSeason = Season.WINTER;
        for (Season season : Season.values()) {
            int amplitude = calculateAmplitude(T, startIndex, endIndex);
            if (amplitude > highestAmplitude) {
                highestAmplitude = amplitude;
                resultSeason = season;
            }
            startIndex = startIndex + numberOfTemps;
            endIndex = endIndex + numberOfTemps;
        }
        return resultSeason.toString();
    }

    public enum Season {
        WINTER,
        SPRING,
        SUMMER,
        AUTUMN
    }

    public static int calculateAmplitude(int[] t, int startIndex, int endIndex) {
        int leastTemp = 1000;
        int highestTemp = -1000;
        for (int i = startIndex; i <= endIndex; i++) {
            if (t[i] < leastTemp) {
                leastTemp = t[i];
            } else if (t[i] > highestTemp) {
                highestTemp = t[i];
            }
        }
        return highestTemp - leastTemp;
    }
}
