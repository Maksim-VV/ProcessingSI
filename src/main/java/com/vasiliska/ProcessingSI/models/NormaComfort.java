package com.vasiliska.ProcessingSI.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static com.vasiliska.ProcessingSI.services.PackageUpServiceImpl.LUXE;
import static com.vasiliska.ProcessingSI.services.PackageUpServiceImpl.NORMA_COMFORT;

public class NormaComfort extends Norma {

    @Getter
    @Setter
    private String spouse;

    @Getter
    private final Set<String> comfort;

    public NormaComfort(String color, int price) {
        super(color, price);
        this.comfort = new HashSet<>();
    }

    public NormaComfort(Norma norma, int newPrice) {
        super(norma, newPrice);
        comfort = new HashSet<>();
    }

    public void AddChild(String mediaName) {
        comfort.add(mediaName);
    }


    @Override
    boolean checkPrice(int price) {
        return (price > NORMA_COMFORT - 1 && price < LUXE - 1);
    }

    @Override
    public String toString() {
        return String.format("Комплектация \"Норма-Комфорт\" {Цвет: %s, стоимость: %d, доп. опции: %s, комфорт: "
                + getComfort() + "}", getColor(), getPrice(), getSpouse());
    }
}
