package ru.nsu.laptev;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final int orderID = 0;
        OrderQueue orderQueue = new OrderQueue(10);
        Storage storage = new Storage(5);

        // Создаем пекарей
        ArrayList<Baker> bakers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            bakers.add(new Baker(i, 2, orderQueue::take, storage::takeOrder, storage));
        }

        // Создаем курьеров
        ArrayList<Courier> couriers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            couriers.add(new Courier(i, 3, 5, storage, storage::passOrder));
        }

        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 1; i < 6;i++) {
            orders.add(new Order(i * 2, orderID + i, 10));
        }

        PapaCarlo papaCarlo = new PapaCarlo(bakers, couriers, 7);

        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            clients.add(new Client(orders.get(i),  papaCarlo::takeOrder));
        }


        papaCarlo.startBakers();
        papaCarlo.startCouriers();

        for (int i = 0; i < clients.size(); i++) {
            papaCarlo.takeAnOrder(clients.get(i));
        }

    }
}
