package bg.shengov.garages_manager.service.specificaiton.builders;

import bg.shengov.garages_manager.model.entity.Vehicle;
import org.springframework.data.jpa.domain.Specification;

public class VehicleSpecBuilder {

    public static Specification<Vehicle> byType(String type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type);
    }

}
