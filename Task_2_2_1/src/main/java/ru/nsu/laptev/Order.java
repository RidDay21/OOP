package ru.nsu.laptev;

public class Order {
    private int amountOfPizza;
    private int orderID;
    private boolean isTaken;

    public Order(int amountOfPizza, int orderID) {
        this.amountOfPizza = amountOfPizza;
        this.orderID = orderID;
    }

    public int getAmountOfPizza() {
        return amountOfPizza;
    }

    public void takeOrder() {
        isTaken = true;
    }
}
