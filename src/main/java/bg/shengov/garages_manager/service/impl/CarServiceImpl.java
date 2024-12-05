package bg.shengov.garages_manager.service.impl;

import bg.shengov.garages_manager.model.dto.CarCreateDTO;
import bg.shengov.garages_manager.model.dto.CarDetailInfoDTO;
import bg.shengov.garages_manager.model.dto.PageableResponse;
import bg.shengov.garages_manager.model.entity.Car;
import bg.shengov.garages_manager.repository.CarRepository;
import bg.shengov.garages_manager.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car create(CarCreateDTO carCreateDTO) {
        Car created = toCar(carCreateDTO);
        return carRepository.save(created);
    }

    private static Car toCar(CarCreateDTO carCreateDTO) {
        Car created = new Car();
        BeanUtils.copyProperties(carCreateDTO, created);
        return created;
    }

    private static CarDetailInfoDTO toDetailsInfo(Car car) {
        CarDetailInfoDTO carDetailInfoDTO = new CarDetailInfoDTO();
        BeanUtils.copyProperties(car, carDetailInfoDTO);
        return carDetailInfoDTO;
    }

    @Override
    public PageableResponse<CarDetailInfoDTO> all(Pageable pageable) {
        Page<CarDetailInfoDTO> page = carRepository.findAll(pageable).map(CarServiceImpl::toDetailsInfo);
        return PageableResponse.from(page);
//        return Page<CarDetailInfoDTO> all = carRepository.findAll(pageable).map(CarServiceImpl::toDetailsInfo);
//        return new PagedModel<>(all);
    }
}
