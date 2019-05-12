package com.vasiliska.ProcessingSI.models;

import static com.vasiliska.ProcessingSI.services.PackageUpServiceImpl.STANDART;

public class Standard extends Car {

    public Standard(String color, int price) {
        super(color, price);
    }

    @Override
    boolean checkPrice(int price) {
        return price <= STANDART;
    }

    @Override
    public String toString() {
        return String.format("Комплектация \"Стандарт\" только кузов + руль + колеса {Цвет: %s, стоимоть: %d}",
                getColor(), getPrice());
    }
}
