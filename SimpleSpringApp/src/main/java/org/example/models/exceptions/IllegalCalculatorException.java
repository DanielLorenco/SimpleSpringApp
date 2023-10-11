package org.example.models.exceptions;

public class IllegalCalculatorException extends RuntimeException {

    /**
     * Class for catching calculator exception
     */
    public IllegalCalculatorException(String message) {
        super(message);
    }
}
