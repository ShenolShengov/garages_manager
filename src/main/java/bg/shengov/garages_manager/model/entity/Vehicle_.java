package bg.shengov.garages_manager.model.entity;

import bg.shengov.garages_manager.model.enums.EngineType;
import bg.shengov.garages_manager.model.enums.GearBoxType;
import bg.shengov.garages_manager.model.enums.VehicleType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.math.BigDecimal;

@StaticMetamodel(Vehicle.class)
public class Vehicle_ {

    public static volatile SingularAttribute<Vehicle, String> brand;
    public static volatile SingularAttribute<Vehicle, String> model;
    public static volatile SingularAttribute<Vehicle, BigDecimal> price;
    public static volatile SingularAttribute<Vehicle, Integer> year;
    public static volatile SingularAttribute<Vehicle, String> color;
    public static volatile SingularAttribute<Vehicle, BigDecimal> horsePower;
    public static volatile SingularAttribute<Vehicle, EngineType> engine;
    public static volatile SingularAttribute<Vehicle, GearBoxType> gearBox;
    public static volatile SingularAttribute<Vehicle, VehicleType> type;
}
