package bg.shengov.garages_manager.model.dto;

import bg.shengov.garages_manager.model.enums.EngineType;
import bg.shengov.garages_manager.model.enums.GearBoxType;
import bg.shengov.garages_manager.model.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class VehicleDetailInfoDTO implements Serializable {

    private Long id;
    private String brand;
    private String model;
    private BigDecimal price;
    private Integer year;
    private String color;
    private BigDecimal horsePower;
    private EngineType engine;
    private GearBoxType gearBox;
    private VehicleType type;


}
