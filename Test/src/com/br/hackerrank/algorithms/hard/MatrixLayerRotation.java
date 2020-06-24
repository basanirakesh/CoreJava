package com.br.hackerrank.algorithms.hard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int originalRotations) {
        int rowSize = matrix.size();
        int columnSize = matrix.get(0).size();
        int layers = Math.min(rowSize, columnSize) / 2;
        List<Integer> tempList = null;


        for (int layer = 0; layer < layers; layer++) {
//            System.out.println("In layer " + layer);
            // Number of elements in perimeter of the layer
            int num = 2 * (rowSize + columnSize - 2 - (4 * layer));
//            System.out.println("Number of elements in perimeter " + num);
//            System.out.println("Actual rotations " + originalRotations);
            int r = originalRotations % num;
//            System.out.println("Resulting rotations " + r);
            if (r != 0) {
                tempList = new ArrayList<>(r);
                fillInitialTempList(matrix, r, layer, tempList, rowSize, columnSize);

                int currentRowNumber = layer;
                int currentColumnNumber = layer;
                int tracker = r - 1;

                do {
//                    System.out.println("Current row number and column number {" + currentRowNumber + "," + currentColumnNumber + "}");
                    int temp = matrix.get(currentRowNumber).get(currentColumnNumber);
                    matrix.get(currentRowNumber).set(currentColumnNumber, tempList.get(tracker));
                    tempList.set(tracker, temp);

                    tracker--;
                    if (tracker == -1) {
                        tracker = r - 1;
                    }

                    if (currentColumnNumber == layer && currentRowNumber != rowSize - layer - 1) {
                        currentRowNumber++;
                    } else if (currentRowNumber == rowSize - layer - 1 && currentColumnNumber != columnSize - layer - 1) {
                        currentColumnNumber++;
                    } else if (currentRowNumber == layer && currentColumnNumber != layer) {
                        currentColumnNumber--;
                    } else {
                        currentRowNumber--;
                    }
                } while (currentRowNumber != layer || currentColumnNumber != layer);
            }
        }
        printOutput(matrix, rowSize, columnSize);
    }

    private static void printOutput(List<List<Integer>> matrix, int rowSize, int columnSize) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void fillInitialTempList(List<List<Integer>> matrix, int r, int layer, List<Integer> tempList, int rowSize, int columnSize) {
//        System.out.println("Filling initial input for layer " + layer);
        int sourceRowNumber = layer;
        int sourceColumnNumber = layer;
        for (int i = 0; i < r; i++) {
            if (sourceRowNumber == layer && sourceColumnNumber != columnSize - layer - 1) {
                sourceColumnNumber++;
            } else if (sourceColumnNumber == columnSize - layer - 1 && sourceRowNumber != rowSize - layer - 1) {
                sourceRowNumber++;
            } else if (sourceColumnNumber == layer && sourceRowNumber != layer) {
                sourceRowNumber--;
            } else {
                sourceColumnNumber--;
            }
            tempList.add(matrix.get(sourceRowNumber).get(sourceColumnNumber));
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
