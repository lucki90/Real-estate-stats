package pl.luckit.ing.exception;


import static pl.luckit.ing.exception.ExceptionMessageEnum.INVALID_INPUT_MESSAGE;

public class InvalidInputValueException extends Exception {
    public InvalidInputValueException() {
        super(INVALID_INPUT_MESSAGE.getMessage());
    }
}
