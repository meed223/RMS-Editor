package com.meed223.rms_editor.elements;

import com.meed223.rms_editor.exceptions.InvalidInputException;

public class MapConst {
    private String name;
    public int id;

    /* Constructor(s) */
    public MapConst(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public MapConst() {
        name = null;
        id = 0;
    }

    /* Hash Code */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = 7 * hash + (name == null ? 0 : name.hashCode());
        hash = 7 * hash + id;
        return hash;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        return "\n#const " + name + " " + id;
    }

    /* Getter & Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidInputException {
        if (name == null || name.length() == 0) {
            throw new InvalidInputException("Invalid name given. Please give a non-null or non-zero length name.");
        } else {
            this.name = name.replaceAll("\\s", "_");
        }
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }
}
