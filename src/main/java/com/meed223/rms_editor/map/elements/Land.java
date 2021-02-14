package com.meed223.rms_editor.map.elements;

import com.meed223.rms_editor.exceptions.InvalidInputException;
import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;
import com.meed223.rms_editor.map.GameType;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Land {
	private GameType gameType;
    private String terrainType;
    private int landPercent;
    private int borderFuzziness;
    private int zoneAvoidance;
    private int zone;
    private static Boolean zoneSet; // If one land uses zones, all should
    public Boolean zoneByTeam;
    public Boolean zoneRandomly;
    private int landId; // TODO check if landId can be a string
    private int assignToPlayer;
    private Boolean assignToPlayerSet; // Check whether value has been assigned to write in RMS
    private int clumpingFactor;

    /* Constructor(s) */
    public Land(String terrainType) {
        this.terrainType = terrainType;
        gameType = GameType.DE;
        landPercent = 0;
        borderFuzziness = 0;
        zoneAvoidance = 0;
        zone = 0;
        zoneSet = false;
        zoneByTeam = false;
        zoneRandomly = false;
        landId = 0;
        assignToPlayer = 0;
        assignToPlayerSet = false;
        clumpingFactor = 8; // Default Value
    }

    public Land() {
        terrainType = null;
        gameType = GameType.DE;
        landPercent = 0;
        borderFuzziness = 0;
        zoneAvoidance = 0;
        zone = 0;
        zoneSet = false;
        zoneByTeam = false;
        zoneRandomly = false;
        landId = 0;
        assignToPlayer = 0;
        assignToPlayerSet = false;
        clumpingFactor = 8; // Default Value
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

    /* Convert to RMS */
    @Override
    public String toString() {
    	// TODO implement RMS method
        return "";
    }

    public void setTerrainType(String terrainType) throws InvalidTerrainTypeException {
        if (terrainType == null || terrainType.length() == 0) {
             throw new InvalidTerrainTypeException("Invalid terrain type given. Expected non-null or non-zero (length) type.");
        }
        this.terrainType = terrainType.replaceAll("\\s", "_");
    }

    public void setLandPercent(int landPercent) throws InvalidInputException {
        if (landPercent < 0 || landPercent > 100) {
            throw new InvalidInputException("Invalid value given. Expected value between 0 and 100.");
        } else {
            this.landPercent = landPercent;
        }
    }

    public void setBorderFuzziness(int borderFuzziness) throws InvalidInputException {
        if (borderFuzziness < 0 || borderFuzziness > 100) {
            throw new InvalidInputException("Invalid border-fuzziness value given. Expected value between 0 and 100.");
        } else {
            this.borderFuzziness = borderFuzziness;
        }
    }

    public void setZoneAvoidance(int zoneAvoidance) throws InvalidInputException {
        // TODO set upper bound for no. tiles - using dimensions of 'ludicrous' map size
        if (zoneAvoidance < 0) {
            throw new InvalidInputException("Negative zone-avoidance value. Must be a positive value.");
        } else {
            this.zoneAvoidance = zoneAvoidance;
        }
    }

    public void setZone(int zone) throws InvalidInputException {
        if (zone < 0) {
            throw new InvalidInputException("Negative value for zone id. Must be a positive value.");
        } else {
            this.zone = zone;
        }
    }

    public void setLandId(int landId) throws InvalidInputException {
        if (landId < 0) {
            throw new InvalidInputException("Negative value for land id. Must be a positive value.");
        } else {
            this.landId = landId;
        }
    }

    public void setAssignToPlayer(int assignToPlayer) throws InvalidInputException {
        if (landId <= 0 || landId > 8) {
            throw new InvalidInputException("Invalid player Id. Assign-to-player must be between 1 and 8.");
        } else {
            this.assignToPlayer = assignToPlayer;
            assignToPlayerSet = true;
        }
    }

    public void setClumpingFactor(int clumpingFactor) throws InvalidInputException {
        if (clumpingFactor <= 0 || landId > 15) {
            throw new InvalidInputException("Invalid clumping-factor value. Value must be between 1 and 15.");
        } else {
            this.clumpingFactor = clumpingFactor;
        }
    }
}
