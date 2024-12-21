package bg.shengov.garages_manager.model.dto;

import bg.shengov.garages_manager.annotation.validEnum.ValidEnum;
import bg.shengov.garages_manager.annotation.validvehicleyear.ValidVehicleYear;
import bg.shengov.garages_manager.model.enums.EngineType;
import bg.shengov.garages_manager.model.enums.GearBoxType;
import bg.shengov.garages_manager.model.enums.VehicleType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class VehicleCreateDTO implements Serializable {

    @NotNull
    @Length(min = 2, max = 20)
    private String brand;
    @NotNull
    @Length(min = 2, max = 20)
    private String model;
    @NotNull
    @Positive
    private BigDecimal price;
    @ValidVehicleYear
    private Integer year;
    @NotNull
    @Length(min = 3, max = 20)
    private String color;
    @NotNull
    @DecimalMin(value = "20")
    @DecimalMax("1000")
    private BigDecimal horsePower;
    @ValidEnum(enumType = EngineType.class)
    private String engine;
    @ValidEnum(enumType = GearBoxType.class)
    private String gearBox;
    @ValidEnum(enumType = VehicleType.class)
    private String type;


}
