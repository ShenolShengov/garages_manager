package bg.shengov.garages_manager.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public record VehicleFilterDTO(String brand,
                               String model,
                               BigDecimal minPrice,
                               BigDecimal maxPrice,
                               Integer minYear,
                               Integer maxYear,
                               String color,
                               BigDecimal minHorsePower,
                               BigDecimal maxHorsePower,
                               String engine,
                               String gearBox,
                               String type) implements Serializable {

}
