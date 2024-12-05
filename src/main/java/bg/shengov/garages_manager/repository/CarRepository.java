package bg.shengov.garages_manager.repository;

import bg.shengov.garages_manager.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {


}
