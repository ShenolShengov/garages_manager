package bg.shengov.garages_manager.service;

import bg.shengov.garages_manager.model.dto.CarCreateDTO;
import bg.shengov.garages_manager.model.dto.CarDetailInfoDTO;
import bg.shengov.garages_manager.model.dto.PageableResponse;
import bg.shengov.garages_manager.model.entity.Car;
import org.springframework.data.domain.Pageable;

public interface CarService {

    Car create(CarCreateDTO carCreateDTO);

    PageableResponse<CarDetailInfoDTO> all(Pageable pageable);
}
