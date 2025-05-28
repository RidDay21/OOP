package ru.nsu.laptev;

import java.util.Iterator;


public class Storage {
    private final int capacity;
    private OrderQueue cookedOrderQueue;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.cookedOrderQueue = new OrderQueue(capacity);
    }

    public synchronized boolean takeOrder(Order order) {
        while (cookedOrderQueue.getStoredAmount() + order.getAmountOfPizza() >= capacity) {
            try {
                System.out.println("Хранилище заполнено. Подождите пожалуйста...");
                wait();
            } catch (InterruptedException ignored) {
                return false;
            }
        }
        try {
            System.out.println("Заказ" + order.getID() + " добавлен в хранилище");
            cookedOrderQueue.add(order);

            notifyAll();
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }

    public synchronized Order passOrder(int availableCapacity) {
        try {
            while (true) {
                if (cookedOrderQueue.getStoredAmount() == 0) {
                    wait(100);  // Если очередь пуста, ждём появления заказов
                    continue;
                }
                // Ищем заказ, который удовлетворяет вместимости
                for (Iterator <Order> it = cookedOrderQueue.iterator(); it.hasNext();) {
                    Order order = it.next();
                    if (order.getAmountOfPizza() <= availableCapacity) {
                        it.remove(); // Удаляем заказ из очереди
                        notifyAll(); // Уведомляем другие потоки об изменении
                        return order;
                    }
                }
                // Если ни один заказ не подошёл, подождем немного и повторим попытку
                wait(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

}
