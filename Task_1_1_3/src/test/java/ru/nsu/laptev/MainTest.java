package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void mainTest() {
        Main.main(null);
        Main main = new Main();
        main.main(null);
    }

}