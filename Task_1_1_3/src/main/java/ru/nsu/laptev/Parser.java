package ru.nsu.laptev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for implementation parsing.
 */
public class Parser {

    static int parsing(String variable, String exp) throws ArithmeticException{
        Pattern pattern = Pattern.compile(variable + "\\s*=\\s*(\\d+)");
        Matcher matcher = pattern.matcher(exp);

        int value = 0;
        boolean flag = false;
        while (matcher.find()) {
            value = Integer.parseInt(matcher.group(1));
            flag = true;
        }
        if (!flag) {
            throw new ArithmeticException("U haven't initialized variable.");
        }
        return value;
    }
}
