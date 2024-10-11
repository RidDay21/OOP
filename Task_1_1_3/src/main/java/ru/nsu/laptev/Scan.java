package ru.nsu.laptev;

import java.util.Scanner;

public class Scan {

    public static Expression parseExpression(String input) {

        input = input.trim().replaceAll("\\s+"," ");
        if (input.startsWith("(")) {
            int closingBracketIndex = findMatchingBracket(input);
            String operation = input.substring(1, closingBracketIndex);
            String[] operands = operation.split(" "); // Предполагаем, что оператор разделяет операнды
            return createExpression(operands[0], parseExpression(input.substring(closingBracketIndex + 1)), parseExpression(input.substring(closingBracketIndex + 1)));
        } else {
            return new Number(Integer.parseInt(input)); // Предполагаем, что если нет скобок, то это число
        }
    }

    private static int findMatchingBracket(String input) {
        int openBrackets = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                openBrackets++;
            } else if (input.charAt(i) == ')') {
                openBrackets--;
                if (openBrackets == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static Expression createExpression(String operator, Expression left, Expression right) {
        switch (operator) {
            case "+":
                return new Add(left, right);
            case "-":
                return new Sub(left, right);
            case "*":
                return new Mul(left, right);
            // ... другие операторы
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }


}
