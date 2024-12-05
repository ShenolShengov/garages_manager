package bg.shengov.garages_manager.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "cars")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Car extends Vehicle {

    @Column(nullable = false)
    private BigDecimal horsePower;
    @Column(nullable = false)
    private String engine;

    public Car(String brand, String model, BigDecimal price, Integer year, BigDecimal horsePower, String engine) {
        super(brand, model, price, year);
        this.horsePower = horsePower;
        this.engine = engine;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return super.toString() + """
                HorsePower: %.2f
                Engine: %s
                """.formatted(this.horsePower, this.engine);
    }
}
