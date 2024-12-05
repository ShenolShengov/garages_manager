package bg.shengov.garages_manager.model.dto.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class VehicleDetailInfoDTO implements Serializable {

    private String brand;
    private String model;
    private BigDecimal price;
    private Integer year;


}
