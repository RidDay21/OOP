package ru.nsu.laptev;

public class Order {
    private int amountOfPizza;
    private int orderID; //хз, может уберу
    private int deliveryTime;
    private volatile OrderState state;

    public Order(int amountOfPizza, int orderID, int deliveryTime) {
        this.orderID = orderID;
        this.amountOfPizza = amountOfPizza;
        this.deliveryTime = deliveryTime;

        state = OrderState.WAITING;
    }

    public int getID() { return orderID; }

    public OrderState getOrderState() {
        return state;
    }

    public synchronized int getAmountOfPizza() {
        return amountOfPizza;
    }

    public synchronized void becomeNewState(OrderState state) {
        this.state = state;
        System.out.println(state.getTitle());
    }


}
