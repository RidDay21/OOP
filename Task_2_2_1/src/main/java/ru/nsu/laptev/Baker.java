package ru.nsu.laptev;

/**
 *
 */
public class Baker {
    private int bakerID;
    private int pizzaBakeTime;
    private Order currentOrder; //если currentOrder равен null, то у курьера пока что нет заказа

    public Baker(int bakerID, int pizzaBakeTime) {
        this.bakerID = bakerID;
        this.pizzaBakeTime = pizzaBakeTime;
        currentOrder = null;
    }

    /**
     * User need to pass an currentOrder.getAmountOfPizza().
     */
    public void takeAnOrder(Order order) {
        if (currentOrder == null) {
            currentOrder = order;
        }
         else {
            //wait();
        }
    }

    public void deliver() {

    }
}
