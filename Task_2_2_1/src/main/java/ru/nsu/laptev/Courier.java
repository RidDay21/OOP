package ru.nsu.laptev;

/**
 *
 */
public class Courier {
    private int courierID;
    private int deliverySpeed;
    private int trunkCapacity;
    private Order currentOrder; //если currentOrder равен null, то у курьера пока что нет заказа

    /**
     *
     * @param courierID
     * @param deliverySpeed
     */
    public Courier (int courierID, int deliverySpeed, int trunkCapacity) {
        this.courierID = courierID;
        this.deliverySpeed = deliverySpeed;
        this.trunkCapacity = trunkCapacity;
        currentOrder = null;
    }

    /**
     * User need to pass an currentOrder.getAmountOfPizza().
     */
    public boolean takeAnOrder(Order order) {
        int numberOfPizzas = order.getAmountOfPizza();
        boolean flag = false;
        if (trunkCapacity >= numberOfPizzas) {
            currentOrder = order;
            flag = true;
            return flag;
        } else {
            return flag;
        }
    }

    public void deliver() {

    }
}
