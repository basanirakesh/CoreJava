package com.br.random;

import java.util.HashSet;
import java.util.Set;

public class HashSetGeneric {

    public static void main(String[] args) {
        Set s = new HashSet<String>();
        s.add(new Student());
        s.add("Random string");

        HashSet h = new HashSet();
        h.add("rakesh");
        h.add(1);


        System.out.println(s);
    }

    static class Student {
        int i = 1;

        public String toString(){
            return "Student number - " + i;
        }
    }
}
