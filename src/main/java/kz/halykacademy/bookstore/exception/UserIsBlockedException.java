package kz.halykacademy.bookstore.exception;

public class UserIsBlockedException extends RuntimeException {

    public UserIsBlockedException(String message) {
        super(message);
    }
}
