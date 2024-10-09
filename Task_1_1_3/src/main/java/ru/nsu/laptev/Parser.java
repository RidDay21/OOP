package ru.nsu.laptev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for implementation parsing.
 */
public class Parser {

    static int Parsing(String variable, String exp) {
        Pattern pattern = Pattern.compile(variable + "\\s*=\\s*(\\d+)");
        Matcher matcher = pattern.matcher(exp);

        int value = 0;
        while (matcher.find()) {
            value = Integer.parseInt(matcher.group(1));
        }
        return value;
    }
}
