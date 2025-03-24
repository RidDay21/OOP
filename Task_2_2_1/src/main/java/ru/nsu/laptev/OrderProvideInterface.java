package ru.nsu.laptev;

@FunctionalInterface
interface OrderProvideInterface {
    Order takeOrder() throws InterruptedException;
}
