package com.meed223.rms_editor.elements;

import com.meed223.rms_editor.exceptions.InvalidInputException;

public class MapDefinition {
    private String constName;

    /* Constructor(s) */
    public MapDefinition(String constName) {
        this.constName = constName;
    }

    public MapDefinition() {
        constName = null;
    }

    /* Hash Code */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = 7 * hash + constName.hashCode();
        return hash;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        return "\n#const " + constName;
    }

    /* Getters & Setters */
    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) throws InvalidInputException {
        if (constName == null || constName.length() == 0) {
            throw new InvalidInputException("Invalid constant name given. Please enter a non-null or non-zero length name.");
        } else {
            this.constName = constName.replaceAll("\\s", "_");
        }
    }
}
