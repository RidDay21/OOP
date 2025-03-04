package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PapaCarlo {
    private final int totalBakers;
    private final int totalCouriers;

    private ArrayList<Baker> bakers;
    private ArrayList<Courier> couriers;
    private ArrayList<Order> orders;
    private AtomicInteger freeBakersCount;
    private AtomicInteger freeCourierCount;

    private Storage storage;
    private OrderQueue listOfOrders;

    public PapaCarlo(ArrayList<Baker> bakers, ArrayList<Courier> couriers,
                     int storageCapacity ) {
        this.bakers = bakers;
        totalBakers = bakers.size();
        freeBakersCount = new AtomicInteger(totalBakers);

        this.couriers = couriers;
        totalCouriers = couriers.size();
        freeCourierCount = new AtomicInteger(totalCouriers);

        this.storage = new Storage(storageCapacity);
        this.orders = null;
    }


}
