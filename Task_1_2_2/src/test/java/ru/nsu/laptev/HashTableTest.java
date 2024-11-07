package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTableTest {
    @Test
    void sampleTest() {
        HashTable<Object, Object> hashTable = new HashTable<>();
        try {
            hashTable.put("1", 234);
            hashTable.put(234, "qwerty");
            hashTable.put(0.4f, 4);
            hashTable.put("1", 0.345345f);
        } catch (InvalidKeyException e){
            System.out.println("Key is already in HashTable");
        }

        System.out.println( hashTable.to_string());

        try {
            assertEquals(hashTable.get("1"), 234);
            assertEquals(hashTable.get(234), "qwerty");
            assertEquals(hashTable.get("sdfsdfsdf"), 234);
        }  catch (InvalidKeyException e){
            System.out.println("Go fuck yourself");
        }

        try {
            hashTable.update("1", "sdf");
            assertEquals(hashTable.get("1"),"sdf");
            hashTable.update(232323, "sdf");
        } catch (InvalidKeyException e) {

        }


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