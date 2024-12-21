package bg.shengov.garages_manager.annotation.validEnum;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidEnumValidator.class)
public @interface ValidEnum {

    Class<? extends Enum<?>> enumType();

    String message() default "Not valid vale for the specify field";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
