package com.meed223.rms_editor.exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException() {

    }

    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}
