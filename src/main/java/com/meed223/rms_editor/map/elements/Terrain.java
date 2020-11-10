package com.meed223.rms_editor.map.elements;

import com.meed223.rms_editor.exceptions.InvalidInputException;
import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;
import com.meed223.rms_editor.map.GameType;

public class Terrain {
	private GameType gameType;
    private String terrainType;
    private String baseTerrain;
    private int baseSize;
    private int spacingToOtherTerrains;
    private int numberClumps;
    private int clumpingFactor;
    private int borderFuzziness;
    private int otherZoneAvoidance;
    private int landPercent;
    private int leftBorder;
    private int rightBorder;
    private int topBorder;
    private int bottomBorder;
    private int heightLimit;
    private Boolean bordersSet;
    public Boolean scaleByGroups;
    public Boolean avoidPlayerAreas;
    public Boolean flatAreasOnly;

    /* Constructors */
    public Terrain(String terrainType) {
        this.terrainType = terrainType;
        this.gameType = GameType.DE;
        baseTerrain = null;
        baseSize = 0;
        spacingToOtherTerrains = 0;
        numberClumps = 0;
        clumpingFactor = 20; // Default Value
        borderFuzziness = 0;
        otherZoneAvoidance = 0;
        landPercent = 0;
        leftBorder = 0;
        rightBorder = 0;
        topBorder = 0;
        bottomBorder = 0;
        heightLimit = 0;
        bordersSet = false;
        scaleByGroups = false;
        avoidPlayerAreas = false;
    }

    public Terrain() {
        this.terrainType = null;
        this.gameType = GameType.DE;
        baseTerrain = null;        
        baseSize = 0;
        spacingToOtherTerrains = 0;
        numberClumps = 0;
        clumpingFactor = 20; // Default Value
        borderFuzziness = 0;
        otherZoneAvoidance = 0;
        landPercent = 0;
        leftBorder = 0;
        rightBorder = 0;
        topBorder = 0;
        bottomBorder = 0;
        heightLimit = 0;
        bordersSet = false;
        scaleByGroups = false;
        avoidPlayerAreas = false;
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
        hash = 7 * hash + (terrainType == null ? 0 : terrainType.hashCode());
        hash = 7 * hash + (baseTerrain == null ? 0 : baseTerrain.hashCode());
        hash = 7 * hash + baseSize;
        hash = 7 * hash + spacingToOtherTerrains;
        hash = 7 * hash + numberClumps;
        hash = 7 * hash + borderFuzziness;
        hash = 7 * hash + otherZoneAvoidance;
        hash = 7 * hash + landPercent;
        hash = 7 * hash + leftBorder;
        hash = 7 * hash + rightBorder;
        hash = 7 * hash + topBorder;
        hash = 7 * hash + bottomBorder;
        hash = 7 * hash + bordersSet.hashCode();
        hash = 7 * hash + scaleByGroups.hashCode();
        hash = 7 * hash + avoidPlayerAreas.hashCode();
        return hash;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("create_land");
        returnString.append("\n{");
        returnString.append("\n  base_terrain ");
        returnString.append(terrainType);
        returnString.append("\n  spacing_to_other_terrain_types ");
        returnString.append(spacingToOtherTerrains);
        returnString.append("\n  land_percent ");
        returnString.append(landPercent);
        returnString.append("\n  number_of_clumps");
        returnString.append(numberClumps);
        if (avoidPlayerAreas) {
            returnString.append("\n  set_avoid_player_start_areas");
        }
        if (scaleByGroups) {
            returnString.append("\n  set_scale_by_groups");
        }
        if (flatAreasOnly) {
            returnString.append("\n set_flat_areas_only");
        }
        returnString.append("\n   borderFuzziness ");
        returnString.append(borderFuzziness);
        returnString.append("\n}");
        return returnString.toString();
    }

    /* Getters & Setters */
    public String getTerrainType() {
        return terrainType;
    }

    public  void setTerrainType(String terrainType) throws InvalidTerrainTypeException {
        if (terrainType == null) {
            throw new InvalidTerrainTypeException("Null value given for terrain type. Non-null value expected.");
        } else {
            this.terrainType = terrainType.replaceAll("\\s", "_");
        }
    }

    public String getBaseTerrain() {
        return baseTerrain;
    }

    public void setBaseTerrain(String baseTerrain) throws InvalidTerrainTypeException {
        if (baseTerrain == null) {
            throw new InvalidTerrainTypeException("Null value given for base-terrain type. Non-null value expected.");
        } else {
            this.baseTerrain = baseTerrain.replaceAll("\\s", "_");
        }
    }

    public int getBaseSize() {
        return baseSize;
    }

    public void setBaseSize(int baseSize) {
        this.baseSize = baseSize;
    }

    public int getHeightLimit() {
        return heightLimit;
    }

    public void setHeightLimit(int heightLimit) throws InvalidInputException {
        if (heightLimit < 0 || heightLimit > 7) {
            throw new InvalidInputException("Invalid height-limit value. Expected a value between 0 and 7");
        } else {
            this.heightLimit = heightLimit;
        }
    }

    public int getClumpingFactor() {
        return clumpingFactor;
    }

    public void setClumpingFactor(int clumpingFactor) throws InvalidInputException {
        if (clumpingFactor < 0 || clumpingFactor > 100) {
            throw new InvalidInputException("Invalid clumping-factor value. Expected a value between 0 and 100");
        } else {
            this.clumpingFactor = clumpingFactor;
        }
    }

    public int getSpacingToOtherTerrains() {
        return spacingToOtherTerrains;
    }

    public void setSpacingToOtherTerrains(int spacingToOtherTerrains) {
        this.spacingToOtherTerrains = spacingToOtherTerrains;
    }

    public int getNumberClumps() {
        return numberClumps;
    }

    public void setNumberClumps(int numberClumps) {
        this.numberClumps = numberClumps;
    }

    public int getBorderFuzziness() {
        return borderFuzziness;
    }

    public void setBorderFuzziness(int borderFuzziness) {
        this.borderFuzziness = borderFuzziness;
    }

    public int getOtherZoneAvoidance() {
        return otherZoneAvoidance;
    }

    public void setOtherZoneAvoidance(int otherZoneAvoidance) {
        this.otherZoneAvoidance = otherZoneAvoidance;
    }

    public int getLandPercent() {
        return landPercent;
    }

    public void setLandPercent(int landPercent) {
        this.landPercent = landPercent;
    }

    public int getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(int leftBorder) {
        this.leftBorder = leftBorder;
        bordersSet = true;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
        bordersSet = true;
    }

    public int getTopBorder() {
        return topBorder;
    }

    public void setTopBorder(int topBorder) {
        this.topBorder = topBorder;
        bordersSet = true;
    }

    public int getBottomBorder() {
        return bottomBorder;
    }

    public void setBottomBorder(int bottomBorder) {
        this.bottomBorder = bottomBorder;
        bordersSet = true;
    }

    public boolean getScaleByGroups() {
        return scaleByGroups;
    }
}
