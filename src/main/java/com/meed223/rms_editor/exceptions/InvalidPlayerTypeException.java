package com.meed223.rms_editor.exceptions;

public class InvalidPlayerTypeException extends Exception {
    public InvalidPlayerTypeException() {

    }

    public InvalidPlayerTypeException(String errorMessage) {
        super(errorMessage);
    }
}
