package ru.nsu.laptev;

import java.util.Queue;

public class Storage {
    private final int capacity;
    private int availableCapacity;
    private final Queue<Order> orderQueue;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
        orderQueue = null;
    }

    public void takeAnOrder(Order order) {
        int numberOfPizzas = order.getAmountOfPizza();
        if (availableCapacity >= numberOfPizzas) {
            orderQueue.add(order);
            availableCapacity -= numberOfPizzas;
        }
    }

    public boolean take_from_kitchen(Order order) {
        boolean flag = false;

        return flag;
    }

    public boolean give_to_courier(Order order) {
        boolean flag = false;
        if (true) {

        }
        return flag;
    }
}
