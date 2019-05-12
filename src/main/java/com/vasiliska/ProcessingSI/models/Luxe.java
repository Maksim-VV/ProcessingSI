package com.vasiliska.ProcessingSI.models;

import lombok.Getter;

import java.util.HashSet;

import static com.vasiliska.ProcessingSI.services.PackageUpServiceImpl.LUXE;
import static com.vasiliska.ProcessingSI.services.PackageUpServiceImpl.LUXE_PRESTIGE;

public class Luxe extends NormaComfort {

    @Getter
    private final HashSet<String> options;

    public Luxe(String color, int price) {
        super(color, price);
        options = new HashSet<>();
    }

    public Luxe(NormaComfort normaComfort, int newPrice) {
        super(normaComfort, newPrice);
        setSpouse(normaComfort.getSpouse());
        getComfort().addAll(normaComfort.getComfort());
        options = new HashSet<>();
    }

    public void addOptional(String optionalName) {
        options.add(optionalName);
    }


    @Override
    boolean checkPrice(int price) {
        return (price > LUXE-1 && price < LUXE_PRESTIGE-1);
    }

    @Override
    public String toString() {
        return String.format("Комплектация \"Люкс\"{Цвет: %s, стоимость: %d, доп. опции: %s" +
                ", комфорт: " + getComfort() +
                ", медиа: " + getOptions() + "}", getColor(), getPrice(), getSpouse());
    }

}
