package bg.shengov.garages_manager.model.entity;

import bg.shengov.garages_manager.model.enums.EngineType;
import bg.shengov.garages_manager.model.enums.GearBoxType;
import bg.shengov.garages_manager.model.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private BigDecimal horsePower;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineType engine;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GearBoxType gearBox;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @Override
    public String toString() {
        return """
                Brand: %s
                Model: %s
                Price: %.2f
                Year: %d
                Color: %s
                Horse Power: %.2f
                """.formatted(this.brand, this.model, this.price, this.year, this.color, this.horsePower);
    }
}
