package bg.shengov.garages_manager;

import bg.shengov.garages_manager.model.entity.Car;
import bg.shengov.garages_manager.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final CarRepository carRepository;

    @Override
    public void run(String... args) {
//        saveCar();
        carRepository.findAll()
                .forEach(e -> System.out.println(e.toString()));
    }

    private void saveCar() {
        Car toSave = new Car("Mercedes", "G-class", BigDecimal.valueOf(20_000), 2024,
                BigDecimal.valueOf(200), "Caput");

        carRepository.save(toSave);
    }
}
