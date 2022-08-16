package kz.halykacademy.bookstore.exception;

public class PriceExceededException extends RuntimeException {
    public PriceExceededException(String message) {
        super(message);
    }
}
