package bg.shengov.garages_manager.service.impl;

import bg.shengov.garages_manager.model.dto.CarCreateDTO;
import bg.shengov.garages_manager.model.dto.CarDetailInfoDTO;
import bg.shengov.garages_manager.model.dto.PageableResponse;
import bg.shengov.garages_manager.model.entity.Car;
import bg.shengov.garages_manager.repository.CarRepository;
import bg.shengov.garages_manager.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Override
    public Car create(CarCreateDTO carCreateDTO) {
        return carRepository.save(modelMapper.map(carCreateDTO, Car.class));
    }
    private Function<Car, CarDetailInfoDTO> toDetailsInfo() {
        return e -> modelMapper.map(e, CarDetailInfoDTO.class);
    }

    @Override
    public PageableResponse<CarDetailInfoDTO> all(Pageable pageable) {
        Page<CarDetailInfoDTO> page = carRepository.findAll(pageable).map(toDetailsInfo());
        return PageableResponse.from(page);
    }
}
