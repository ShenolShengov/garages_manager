package bg.shengov.garages_manager.web;

public record FieldViolation(String field, String message, Object rejectedValue) {
}
