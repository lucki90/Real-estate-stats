package pl.luckit.ing.exception;

import static pl.luckit.ing.exception.ExceptionMessageEnum.EXTERNAL_API_NOT_AVAILABLE;

public class HttpClientServerException extends RuntimeException {

    public HttpClientServerException() {
        super(EXTERNAL_API_NOT_AVAILABLE.getMessage());
    }
}
