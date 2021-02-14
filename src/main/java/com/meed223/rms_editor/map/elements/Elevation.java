package com.meed223.rms_editor.map.elements;

import com.meed223.rms_editor.exceptions.InvalidInputException;
import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
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
   public void setElevation(int elevation) throws InvalidInputException {
        if (elevation <= 0 || elevation > 7) {
            throw new InvalidInputException("Invalid value was given. Elevation expects a value between 1 and 7.");
        } else {
            this.elevation = elevation;
        }
    }

    public void setBaseTerrain(String baseTerrain) throws InvalidTerrainTypeException {
        if (baseTerrain == null || baseTerrain.length() == 0) {
            throw new InvalidTerrainTypeException("Invalid terrain type given. Expected non-null or non-zero (length) type.");
        } else {
            this.baseTerrain = baseTerrain.replaceAll("\\s", "_");
        }
    }

    // TODO check clump size limits
}
