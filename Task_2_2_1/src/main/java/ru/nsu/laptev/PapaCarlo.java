package ru.nsu.laptev;

import java.util.ArrayList;

public class PapaCarlo {
    private ArrayList<Baker> bakers;
    private ArrayList<Courier> couriers;
    private int totalBakers;
    private int totalCouriers;
    private int freeBakersCount;
    private int freeCourierCount;
    private Storage storage;

    public PapaCarlo(ArrayList<Baker> bakers, ArrayList<Courier> couriers,
                     int storageCapacity ) {
        this.bakers = bakers;
        totalBakers = bakers.size();
        freeBakersCount = totalBakers;

        this.couriers = couriers;
        totalCouriers = couriers.size();
        freeCourierCount = totalCouriers;

        this.storage = new Storage(storageCapacity);
    }

    public void hireCourier(Courier courier) {
        totalCouriers++;
        freeCourierCount++;
        couriers.add(courier);
    }

    public void hireBaker(Baker baker) {
        totalBakers++;
        freeBakersCount++;
        bakers.add(baker);
    }

}
