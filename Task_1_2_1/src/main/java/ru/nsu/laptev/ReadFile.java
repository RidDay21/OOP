package ru.nsu.laptev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFile  {
    //C:\\Users\\niko_\\Desktop\\Niki\\nsu\\tmp"
    static ArrayList<String> read(String path_name) throws FileNotFoundException {
        String separator = File.separator;
        File file = new File(path_name);
        ArrayList<String> text = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            text.add(scanner.nextLine());
            System.out.println(text);
        }

        return new ArrayList<>();
    }
}
