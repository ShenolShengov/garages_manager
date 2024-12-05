package bg.shengov.garages_manager.model.dto.base;

import bg.shengov.garages_manager.annotation.validvehicleyear.ValidVehicleYear;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Year;

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

}
