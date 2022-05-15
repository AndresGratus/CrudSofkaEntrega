package co.com.sofka.crud.andres.sofkacrud2.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }
}