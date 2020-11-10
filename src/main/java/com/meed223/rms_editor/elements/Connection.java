package com.meed223.rms_editor.elements;

import com.meed223.rms_editor.exceptions.InvalidInputException;
import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;

public class Connection {
    private String baseTerrain;
    private String replacementTerrain;
    private int terrainCost;

    /* Constructor(s) */
    public Connection(String baseTerrain) {
        this.baseTerrain = baseTerrain;
        replacementTerrain = null;
        terrainCost = 0;
    }

    public Connection() {
        baseTerrain = null;
        replacementTerrain = null;
        terrainCost = 0;
    }

    /* Hash Code */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * 7 + (baseTerrain == null ? 0 : baseTerrain.hashCode());
        hash = hash * 7 + (replacementTerrain == null ? 0 : replacementTerrain.hashCode());
        hash = hash * 7 + terrainCost;
        return hash;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        return "\n  replace_terrain  " +
                baseTerrain +
                "    " +
                replacementTerrain +
                "\n  terrain_cost  " +
                baseTerrain +
                "    " +
                terrainCost;
    }

    /* Getters & Setters */
    public String getBaseTerrain() {
        return baseTerrain;
    }

    public void setBaseTerrain(String baseTerrain) throws InvalidTerrainTypeException {
        if (baseTerrain == null || baseTerrain.length() == 0) {
            throw new InvalidTerrainTypeException("Invalid terrain type given. Expected non-null or non-zero (length) type.");
        }
        this.baseTerrain = baseTerrain.replaceAll("\\s", "_");
    }

    public String getReplacementTerrain() {
        return replacementTerrain;
    }

    public void setReplacementTerrain(String replacementTerrain) throws InvalidTerrainTypeException {
        if (replacementTerrain == null || replacementTerrain.length() == 0) {
            throw new InvalidTerrainTypeException("Invalid terrain type given. Expected non-null or non-zero (length) type.");
        }
        this.replacementTerrain = replacementTerrain.replaceAll("\\s", "_");
    }

    public int getTerrainCost() {
        return terrainCost;
    }

    public void setTerrainCost(int terrainCost) throws InvalidInputException {
        if (terrainCost < 0 || terrainCost > 15) {
            throw new InvalidInputException("Invalid input given. Expected a value between 0 and 15.");
        }
        this.terrainCost = terrainCost;
    }
}
