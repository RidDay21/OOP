package ru.nsu.laptev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for implementation parsing.
 */
public class Parser {

    static double parsing(String variable, String exp) throws ArithmeticException {
        Pattern pattern = Pattern.compile(variable + "\s*=\s*([\\d.]+)");
        //Pattern.compile(variable + "\s=\s(\\d+)(.\\d+)?");

        Matcher matcher = pattern.matcher(exp);

        double value = 0;
        boolean flag = false;
        while (matcher.find()) {
            value = Double.parseDouble(matcher.group(1));
            flag = true;
        }
        if (!flag) {
            throw new ArithmeticException("U haven't initialized variable.");
        }
        return value;
    }
}
