package ru.nsu.laptev;

/**
 * Interface for tramsforming.
 * 
 * @param <T> for class.
 */
public interface Transformer<T> {
    T transform(String str);
}
