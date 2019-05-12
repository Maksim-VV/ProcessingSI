package com.vasiliska.ProcessingSI.services;

import org.springframework.stereotype.Service;
import com.vasiliska.ProcessingSI.exceptions.*;
import com.vasiliska.ProcessingSI.models.*;

@Service
public class PackageUpServiceImpl implements PackageUpService {

    public static final int LUXE_PRESTIGE = 625_000;
    public static final int LUXE = 595_000;
    public static final int NORMA_COMFORT = 565_000;
    public static final int NORMA = 515_000;
    public static final int STANDART = 495_000;

    @Override
    public Car packageUp(Car car) throws WrongCostException {
        if (car instanceof Luxe) {
            LuxePrestige luxePrestige = new LuxePrestige((Luxe) car, LUXE_PRESTIGE);
            luxePrestige.addOptional("Subwoofer");
            return luxePrestige;
        }
        else if (car instanceof NormaComfort) {
            Luxe luxe = new Luxe((NormaComfort) car, LUXE);
            luxe.addOptional("TV+Andriod+Navigator");
            luxe.AddChild("Кондиционер");
            return luxe;
        }
        else if (car instanceof Norma) {
            NormaComfort normaComfort = new NormaComfort((Norma) car, NORMA_COMFORT);
            normaComfort.setSpouse("Подушки безопасности");
            normaComfort.AddChild("Подогрев сидений");
            return normaComfort;
        }
        else if (car instanceof Standard) {
            return new Norma((Standard) car, NORMA);
        }
        return car;
    }
}
