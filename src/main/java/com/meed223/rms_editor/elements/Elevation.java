package com.meed223.rms_editor.elements;

import com.meed223.rms_editor.exceptions.InvalidInputException;
import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;

public class Elevation {
    private int elevation;
    private String baseTerrain;
    private int numberOfClumps;
    private int numberOfTiles;
    private Boolean scaleByGroups;
    private Boolean scaleBySize;

    /* Constructor(s) */
    public Elevation(int elevation) {
        this.elevation = elevation;
        baseTerrain = null;
        numberOfClumps = 0;
        numberOfTiles = 0;
        scaleByGroups = false;
        scaleBySize = false;
    }

    public Elevation() {
        elevation = 0;
        baseTerrain = null;
        numberOfClumps = 0;
        numberOfTiles = 0;
        scaleByGroups = false;
        scaleBySize = false;
    }

    /* Hash Code */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * 7 + elevation;
        hash = hash * 7 + (baseTerrain == null ? 0 : baseTerrain.hashCode());
        hash = hash * 7 + numberOfClumps;
        hash = hash * 7 + numberOfTiles;
        hash = hash * 7 + scaleByGroups.hashCode();
        hash = hash * 7 + scaleBySize.hashCode();
        return hash;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("\ncreate_elevation    ");
        returnString.append(elevation);
        returnString.append("\n{");
        returnString.append("\n  base_terrain ");
        returnString.append(baseTerrain);
        returnString.append("\n  number_of_clumps ");
        returnString.append(numberOfClumps);
        returnString.append("\n  number_of_tiles ");
        returnString.append(numberOfTiles);
        if (scaleByGroups) {
            returnString.append("\n  set_scale_by_groups");
        }
        if (scaleBySize) {
            returnString.append("\n  set_scale_by_size");
        }
        return returnString.toString();
    }

    /* Getter & Setter Methods */
    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) throws InvalidInputException {
        if (elevation <= 0 || elevation > 7) {
            throw new InvalidInputException("Invalid value was given. Elevation expects a value between 1 and 7.");
        } else {
            this.elevation = elevation;
        }
    }

    public String getBaseTerrain() {
        return baseTerrain;
    }

    public void setBaseTerrain(String baseTerrain) throws InvalidTerrainTypeException {
        if (baseTerrain == null || baseTerrain.length() == 0) {
            throw new InvalidTerrainTypeException("Invalid terrain type given. Expected non-null or non-zero (length) type.");
        } else {
            this.baseTerrain = baseTerrain.replaceAll("\\s", "_");
        }
    }

    public int getNumberOfClumps() {
        return numberOfClumps;
    }

    public void setNumberOfClumps(int numberOfClumps) {
        this.numberOfClumps = numberOfClumps;
    }

    public int getNumberOfTiles() {
        return numberOfTiles;
    }

    public void setNumberOfTiles(int numberOfTiles) {
        this.numberOfTiles = numberOfTiles;
    }

    public boolean getScaleByGroups() {
        return scaleByGroups;
    }

    public void setScaleByGroups(boolean scaleByGroups) {
        this.scaleByGroups = scaleByGroups;
    }

    public boolean getScaleBySize() {
        return scaleBySize;
    }

    public void setScaleBySize(boolean scaleBySize) {
        this.scaleBySize = scaleBySize;
    }
}
