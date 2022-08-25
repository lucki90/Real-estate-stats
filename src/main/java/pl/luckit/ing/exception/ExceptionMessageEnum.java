package pl.luckit.ing.exception;

import lombok.Getter;

public enum ExceptionMessageEnum {

    INVALID_INPUT_MESSAGE_PAGE("Error page: Invalid input values."),
    INVALID_INPUT_MESSAGE("Invalid input values."),
    GENERAL_EXCEPTION_MESSAGE_PAGE("Error page: Internal server error."),
    GENERAL_EXCEPTION_MESSAGE("Internal server error: "),
    INVALID_PATH_MESSAGE_PAGE("Error page: You have probably entered an incorrect values in URL."),
    INVALID_PATH_MESSAGE("Endpoint '/error' was called."),
    EXTERNAL_API_NOT_AVAILABLE_PAGE("Error page: External api is not available."),
    EXTERNAL_API_NOT_AVAILABLE("External api is not available.");

    @Getter
    private final String message;

    ExceptionMessageEnum(String message) {
        this.message = message;
    }

}
