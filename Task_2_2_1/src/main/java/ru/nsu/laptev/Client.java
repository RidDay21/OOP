package ru.nsu.laptev;

public class Client extends Thread {

    public synchronized void doAnOrder(OrderQueue orders, Order order) {
        orders.addOrder(order);
    }

    @Override
    public void run() {

    }
}

