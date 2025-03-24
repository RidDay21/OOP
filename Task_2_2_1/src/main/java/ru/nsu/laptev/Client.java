package ru.nsu.laptev;

public class Client implements Runnable {

    public final Order order;
    public final OrderPassInterface orderPasser;

    public Client(Order order, OrderPassInterface orderPasser) {
        this.order = order;
        this.orderPasser = orderPasser;
    }

    @Override
    public void run() {
        try {
            System.out.println("Клиент делает заказ " + order.getID());
            boolean isOrdered = orderPasser.passOrder(order);
            if (isOrdered) {

                // Ожидание доставки
                synchronized (order) {
                    while (order.getOrderState() != OrderState.DELIVERED) {
                        order.wait();
                    }
                }

                System.out.println("Order " + order.getID() + " delivered!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}