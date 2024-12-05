package bg.shengov.garages_manager.utils;

import bg.shengov.garages_manager.web.FieldViolation;
import org.springframework.validation.BindingResult;

import java.util.List;

public class BindingResultUtils {

    public static List<FieldViolation> getErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream().map(e -> new FieldViolation(e.getField(), e.getDefaultMessage(), e.getRejectedValue()))
                .toList();
    }
}
