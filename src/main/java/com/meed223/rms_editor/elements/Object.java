package com.meed223.rms_editor.elements;

import com.meed223.rms_editor.exceptions.InvalidMapObjectException;
import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;

public class Object {
    private String objectName;
    private GameType gameType;
    private String terrainToPlace;
    private int numberObjects;
    private int groupVariance;
    private int groupPlacementRadius;
    public Boolean looseGrouping;
    public Boolean gaiaObject;
    public Boolean placeForEveryPlayer;
    public Boolean scaleToMap;
    private int minPlayerDistance;
    private int maxPlayerDistance;
    private int minGroupDistance;

    /* Constructor(s) */
    public Object(String objectName) {
        this.objectName = objectName;
        this.gameType = GameType.DE;
        numberObjects = 0;
        groupVariance = 0;
        groupPlacementRadius = 0;
        looseGrouping = false;
        gaiaObject = false;
        placeForEveryPlayer = false;
        minPlayerDistance = 0;
        maxPlayerDistance = 0;
        minGroupDistance = 0;
    }

    public Object() {
        this.objectName = null;
        this.gameType = GameType.DE;
        numberObjects = 0;
        groupVariance = 0;
        groupPlacementRadius = 0;
        looseGrouping = false;
        gaiaObject = false;
        placeForEveryPlayer = false;
        minPlayerDistance = 0;
        maxPlayerDistance = 0;
        minGroupDistance = 0;
    }

    /* Update Game Type */
    public void updateGameType(GameType type) {
    	if (this.gameType == type) {
    		return;
    	}
    	
    	// TODO implement checks
    	switch(type) {
    	case DE:
    		this.gameType = GameType.DE;
    		break;
    	case HD:
    		this.gameType = GameType.HD;
    		break;
    	case AOC:
    		this.gameType = GameType.AOC;
    		break;
    	default:
    		this.gameType = GameType.DE;
    	}
    }
    
    /* Hash Code */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * 7 + (objectName == null ? 0 : objectName.hashCode());
        hash = hash * 7 + (terrainToPlace == null ? 0 : terrainToPlace.hashCode());
        hash = hash * 7 + numberObjects;
        hash = hash * 7 + groupVariance;
        hash = hash * 7 + groupPlacementRadius;
        hash = hash * 7 + looseGrouping.hashCode();
        hash = hash * 7 + gaiaObject.hashCode();
        hash = hash * 7 + placeForEveryPlayer.hashCode();
        hash = hash * 7 + scaleToMap.hashCode();
        hash = hash * 7 + minPlayerDistance;
        hash = hash * 7 + maxPlayerDistance;
        hash = hash * 7 + minGroupDistance;
        return hash;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("\n");
        returnString.append(objectName);
        returnString.append("\n{");
        returnString.append("\n    number_of_objects ");
        returnString.append(numberObjects);
        returnString.append("\n    terrain_to_place_on ");
        returnString.append(terrainToPlace);
        returnString.append("\n    group_variance ");
        returnString.append(groupVariance);
        returnString.append("\n    group_placement_radius ");
        returnString.append(groupPlacementRadius);
        if (looseGrouping) {
            returnString.append("\n    set_loose_grouping");
        }
        if (gaiaObject) {
            returnString.append("\n    set_gaia_object_only");
        }
        if (placeForEveryPlayer) {
            returnString.append("\n    set_place_for_every_player");
        }
        if (scaleToMap) {
            returnString.append("\n    set_scaling_to_map_size");
        }
        returnString.append("\n    min_distance_to_players ");
        returnString.append(minPlayerDistance);
        returnString.append("\n    max_distance_to_players ");
        returnString.append(maxPlayerDistance);
        returnString.append("\n    min_distance_group_placement ");
        returnString.append(minGroupDistance);
        returnString.append("\n}");
        return returnString.toString();
    }

    /* Getter & Setter Methods */
    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) throws InvalidMapObjectException {
        if (objectName == null) {
            throw new InvalidMapObjectException("Null value given for object name. Non-null value expected.");
        } else {
            this.objectName = objectName.replaceAll("\\s", "_");
        }
    }

    public int getNumberObjects() {
        return numberObjects;
    }

    public void setNumberObjects(int numberObjects) {
        this.numberObjects = numberObjects;
    }

    public String getTerrainToPlace() {
        return terrainToPlace;
    }

    public void setTerrainToPlace(String terrainToPlace) throws InvalidTerrainTypeException {
        if (terrainToPlace == null || terrainToPlace.length() == 0) {
            throw new InvalidTerrainTypeException("Invalid terrain type given. Expected non-null or non-zero (length) type.");
        } else {
            this.terrainToPlace = terrainToPlace.replaceAll("\\s", "_");
        }
    }

    public int getGroupVariance() {
        return groupVariance;
    }

    public void setGroupVariance(int groupVariance) {
        this.groupVariance = groupVariance;
    }

    public int getGroupPlacementRadius() {
        return groupPlacementRadius;
    }

    public void setGroupPlacementRadius(int groupPlacementRadius) {
        this.groupPlacementRadius = groupPlacementRadius;
    }

    public void setScaleToMap(boolean scaleToMap) {
        this.scaleToMap = scaleToMap;
    }

    public int getMinPlayerDistance() {
        return minPlayerDistance;
    }

    public void setMinPlayerDistance(int minPlayerDistance) {
        this.minPlayerDistance = minPlayerDistance;
    }

    public int getMaxPlayerDistance() {
        return maxPlayerDistance;
    }

    public void setMaxPlayerDistance(int maxPlayerDistance) {
        this.maxPlayerDistance = maxPlayerDistance;
    }

    public int getMinGroupDistance() {
        return minGroupDistance;
    }

    public void setMinGroupDistance(int minGroupDistance) {
        this.minGroupDistance = minGroupDistance;
    }
}
