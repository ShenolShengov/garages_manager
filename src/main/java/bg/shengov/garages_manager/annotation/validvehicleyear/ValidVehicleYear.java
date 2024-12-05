package bg.shengov.garages_manager.annotation.validvehicleyear;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidVehicleYearValidator.class)
public @interface ValidVehicleYear {

    String message() default "Year must be after 1800 and not be in future";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
