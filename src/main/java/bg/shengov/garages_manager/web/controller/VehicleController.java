package bg.shengov.garages_manager.web.controller;

import bg.shengov.garages_manager.model.dto.PageableResponse;
import bg.shengov.garages_manager.service.CarService;
import bg.shengov.garages_manager.service.exception.CarCreateException;
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
@RequestMapping("/cars")
@RequiredArgsConstructor
public class VehicleController {

    private final CarService carService;
//
//    @GetMapping
//    public ResponseEntity<PageableResponse<CarDetailInfoDTO>> all(
//            @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
//            @RequestParam(name = "page", required = false) Integer ignoredPage,
//            @RequestParam(name = "sort", required = false) String ignoredSort
////            @RequestParam(name = "direction", required = false) String ignoredDirection
//    ) {
//        return ResponseEntity.ok(carService.all(pageable.previousOrFirst()));
//    }
//
//    @PostMapping
//    public ResponseEntity<Car> create(@RequestBody @Valid CarCreateDTO createDTO, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//
//            throw new CarCreateException("Not valid car data", BindingResultUtils.getErrors(bindingResult));
//        }
//        return ResponseEntity.ok(carService.create(createDTO));
//    }
//
//    @ExceptionHandler(CarCreateException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    private ApiError handleCarCreateException(CarCreateException e) {
//        return new ApiError(e.getMessage(), e.getViolations());
//    }
}
