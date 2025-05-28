package ru.nsu.laptev;

import static java.lang.Thread.sleep;

public class Courier implements Runnable {
    private final int courierID;
    private final int deliverySpeed;
    private final int trunkCapacity;
    private final StorageOrderProviderInterface orderProvider;
    private Order order;

    public Courier(int courierID, int deliverySpeed, int trunkCapacity,
                   Storage storage, StorageOrderProviderInterface orderProvider) {
        this.courierID = courierID;
        this.deliverySpeed = deliverySpeed;
        this.orderProvider = orderProvider;
        this.trunkCapacity = trunkCapacity;

        order = null;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Courier " + courierID + " ожидает заказ...");
                order = orderProvider.takeOrder(trunkCapacity);
                if (order == null) continue;

                System.out.println("Order " + order.getID() + " is DELIVERING");
                order.becomeNewState(OrderState.DELIVERING);
                sleep(deliverySpeed * 1000L);
                synchronized (order) {
                    order.becomeNewState(OrderState.DELIVERED);
                    order.notifyAll(); // Уведомляем клиента
                }
                System.out.println("Order " + order.getID() + " DELIVERED by courier " + courierID);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            order = null;
        }
    }
}