package com.vasiliska.ProcessingSI.models;

import static com.vasiliska.ProcessingSI.services.PackageUpServiceImpl.LUXE_PRESTIGE;

public class LuxePrestige extends Luxe {

    public LuxePrestige(Luxe luxe, int newPrice) {
        super(luxe, newPrice);
        getOptions().addAll(luxe.getOptions());
        getComfort().addAll(luxe.getComfort());
    }

    @Override
    boolean checkPrice(int price) {
        return (price > LUXE_PRESTIGE - 1);
    }

    @Override
    public String toString() {
        return String.format("Комплектация \"Люкс\"{Цвет: %s, стоимость: %d, доп. опции: %s, комфорт: "
                + getComfort() + ", медиа: " + getOptions() + "}", getColor(), getPrice(), getSpouse());
    }

}
