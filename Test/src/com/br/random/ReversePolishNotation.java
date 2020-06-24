package com.br.random;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String input = "";
        System.out.println(evaluate(input));
    }

    public static double evaluate(String expr) {
        double output = 0;
        if(expr.length() == 0) {
            return  output;
        }
        // Splitting input into array of elements
        String[] elements = expr.split(" ");
        // NOTE - Do not change operators order in below string.
        // We will be using in switch condition below
        String operators = "+-*/";
        Stack<Double> stack = new Stack<Double>();
        for (String e : elements) {
            // Pushing numbers to stack
            if (!operators.contains(e)) {
                stack.push(Double.valueOf(e));
            }
            else {
                // Popping top 2 numbers form stack when an operation is reached
                double a = stack.pop();
                double b = stack.pop();
                // Capturing index of the operator in operators string "+-*/"
                int index = operators.indexOf(e);
                switch (index) {
                    case 0:
                        stack.push(a + b);
                        break;
                    case 1:
                        stack.push(b - a);
                        break;
                    case 2:
                        stack.push(a * b);
                        break;
                    case 3:
                        stack.push(b / a);
                        break;
                }
            }
        }

        output = Double.valueOf(stack.pop());
        return output;
    }
}
