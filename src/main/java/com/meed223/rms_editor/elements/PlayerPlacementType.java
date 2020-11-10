package com.meed223.rms_editor.elements;

public enum PlayerPlacementType {
    RANDOM ("random_placement");

    private final String placementType;
    PlayerPlacementType(String placementType) {
        this.placementType = placementType;
    }

    public String getPlacementType() {
        return placementType;
    }
}
