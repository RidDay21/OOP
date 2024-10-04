package ru.nsu.laptev;

public class Parser {

    static String Parsing(String variable, String exp) {
        String number = new String();//explain why latter
        String[] parts = exp.split(" ");
        for (int i = 0; i < parts.length;i++) {
            if (parts.equals(variable)) {
                number = parts[i+2];
                break;
            }
        }
        return number;
    }
}
