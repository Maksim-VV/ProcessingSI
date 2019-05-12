package com.vasiliska.ProcessingSI.services;

import com.vasiliska.ProcessingSI.exceptions.WrongCostException;
import com.vasiliska.ProcessingSI.models.Car;

public interface PackageUpService {
    Car packageUp(Car car) throws WrongCostException;
}
