package com.br.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JPMorgan1 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line = "fsdfa :(fas(:)";
        line = line.replaceAll("[a-zA-Z: ]*([a-zA-Z ])[a-zA-Z: ]", "");
        System.out.println(line);
        line = line.replace(":))",")");
        System.out.println(line);
        line = line.replace("(:)","");
        System.out.println(line);
        line = line.replace(":)","");
        System.out.println(line);
        line = line.replace(":(", "");
        System.out.println(line);
        line = line.replace(":", "");
        System.out.println(line);
        line = line.replace("()","");
        System.out.println(line);
        if(line.length() == 0) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
//        while ((line = in.readLine()) != null) {
//        }
    }
}