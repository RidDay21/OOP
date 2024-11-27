package ru.nsu.laptev;
import java.util.Scanner;

public class Parser {

    private static String token;
    private static int pos;
    private static String expression;

    private static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isSpace(char c) {
        return Character.isWhitespace(c);
    }

    private static boolean isSpecSymb(char c) {
        return (c == '+' || c == '-' || c == '*'
                || c == '/' || c == '(' || c == ')');
    }

    private static String readToken() {
        while (pos < expression.length() && isSpace(expression.charAt(pos))){
            pos++;
        }

        if (pos >= expression.length()) {
            return "";
        }

        if (isSpecSymb(expression.charAt(pos))) {
            return String.valueOf(expression.charAt(pos++));
        }

        int start = pos;
        while (pos < expression.length() && isDigit(expression.charAt(pos))) {
            pos++;
        }
        return expression.substring(start, pos);
    }

    private static String peekToken() {
        int oldPos = pos;
        token = readToken();
        pos = oldPos;
        return token;
    }

    private static Expression parseExpr() {
        Expression res = parseMonom();
        while (peekToken().equals("+") || peekToken().equals("-")) {
            String op = readToken();
            Expression val = parseMonom();
            if (op.equals("+")) {
                res = new Add(val, res) ;
            } else {
                res = new Sub(res, val);
            }
        }
        return res;
    }

    private static Expression parseMonom() {
        Expression exp1 = parseAtom();
        Expression exp2;
        String operation;
        while (peekToken().equals("*") || peekToken().equals("/")) {
            operation = readToken();
            exp2 = parseAtom();
            if (operation.equals("*")) {
                exp1 = new Mul(exp1, exp2) ;
            } else {
                exp1 = new Div(exp1, exp2);
            }
        }
        operation = null;
        exp2 = null;
        return exp1;
    }

    private static Expression parseAtom() {
        String peek = peekToken();
        if (peek.equals("-")) {
            readToken();
            return new Mul(parseAtom(), new Number(-1));
        } else if (peek.equals("(")) {
            readToken();
            Expression exp1 = parseExpr();
            readToken();
            return exp1;
        } else if (isDigit(token.charAt(0))) {
            return new Number(Double.parseDouble(token));
        } else if (isLetter(token.charAt(0))) {
            return new Variable(token);
        }
    }

}

