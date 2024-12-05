package bg.shengov.garages_manager.model.dto;

import bg.shengov.garages_manager.model.dto.base.VehicleDetailInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class CarDetailInfoDTO extends VehicleDetailInfoDTO implements Serializable {

    private BigDecimal horsePower;
    private String engine;


}
