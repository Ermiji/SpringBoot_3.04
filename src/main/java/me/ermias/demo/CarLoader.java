package me.ermias.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarLoader implements CommandLineRunner {
    @Autowired
    CarsRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Cars car = new Cars(2000, "Hyundai",
                "Sonata");
        repository.save(car);

        car = new Cars(2018, "Jeep",
                "SUV");
        repository.save(car);

        car = new Cars(2017, "Toyota",
                "Camry");
        repository.save(car);
    }
}
