package com.meed223.rms_editor.elements;

public class Player {

    private PlayerPlacementType type;

    /* Constructor(s) */
    public Player() {
        type = PlayerPlacementType.RANDOM;
    }

    /* Hash Code */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = 7 * hash + (type == null ? 0 : type.hashCode());
        return hash;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        return "<PLAYER_SETUP>\n" + type.getPlacementType();
    }

    /* Getters & Setters */
    public PlayerPlacementType getType() {
        return type;
    }

    public void setPlacementType(PlayerPlacementType type) {
        // TODO - remove or repurpose InvalidPlayerTypeException
        this.type = type;
    }
}
