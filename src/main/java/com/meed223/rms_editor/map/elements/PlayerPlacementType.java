package com.meed223.rms_editor.map.elements;

public enum PlayerPlacementType {
    RANDOM ("random_placement"),
	DIRECT ("direct_placement"),
	GROUPED ("grouped_by_team");

    private final String placementType;
    PlayerPlacementType(String placementType) {
        this.placementType = placementType;
    }

    public String getPlacementType() {
        return placementType;
    }
}
