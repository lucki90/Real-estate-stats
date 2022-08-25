package pl.luckit.ing.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static pl.luckit.ing.exception.ExceptionMessageEnum.*;

@ControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    @ExceptionHandler(value = InvalidInputValueException.class)
    public ResponseEntity<Object> invalidInputValueException(InvalidInputValueException e) {
        log.error(INVALID_INPUT_MESSAGE.getMessage(), e);
        return new ResponseEntity<>(INVALID_INPUT_MESSAGE_PAGE.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<Object> badRequestException(Exception e) {
        log.error(INVALID_INPUT_MESSAGE.getMessage(), e);
        return new ResponseEntity<>(INVALID_INPUT_MESSAGE_PAGE.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> applicationException(Exception e) {
        log.error(GENERAL_EXCEPTION_MESSAGE.getMessage(), e);
        return new ResponseEntity<>(GENERAL_EXCEPTION_MESSAGE_PAGE.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({
            ResourceAccessException.class,
            HttpClientServerException.class,
            HttpServerErrorException.class
    })
    public ResponseEntity<Object> httpClientUrlNotFoundException(Exception e) {
        log.error(EXTERNAL_API_NOT_AVAILABLE.getMessage(), e);
        return new ResponseEntity<>(EXTERNAL_API_NOT_AVAILABLE_PAGE.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
