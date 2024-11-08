package ru.nsu.laptev;

/**
 * Class for implementation pair in my HashTable.
 * @param <KeyT> for Type of Key Data.
 * @param <ValueT> for Type of Value Data.
 */
public class Nodes<KeyT, ValueT> {
    private KeyT key;
    private ValueT value;

    public Nodes(KeyT key, ValueT value) {
        this.key = key;
        this.value = value;
    }

    public KeyT getKey() {
        return key;
    }

    public ValueT getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        Nodes<KeyT, ValueT> node = (Nodes<KeyT, ValueT>) o;
        boolean keyEqual = this.key.equals(node.getKey());
        boolean valueEqual = this.value.equals(node.getValue());
        ;
        return keyEqual && valueEqual;
    }
}

