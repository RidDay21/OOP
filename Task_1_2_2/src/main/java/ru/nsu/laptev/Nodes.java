package ru.nsu.laptev;

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
//        if (getClass() != o.getClass()) {
//            return false;
//        }
        Nodes<KeyT, ValueT> node = (Nodes<KeyT, ValueT>) o;
        boolean keyEqual = this.key.equals(node.getKey());
        boolean valueEqual = this.value.equals(node.getValue());
        ;
        return keyEqual && valueEqual;
    }
}

