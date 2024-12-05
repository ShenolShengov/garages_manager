package bg.shengov.garages_manager.web;

import java.util.List;

public record ApiError(String reason, List<FieldViolation> violations) {
}
