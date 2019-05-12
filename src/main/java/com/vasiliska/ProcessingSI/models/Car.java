package com.vasiliska.ProcessingSI.models;

import lombok.Data;
import com.vasiliska.ProcessingSI.exceptions.WrongCostException;

@Data
public abstract class Car {
    private String color;
    private int price;

    public Car(String color, int price) {
        this.color = color;
        setPrice(price);
    }

    boolean checkPrice(int price) {
        return true;
    }

    public void setPrice(int price) {
        if (!checkPrice(price)) {
            throw new WrongCostException(price);
        }
        this.price = price;
    }
}
