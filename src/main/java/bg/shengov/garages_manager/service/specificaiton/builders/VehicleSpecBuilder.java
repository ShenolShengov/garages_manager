package bg.shengov.garages_manager.service.specificaiton.builders;

import bg.shengov.garages_manager.model.entity.Vehicle;
import bg.shengov.garages_manager.model.entity.Vehicle_;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class VehicleSpecBuilder {

    public static Specification<Vehicle> byType(String type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Vehicle_.type), type);
    }

    public static Specification<Vehicle> byBrand(String brand) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Vehicle_.brand), brand);
    }

    public static Specification<Vehicle> byModel(String model) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Vehicle_.model), model);
    }

    public static Specification<Vehicle> byColor(String color) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Vehicle_.color), color);
    }

    public static Specification<Vehicle> byEngine(String engine) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Vehicle_.engine), engine);
    }

    public static Specification<Vehicle> byGearBox(String georBox) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Vehicle_.gearBox), georBox);
    }

    public static Specification<Vehicle> priceInRange(BigDecimal min, BigDecimal max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Vehicle_.price), min, max);
    }

    public static Specification<Vehicle> byMinimumPrice(BigDecimal min) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Vehicle_.price), min);
    }

    public static Specification<Vehicle> byMaximumPrice(BigDecimal max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Vehicle_.price), max);
    }

    public static Specification<Vehicle> yearInRange(Integer min, Integer max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Vehicle_.year), min, max);
    }

    public static Specification<Vehicle> byMinimumYear(Integer min) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Vehicle_.year), min);
    }

    public static Specification<Vehicle> byMaximumYear(Integer max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Vehicle_.year), max);
    }

    public static Specification<Vehicle> horsePowerInRange(BigDecimal min, BigDecimal max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Vehicle_.horsePower), min, max);
    }

    public static Specification<Vehicle> byMinimumHorsePower(BigDecimal min) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get(Vehicle_.horsePower), min);
    }

    public static Specification<Vehicle> byMaximumHorsePower(BigDecimal max) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get(Vehicle_.horsePower), max);
    }
}
