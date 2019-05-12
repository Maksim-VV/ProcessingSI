package com.vasiliska.ProcessingSI;

import com.vasiliska.ProcessingSI.models.Car;
import com.vasiliska.ProcessingSI.models.Standard;
import com.vasiliska.ProcessingSI.models.TrimLevel;
import com.vasiliska.ProcessingSI.services.PackageUpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@IntegrationComponentScan
public class ProcessingSiApplication {

    public static final int STANDART = 495_000;
    public static final String COLOR = "Баклажан";

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProcessingSiApplication.class, args);
        IntegrationFlow cycleProductionCars = ctx.getBean("cycleProductionCars", IntegrationFlow.class);

        Car car = new Standard(COLOR, STANDART);
        cycleProductionCars.getInputChannel().send(MessageBuilder.withPayload(car).build());
    }


    @Bean
    public DirectChannel priceUpChanel() {
        return MessageChannels.direct("priceUpChanel").get();
    }

    @Bean
    public IntegrationFlow cycleProductionCars(DirectChannel priceUpChanel, PackageUpService packageUpService) {
        return f -> f.channel(priceUpChanel)
                .transform(Car.class, packageUpService::packageUp)
                .channel(priceUpChanel)
                .transform(Car.class, packageUpService::packageUp)
                .channel(priceUpChanel)
                .transform(Car.class, packageUpService::packageUp)
                .channel(priceUpChanel)
                .transform(Car.class, packageUpService::packageUp)
                .channel(priceUpChanel)
                .transform(Car.class, (GenericTransformer<Car, TrimLevel>) TrimLevel::new)
                .channel(priceUpChanel)
                .handle(m -> System.out.println(m.getPayload()));
    }
}
