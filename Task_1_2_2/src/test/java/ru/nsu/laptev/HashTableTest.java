package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.InvalidKeyException;
import javax.management.InvalidAttributeValueException;

import org.junit.jupiter.api.Test;

class HashTableTest {
    @Test
    void sampleTest() {
        HashTable<Object, Object> hashTable = new HashTable<>();
        try {
            assertEquals(hashTable.get_capacity(), 4);
            //adding keys
            hashTable.put("1", 234);
            hashTable.put(234, "qwerty");
            hashTable.put(0.4f, 4);
            assertTrue(hashTable.containsKey(0.4f));
            hashTable.put("ManUnited", "Old Trafford");
            //after 4'th key our hash table need to resize and we check it.
            assertEquals(hashTable.get_capacity(), 8);
            hashTable.put("Movie", 43);
            hashTable.put(8841, "wow...");
            hashTable.put("1", 0.345345f);
        } catch (InvalidKeyException e) {
            System.out.println("Key is already in HashTable");
        }

        System.out.println(hashTable.to_string());

        try {
            assertEquals(hashTable.get("1"), 234);
            assertEquals(hashTable.get(234), "qwerty");
            assertEquals(hashTable.get("sdfsdfsdf"), 234);
        } catch (InvalidKeyException e) {
            System.out.println("Such key doesn't exist in HashTable");
        }

        try {
            hashTable.update("1", "sdf");
            assertEquals(hashTable.get("1"), "sdf");
            hashTable.update(232323, "sdf");
        } catch (InvalidKeyException e) {
            System.out.println("Such key doesn't exist in HashTable");
        }

        try {
            hashTable.delete("1", "sdf");
            assertFalse(hashTable.containsKey("1"));
            hashTable.delete("ManUnited", 1878);
        } catch (InvalidKeyException e) {
            System.out.println("HashTable doesn't contain such key.");
        } catch (InvalidAttributeValueException e) {
            System.out.println("HashTable doesn't contain such pair of key-value.");
        }


    }

    @Test
    void nodesTest() {
        Nodes<Integer, String> n = new Nodes<>(12, "ds");
        assertEquals(n.getKey(), 12);
        assertEquals(n.getValue(), "ds");

        Nodes<Integer, String> n1 = new Nodes<>(14, "dfr");
        Nodes<Integer, String> n2 = new Nodes<>(12, "ds");
        assertEquals(true, n.equals(n2));
        assertEquals(false, n.equals(n1));
    }
}