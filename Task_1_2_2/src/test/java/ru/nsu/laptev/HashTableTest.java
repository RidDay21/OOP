package ru.nsu.laptev;

import java.security.InvalidKeyException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.management.InvalidAttributeValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HashTableTest {
    HashTable<Object, Object> hashTable = new HashTable<>();
    HashTable<Object, Object> ht = new HashTable<>();
    HashTable<Object, Object> ht2 = new HashTable<>();

    @BeforeEach
    void initialize() {
        try {
            assertEquals(hashTable.get_capacity(), 4);
            assertTrue(hashTable.is_equal(ht));
            assertTrue(hashTable.is_equal(ht2));
            assertTrue(ht.is_equal(ht2));
            //adding keys
            hashTable.put("1", 234);
            ht.put("1", 234);
            ht2.put("1", 234);

            hashTable.put(234, "qwerty");
            ht.put(234, "qwerty");
            ht2.put(234, "qwerty");

            hashTable.put(0.4f, 4);
            ht.put(0.4f, 4);
            ht2.put(0.4f, 4);
            assertTrue(hashTable.containsKey(0.4f));
            assertTrue(ht.containsKey(0.4f));

            hashTable.put("ManUnited", "Old Trafford");
            ht.put("ManUnited", "Old Trafford");
            ht2.put("ManUnited", "Old Trafford");
            assertEquals(hashTable.get_capacity(), 8);


            hashTable.put("Movie", 43);
            ht.put("Movie", 43);
            ht2.put("Movie", 43);

            hashTable.put(8841, "wow...");
            ht.put(8841, "wow...");
            ht2.put(8841, "wow...");

            ht2.put("Marcus", "0 goals");

            hashTable.put("1", 0.345345f);
        } catch (InvalidKeyException e) {
            System.out.println("Key is already in HashTable");
        }
    }

    @Test
    void hashTableTest() {
        System.out.println(hashTable.to_string());
        System.out.println(ht.to_string());

        try {
            ht.get("Movie");
            ht.get("Pavel");
        } catch (InvalidKeyException e) {
            System.out.println("Such key doesn't exist.");
        }

        System.out.println(ht2.to_string());
        System.out.println(ht.to_string());
        System.out.println(hashTable.to_string());

        assertFalse(hashTable.is_equal(ht2));
        assertTrue(ht.is_equal(hashTable));

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
    void iteratorTest() {
        HashTable<Integer, Integer> hashtable = new HashTable<>();

        for (int i = 0; i < 10; i++) {
            try {
                hashtable.put(i, i * 10 ^ 2);
            } catch (InvalidKeyException e) {
                System.out.println("ok.");
            }
        }
        assertEquals(hashtable.get_size(), 10);

        Iterator<Nodes<Integer, Integer>> iterator = hashtable.iterator();

        while (iterator.hasNext()) {
            iterator.next();
        }
        assertThrows(NoSuchElementException.class, () -> iterator.next());
        //check for Changing mistake
        HashTable<Integer, Integer> hashtable1 = new HashTable<>();
        for (int i = 0; i < 10; i++) {
            try {
                hashtable1.put(i, i * 42);
            } catch (InvalidKeyException e) {
                System.out.println("ok.");
            }
        }
        Iterator<Nodes<Integer, Integer>> iterator1 = hashtable1.iterator();
        iterator1.next();
        try {
            hashtable1.put(123, 3);
            assertThrows(ConcurrentModificationException.class, () -> iterator1.next());
            assertThrows(ConcurrentModificationException.class, () -> iterator1.hasNext());
        } catch (InvalidKeyException e) {
            System.out.println("Such key has already existed.");
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