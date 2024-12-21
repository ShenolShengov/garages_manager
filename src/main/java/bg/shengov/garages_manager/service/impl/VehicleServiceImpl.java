package bg.shengov.garages_manager.service.impl;

import bg.shengov.garages_manager.model.dto.PageableResponse;
import bg.shengov.garages_manager.model.dto.VehicleCreateDTO;
import bg.shengov.garages_manager.model.dto.VehicleDetailInfoDTO;
import bg.shengov.garages_manager.model.entity.Vehicle;
import bg.shengov.garages_manager.repository.VehicleRepository;
import bg.shengov.garages_manager.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    @Override
    public Vehicle create(VehicleCreateDTO vehicleCreateDTO) {
        return vehicleRepository.save(modelMapper.map(vehicleCreateDTO, Vehicle.class));
    }

    @Override
    public PageableResponse<VehicleDetailInfoDTO> all(Pageable pageable) {
        Page<VehicleDetailInfoDTO> page = vehicleRepository.findAll(pageable)
                .map(e -> modelMapper.map(e, VehicleDetailInfoDTO.class));
        return PageableResponse.from(page);
    }
}
