package ru.nsu.laptev;

import java.util.*;
import java.util.Map.Entry;
import java.util.LinkedList;
import java.util.ListIterator;

public class HashTable<KeyT,ValueT>  {
    private int size;
    private static final int HASH_CONSTANT = 0x7FFFFFFF;
    public LinkedList<Nodes<KeyT, ValueT>>[] table;


    public HashTable() {
        size = 0;
        table[0] = new LinkedList<>();
    }

    public boolean containsKey(Object key) {
        int hashIndex = key.hashCode();
        int index = (hashIndex & HASH_CONSTANT) % table.length;
        ListIterator <Nodes<KeyT,ValueT>> iterator = table[index].listIterator();
        while(iterator.hasNext()) {
            Nodes<KeyT, ValueT> node = iterator.next();
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    /** Method for putting new item in HashTable.
     * @param key value.
     * @param value value).
     */
    public void put(KeyT key, ValueT value) {
        if (value == null) {
            throw new NullPointerException();
        }

        int hashIndex = key.hashCode();
        int index = (hashIndex & HASH_CONSTANT) % table.length;
        if (table[index].isEmpty()) {

        }
        //It's necessary to check is key already in hashtable.

    }

    /** Method for changing value of item by key.
     * @param key value, that would change.
     * @param value - new value.
     */
    public void update(KeyT key, ValueT value) {

    }

    /** Method for removing item <key,value>.
     * @param key value.
     * @param value value.
     */
    public boolean delete(KeyT key, ValueT value) {

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

    /** Method for checking is two hash tables equal.
     * @param new_hash_table with which would compare.
     */
    public boolean is_equal(HashTable<ValueT, KeyT> new_hash_table) {

    }


    /** Method for printing hash table in a row, u know.
     */
    public void print() {

    }


}
