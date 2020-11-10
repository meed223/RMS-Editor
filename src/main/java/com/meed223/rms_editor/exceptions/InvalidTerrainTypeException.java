package com.meed223.rms_editor.exceptions;

public class InvalidTerrainTypeException extends Exception {
    public InvalidTerrainTypeException() {

    }

    public InvalidTerrainTypeException(String errorMessage) {
        super(errorMessage);
    }
}
