package ru.nsu.laptev;

public enum OrderState {
    WAITING ("Клиент сделал заказ"),
    COOKING("Заказ обработан и начинает готовиться"),
    COOKED("Пекарь испек пиццы из заказа"),
    STORED("Заказ передан в хранилище"),
    DELIVERING("Заказ передан курьеру"),
    DELIVERED("Курье доставил заказ"),
    CLOSED("Клиент очень доволен и закрыл пиццерию");

    private String title;

    OrderState(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
