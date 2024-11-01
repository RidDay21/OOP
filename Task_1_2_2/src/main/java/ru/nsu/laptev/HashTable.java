package ru.nsu.laptev;

import org.w3c.dom.Node;

import java.security.InvalidKeyException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.ListIterator;

public class HashTable<KeyT, ValueT> {
    private int size = 0;
    private int capacity = 16;


    private static final int HASH_CONSTANT = 0x7FFFFFFF;
    private static final double LOAD_FACTOR = 0.75f;

    public ArrayList<ArrayList<Nodes<KeyT, ValueT>>> table;

    public HashTable() {
        size = 0;
        table = new ArrayList<>(Collections.nCopies(capacity, null));
    }

    public boolean containsKey(Object key) {
        int hashIndex = key.hashCode();
        int index = (hashIndex & HASH_CONSTANT) % table.size();
        ListIterator<Nodes<KeyT, ValueT>> iterator = table.get(index).listIterator();
        while (iterator.hasNext()) {
            Nodes<KeyT, ValueT> node = iterator.next();
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for putting new item in HashTable.
     *
     * @param key   value.
     * @param value value).
     */
    public void put(KeyT key, ValueT value) throws InvalidKeyException {
        Nodes<KeyT, ValueT> newNode = new Nodes<KeyT, ValueT>(key, value);
        int hashIndex = key.hashCode();
        int index = (hashIndex & HASH_CONSTANT) % capacity;

        if (table.get(index).isEmpty()) {
            table.set(index, new ArrayList<Nodes<KeyT, ValueT>>());
            table.get(index).add(newNode);
            size++;
        } else if (containsKey(key)) {
            throw new InvalidKeyException();
        } else {
            if ((double) size / (double) capacity >= LOAD_FACTOR) {
                resize();
            }
            int bucketSize = table.get(index).size();
            table.get(index).add(bucketSize, newNode);
            size++;//
        }

    }

    /**
     * Method for changing value of item by key.
     *
     * @param key   value, that would change.
     * @param value - new value.
     */
    public void update(KeyT key, ValueT value) {

    }

    /**
     * Method for removing item <key,value>.
     *
     * @param key   value.
     * @param value value.
     */
    public void delete(KeyT key, ValueT value) {

    }
//
//    /
//     * Method for getting value by passing key.
//     * @param key - value of key.
//     * @return value of item by this key.
//     */
//    public ValueT get(KeyT key) {
//
//    }

    /**
     * Method for checking is two hash tables equal.
     *
     * @param new_hash_table with which would compare.
     */
    public boolean is_equal(HashTable<ValueT, KeyT> new_hash_table) {
        return true;
    }


    /**
     * Method for printing hash table in a row, u know.
     */
    public void print() {

    }

    /**
     *
     */
    public void resize() {

    }
}
