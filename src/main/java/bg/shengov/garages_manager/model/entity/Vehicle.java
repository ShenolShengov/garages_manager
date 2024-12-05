package bg.shengov.garages_manager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

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

    protected Vehicle() {
    }

    public Vehicle(String brand, String model, BigDecimal price, Integer year) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    @Override
    public String toString() {

        return """
    Brand: %s
    Model: %s
    Price: %.2f
    Year: %d
    """.formatted(this.brand, this.model, this.price, this.year);
    }
}
