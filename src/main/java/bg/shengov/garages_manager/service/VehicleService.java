package bg.shengov.garages_manager.service;

import bg.shengov.garages_manager.model.dto.PageableResponse;
import bg.shengov.garages_manager.model.dto.VehicleCreateDTO;
import bg.shengov.garages_manager.model.dto.VehicleDetailInfoDTO;
import bg.shengov.garages_manager.model.entity.Vehicle;
import org.springframework.data.domain.Pageable;

public interface VehicleService {

    Vehicle create(VehicleCreateDTO vehicleCreateDTO);

    PageableResponse<VehicleDetailInfoDTO> all(Pageable pageable);
}
