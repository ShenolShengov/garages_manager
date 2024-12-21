package bg.shengov.garages_manager.web.controller;

import bg.shengov.garages_manager.model.dto.PageableResponse;
import bg.shengov.garages_manager.model.dto.VehicleCreateDTO;
import bg.shengov.garages_manager.model.dto.VehicleDetailInfoDTO;
import bg.shengov.garages_manager.model.dto.VehicleFilterDTO;
import bg.shengov.garages_manager.model.entity.Vehicle;
import bg.shengov.garages_manager.service.VehicleService;
import bg.shengov.garages_manager.service.exception.VehicleCreationException;
import bg.shengov.garages_manager.utils.BindingResultUtils;
import bg.shengov.garages_manager.web.ApiError;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<PageableResponse<VehicleDetailInfoDTO>> all(
            @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(name = "page", required = false) Integer ignoredPage,
            @RequestParam(name = "sort", required = false) String ignoredSort,
            @ModelAttribute VehicleFilterDTO filterDTO
    ) {
        return ResponseEntity.ok(vehicleService.all(filterDTO, pageable.previousOrFirst()));
    }

    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody @Valid VehicleCreateDTO createDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new VehicleCreationException("Not valid vehicle data", BindingResultUtils.getErrors(bindingResult));
        }
        return ResponseEntity.ok(vehicleService.create(createDTO));
    }

    @ExceptionHandler(VehicleCreationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ApiError handleCarCreateException(VehicleCreationException e) {
        return new ApiError(e.getMessage(), e.getViolations());
    }
}
