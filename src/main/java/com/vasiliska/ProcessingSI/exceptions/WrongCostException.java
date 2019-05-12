package com.vasiliska.ProcessingSI.exceptions;


public class WrongCostException extends RuntimeException {
    private final int price;

    public WrongCostException(int price) {
        this.price = price;
    }


    @Override
    public String getMessage() {
        return "Столько машины не стоят!" + price;
    }
}
