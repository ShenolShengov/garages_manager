package bg.shengov.garages_manager.service.impl;

import bg.shengov.garages_manager.model.dto.PageableResponse;
import bg.shengov.garages_manager.model.dto.VehicleCreateDTO;
import bg.shengov.garages_manager.model.dto.VehicleDetailInfoDTO;
import bg.shengov.garages_manager.model.dto.VehicleFilterDTO;
import bg.shengov.garages_manager.model.entity.Vehicle;
import bg.shengov.garages_manager.repository.VehicleRepository;
import bg.shengov.garages_manager.service.VehicleService;
import bg.shengov.garages_manager.service.specificaiton.SpecificationService;
import bg.shengov.garages_manager.service.specificaiton.builders.VehicleSpecBuilder;
import bg.shengov.garages_manager.service.specificaiton.filter.CompoundFilter;
import bg.shengov.garages_manager.service.specificaiton.filter.FilterCriteria;
import bg.shengov.garages_manager.service.specificaiton.filter.SimpleFilter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;
    private final SpecificationService<Vehicle> specificationService;

    @Override
    public Vehicle create(VehicleCreateDTO vehicleCreateDTO) {
        return vehicleRepository.save(modelMapper.map(vehicleCreateDTO, Vehicle.class));
    }

    @Override
    public PageableResponse<VehicleDetailInfoDTO> all(VehicleFilterDTO filterDTO, Pageable pageable) {
        specificationService.clearSpecifications();

        buildFilters(filterDTO)
                .map(FilterCriteria::toSpecification)
                .flatMap(Optional::stream)
                .forEach(specificationService::addSpecification);

        Specification<Vehicle> combineSpecifications = specificationService.combineSpecifications();
        Page<VehicleDetailInfoDTO> page = vehicleRepository.findAll(combineSpecifications, pageable)
                .map(e -> modelMapper.map(e, VehicleDetailInfoDTO.class));
        return PageableResponse.from(page);
    }

    private static Stream<FilterCriteria<Vehicle>> buildFilters(VehicleFilterDTO filterDTO) {
        return Stream.of(
                new SimpleFilter<>(filterDTO.brand(), VehicleSpecBuilder::byBrand),
                new SimpleFilter<>(filterDTO.model(), VehicleSpecBuilder::byModel),
                new SimpleFilter<>(filterDTO.color(), VehicleSpecBuilder::byColor),
                new SimpleFilter<>(filterDTO.engine(), VehicleSpecBuilder::byEngine),
                new SimpleFilter<>(filterDTO.gearBox(), VehicleSpecBuilder::byGearBox),
                new SimpleFilter<>(filterDTO.type(), VehicleSpecBuilder::byType),
                new CompoundFilter<>(filterDTO.minYear(), filterDTO.maxYear(), VehicleSpecBuilder::yearInRange,
                        VehicleSpecBuilder::byMinimumYear, VehicleSpecBuilder::byMaximumYear),
                new CompoundFilter<>(filterDTO.minPrice(), filterDTO.maxPrice(), VehicleSpecBuilder::priceInRange,
                        VehicleSpecBuilder::byMinimumPrice, VehicleSpecBuilder::byMaximumPrice),
                new CompoundFilter<>(filterDTO.minHorsePower(), filterDTO.maxHorsePower(),
                        VehicleSpecBuilder::horsePowerInRange,
                        VehicleSpecBuilder::byMinimumHorsePower, VehicleSpecBuilder::byMaximumHorsePower)
        );
    }
}
