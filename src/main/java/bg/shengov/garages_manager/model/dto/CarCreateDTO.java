package bg.shengov.garages_manager.model.dto;

import bg.shengov.garages_manager.model.dto.base.VehicleCreateDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class CarCreateDTO extends VehicleCreateDTO implements Serializable {

    @NotNull
    @Positive
    private BigDecimal horsePower;
    @NotNull
    @Length(min = 5, max = 20)
    private String engine;
}
