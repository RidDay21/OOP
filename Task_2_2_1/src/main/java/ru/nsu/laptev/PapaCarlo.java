package ru.nsu.laptev;

import java.util.ArrayList;

public class PapaCarlo {
    private final ArrayList<Baker> bakers;
    private final ArrayList<Courier> couriers;
    private final int amountOfPizzaInOrderLIMIT;
    private OrderQueue orders;

    public PapaCarlo(ArrayList<Baker> bakers, ArrayList<Courier> couriers,
                     int amountOfPizzaInOrderLIMIT) {
        this.bakers = bakers;
        this.couriers = couriers;

        this.amountOfPizzaInOrderLIMIT = amountOfPizzaInOrderLIMIT;
        orders = new OrderQueue(100);
    }

    public synchronized boolean takeOrder(Order order) {
        if (order.getAmountOfPizza() > amountOfPizzaInOrderLIMIT) {
            return false;
        }

        try {
            orders.add(order);
            System.out.println("Заказ " + order.getID() + "обработан пиццерией");
            notifyAll();
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстановление статуса прерывания
            return false;
        }
    }

    public void startBakers() {
        // Запуск пекарей
        System.out.println("Запуск потоков bakers...");
        for (Baker baker : bakers) {
            new Thread(baker).start();
        }
    }

    public void startCouriers() {
        System.out.println("Запуск потоков couries...");
        for (Courier courier : couriers) {
            new Thread(courier).start();
        }
    }

    public void takeAnOrder(Client client) {
        new Thread(client).start();
    }
}
