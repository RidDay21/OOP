// OrderQueue.java
package ru.nsu.laptev;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderQueue implements Iterable <Order> {
    private Queue<Order> orders;
    private AtomicInteger storedAmount;
    private final int capacity;

    public OrderQueue(int capacity) {
        this.capacity = capacity;
        orders = new LinkedList<>();
        storedAmount = new AtomicInteger(0);
    }

    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    public synchronized int getStoredAmount() {
        return storedAmount.get();
    }

    public synchronized void add(Order order) throws InterruptedException {
        while (orders.size() >= capacity) {
            System.out.println("В очереди нет места для заказа");
            wait();
        }
        orders.offer(order);
        System.out.println("Добавлен заказ " + order.getID());
        storedAmount.incrementAndGet();
        System.out.println("Сейчас в очереди лежат заказы ");
        for (Order o : orders) {
            System.out.println("ID: " + o.getID() + " Кол-во пицц: " + o.getAmountOfPizza());
        }
        notifyAll();
        System.out.println("Оповестили всех, текущее Stored amount: " + storedAmount.get());
    }

    public synchronized Order take() throws InterruptedException {
        while (orders.isEmpty()) {
            System.out.println("Baker ожидает заказ, но очередь пуста. Ждем...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("МЕНЯ ПИЗДАНУЛИ ЛОПАТОЙ");
            }

        }
        Order item = orders.poll();
        item.becomeNewState(OrderState.COOKING);
        System.out.println("Получен заказ " + item.getID());

        storedAmount.decrementAndGet();
        System.out.println("Оповестили всех, заказ забирают, текущее Stored amount: " + storedAmount.get());
        notifyAll();
        System.out.println("Baker получил заказ " + item.getID());
        return item;
    }

}