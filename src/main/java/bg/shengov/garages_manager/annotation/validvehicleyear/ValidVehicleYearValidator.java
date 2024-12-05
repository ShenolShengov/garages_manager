package bg.shengov.garages_manager.annotation.validvehicleyear;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class ValidVehicleYearValidator implements ConstraintValidator<ValidVehicleYear, Integer> {

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext context) {
        if(year == null) return false;
        return year >= 1800 && year <= LocalDate.now().getYear();
    }
}
