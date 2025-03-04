package ru.nsu.laptev;

import java.util.LinkedList;

/**
 * My implementation of BlockingQueue
 */
public class OrderQueue {
    static final int LIMIT = 21;
    LinkedList<Order> orders;

    public OrderQueue() {
        orders = new LinkedList<>();
    }

    public synchronized void addOrder(Order order) throws OrderListIsFullException {
        if (orders.size() == LIMIT) {
            throw new OrderListIsFullException("Достигнут лимит заказов в нашей "
                    + "маленькой пиццерии. Перезвоните позже\n");
        }
        orders.add(order);
    }

    public synchronized Order takeOrder(Order order) throws OrderListIsEmptyException {
        if (orders.isEmpty()) {
            throw new OrderListIsEmptyException("Заказов нет, отдохни");
        }
        Order tmpOrder = orders.removeFirst();

        return tmpOrder;
    }
}
