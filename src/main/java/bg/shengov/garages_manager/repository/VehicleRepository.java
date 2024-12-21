package bg.shengov.garages_manager.repository;

import bg.shengov.garages_manager.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
