package com.meed223.rms_editor.exceptions;

public class InvalidMapObjectException extends Exception {
    public InvalidMapObjectException() {

    }

    public InvalidMapObjectException(String errorMessage) {
        super (errorMessage);
    }
}
