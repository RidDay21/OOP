package ru.nsu.laptev;

@FunctionalInterface
public interface StorageOrderProviderInterface {
    public Order takeOrder(int max_size);
}
