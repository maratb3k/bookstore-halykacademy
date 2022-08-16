package kz.halykacademy.bookstore.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {PriceExceededException.class})
    public ResponseEntity<Object> handleApiRequestException(PriceExceededException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(UserNotFoundException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {AuthorNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(AuthorNotFoundException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(BookNotFoundException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UserIsBlockedException.class})
    public ResponseEntity<Object> handleApiRequestException(UserIsBlockedException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {OrderNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(OrderNotFoundException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {PublisherNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(PublisherNotFoundException e) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {GenreNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(GenreNotFoundException e) {
//        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(
//                e.getMessage(),
//                e,
//                HttpStatus.BAD_REQUEST
//        );
        String errorMessageDescription = e.getLocalizedMessage();
        if(errorMessageDescription == null) errorMessageDescription = e.toString();
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(errorMessageDescription, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiExceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
