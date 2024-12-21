package bg.shengov.garages_manager.service.exception;

import bg.shengov.garages_manager.web.FieldViolation;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class VehicleCreationException extends RuntimeException {

    private final List<FieldViolation> violations;

    public VehicleCreationException(String message, List<FieldViolation> violations) {
        super(message);
        this.violations = violations;
    }
}
