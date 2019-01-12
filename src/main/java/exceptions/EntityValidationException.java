package exceptions;

public class EntityValidationException extends RuntimeException {
    public EntityValidationException() {
        super("*** Entity Validation Error ***");
    }

    public EntityValidationException(String message) {
        super(message);
    }
}
