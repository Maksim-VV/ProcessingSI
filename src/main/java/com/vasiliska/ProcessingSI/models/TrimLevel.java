package com.vasiliska.ProcessingSI.models;

public class TrimLevel {
    private final Car car;

    public TrimLevel(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Автомобиль: " + car;
    }
}
