package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @Test
    void readTest(){
        ArrayList<String> text = new ArrayList<>();
        try{
            text = ReadFile.read("C:\\Users\\niko_\\Desktop\\Niki\\nsu\\tmp\\graph.txt");
        } catch (FileNotFoundException e) {

        }

        boolean flag = true;
        try{
            text = ReadFile.read("C:\\Users\\niko_\\Desktop\\Niki\\nsu\\tmp\\bobik.txt");
        } catch (FileNotFoundException e) {
            flag = false;
        }
        assertEquals(flag, false);
//        assertEquals(text.get(0), "7");
    }


}