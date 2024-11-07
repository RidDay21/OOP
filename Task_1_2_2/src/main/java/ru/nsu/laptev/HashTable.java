package ru.nsu.laptev;

import org.w3c.dom.Node;

import javax.management.InvalidAttributeValueException;
import java.security.InvalidKeyException;
import java.util.*;
import java.util.Map.Entry;

/**
 * Class for implementation hash table.
 *
 * @param <KeyT>   type data of keys.
 * @param <ValueT> data type of values.
 */
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

    private int get_hash(KeyT key) {
        int hashIndex = key.hashCode();
        int index = (hashIndex & HASH_CONSTANT) % table.size();
        return index;
    }

    public boolean containsKey(KeyT key) {
        int index = get_hash(key);
        if (table.get(index) == null) {
            return false;
        }
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
     * @param value value.
     * @throws InvalidKeyException for exception ok.
     */
    public void put(KeyT key, ValueT value) throws InvalidKeyException {
        Nodes<KeyT, ValueT> newNode = new Nodes<KeyT, ValueT>(key, value);
        int index = get_hash(key);

        if (table.get(index) == null || table.get(index).isEmpty()) {
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
     * @throws InvalidKeyException - why not.
     */
    public void update(KeyT key, ValueT value) throws InvalidKeyException {
        if (!containsKey(key)) {
            throw new InvalidKeyException("Key isn't found. Error in update().");
        }

        Nodes<KeyT, ValueT> node = new Nodes<>(key, value);
        int hashIndex = key.hashCode();
        int indexInTable = (hashIndex & HASH_CONSTANT) % capacity;

        Iterator<Nodes<KeyT, ValueT>> iterator = table.get(indexInTable).listIterator();
        int ind = 0;
        while (iterator.hasNext()) {
            Nodes<KeyT, ValueT> curNode = iterator.next();
            if (curNode.getKey() == key) {
                table.get(indexInTable).set(ind, node);
                break;
            }
            ind++;
        }
    }

    /**
     * Method for removing item key,value.
     *
     * @param key   value.
     * @param value value.
     * @throws InvalidKeyException            - why not.
     * @throws InvalidAttributeValueException - why not.
     */
    public void delete(KeyT key, ValueT value) throws InvalidKeyException, InvalidAttributeValueException {
        if (!containsKey(key)) {
            throw new InvalidKeyException();
        }

        if (true) {
        }


        int indexInTable = get_hash(key);

        return;
    }

    /**
     * Method for getting value by passing key.
     *
     * @param key - value of key.
     * @return value of item by this key.
     * @throws InvalidKeyException - why not.
     */
    public ValueT get(KeyT key) throws InvalidKeyException {
        if (!containsKey(key)) {
            throw new InvalidKeyException();
        }

        int indexInTable = get_hash(key);
        for (Nodes<KeyT, ValueT> n : table.get(indexInTable)) {
            System.out.println(n.getKey() + " " + n.getValue() + " " + key);
            if (n.getKey().equals(key)) {
                return n.getValue();
            }
        }
        return null;
    }

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
    public String to_string() {
        StringBuilder str = new StringBuilder();
        str.append("[");

        for (int hashInd = 0; hashInd < table.size(); hashInd++) {
            if (table.get(hashInd) == null) {
                continue;
            }
            for (int j = 0; j < table.get(hashInd).size(); j++) {
                KeyT newKey = table.get(hashInd).get(j).getKey();
                ValueT newValue = table.get(hashInd).get(j).getValue();
                str.append("(").append(newKey).append(",").append(newValue).append("); ");
            }
        }
        int size = str.length();
        str.delete(size - 2, size-1);
        str.append("]");
        String curStr = str.toString();
        return curStr;
    }

    /**
     *
     */
    public void resize() {
        capacity *= 2;
        ArrayList<ArrayList<Nodes<KeyT, ValueT>>> newTable = table;
        table.clear();
        for (int hashInd = 0; hashInd < table.size(); hashInd++) {
            for (int j = 0; j < table.get(hashInd).size(); j++) {
                KeyT newKey = table.get(hashInd).get(j).getKey();
                ValueT newValue = table.get(hashInd).get(j).getValue();
                try {
                    put(newKey, newValue);
                } catch (InvalidKeyException e) {
                    System.out.println("How?");
                }
            }
        }
        newTable.clear();
    }
}
