package ru.nsu.laptev;

public class Order {
    private int amountOfPizza;
    private int orderID; //хз, может уберу
    private int deliveryTime;
    private OrderState isTaken;

    public Order(int amountOfPizza, int orderID, int deliveryTime) {
        this.amountOfPizza = amountOfPizza;
        this.deliveryTime = deliveryTime;
        this.orderID = orderID;

        isTaken = OrderState.WAITING;
    }

    public synchronized int getAmountOfPizza() {
        return amountOfPizza;
    }

    public synchronized void becomeCooking() {
        isTaken = OrderState.COOKING;
    }

    public synchronized void becomeCooked() {
        isTaken = OrderState.COOKED;
    }

    public synchronized void becomeDelivering() {
        isTaken = OrderState.DELIVERING;
    }

    public synchronized void becomeDelivered() {
        isTaken = OrderState.DELIVERED;
    }

    public synchronized void becomeClosed() {
        isTaken = OrderState.CLOSED;
    }

}
