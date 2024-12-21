package bg.shengov.garages_manager.annotation.validEnum;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ValidEnumValidator implements ConstraintValidator<ValidEnum, String> {

    private Class<? extends Enum<?>> enumType;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        enumType = constraintAnnotation.enumType();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        return Arrays.stream(enumType.getEnumConstants()).map(Enum::name).anyMatch(e -> e.equals(s));
    }
}
