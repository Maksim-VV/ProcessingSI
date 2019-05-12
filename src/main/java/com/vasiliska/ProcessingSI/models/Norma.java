package com.vasiliska.ProcessingSI.models;

import static com.vasiliska.ProcessingSI.services.PackageUpServiceImpl.NORMA;
import static com.vasiliska.ProcessingSI.services.PackageUpServiceImpl.NORMA_COMFORT;

public class Norma extends Standard {

    public Norma(String color, int price) {
        super(color, price);
    }

    public Norma(Standard standard, int newPrice) {
        super(standard.getColor(), newPrice);
    }

    @Override
    boolean checkPrice(int price) {
        return (price > NORMA-1 && price < NORMA_COMFORT-1);
    }

    @Override
    public String toString() {
        return String.format("Комплектация \"Норма\" кузов + руль + колеса + тормоза {Цвет: %s, стоимость: %d}", getColor(), getPrice());
    }
}
