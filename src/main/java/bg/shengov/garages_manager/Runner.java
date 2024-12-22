package bg.shengov.garages_manager;

import bg.shengov.garages_manager.model.dto.VehicleFilterDTO;
import bg.shengov.garages_manager.model.enums.EngineType;
import bg.shengov.garages_manager.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Enumeration;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final VehicleService vehicleService;

    @Override
    public void run(String... args) {

        VehicleFilterDTO someBrand = new VehicleFilterDTO("Some brand", null, null,
                null, null, null, null, null,
                null, null, null, null);

        vehicleService.all(someBrand, Pageable.ofSize(20));
    }


}
