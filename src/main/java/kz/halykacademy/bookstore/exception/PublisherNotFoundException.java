package kz.halykacademy.bookstore.exception;

public class PublisherNotFoundException extends RuntimeException {

    public PublisherNotFoundException(String message) {
        super(message);
    }
}
