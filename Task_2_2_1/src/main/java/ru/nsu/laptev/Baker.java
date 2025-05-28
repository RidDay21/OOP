package ru.nsu.laptev;

import java.util.concurrent.atomic.AtomicBoolean;


public class Baker implements Runnable {
    private final int bakerID;
    private final int pizzaBakeTime;
    private Order order;
    private final OrderProvideInterface orderProvider;
    private final OrderPassInterface orderPasser;

    public Baker(int bakerID, int pizzaBakeTime, OrderProvideInterface orderProvider,
                 OrderPassInterface orderPasser, Storage storage) {
        this.bakerID = bakerID;
        this.pizzaBakeTime = pizzaBakeTime;
        this.orderProvider = orderProvider;
        this.orderPasser = orderPasser;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Baker " + bakerID + " готов заняться новым заказом");
                order = orderProvider.takeOrder();
                if (order == null){
                    System.out.println("Пекарь не смог взять заказ");
                    break;
                }
                System.out.println("Order " + order.getID() + " is being prepared by baker " + bakerID);

                Thread.sleep(pizzaBakeTime * order.getAmountOfPizza() * 10L);
                order.becomeNewState(OrderState.COOKED);
                System.out.println("Baker " + bakerID + " пытается положить заказ в Storage...");
                orderPasser.passOrder(order);
                order = null;
            } catch (InterruptedException e) {
                System.out.println("Huesos");
            }
        }

    }
}