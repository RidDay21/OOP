package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void sampleTest() {
        HashTable<Object, Object> hashTable = new HashTable<>();
    }

    @Test
    void nodesTest() {
        Nodes<Integer, String> n = new Nodes<>(12, "ds");
        Nodes<Integer, String> n1 = new Nodes<>(14, "dfr");
        Nodes<Integer, String> n2 = new Nodes<>(12, "ds");

        assertEquals(n.getKey(), 12);
        assertEquals(n.getValue(), "ds");

        assertEquals(true, n.equals(n2));
        assertEquals(false, n.equals(n1));
    }
}