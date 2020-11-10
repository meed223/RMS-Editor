package com.meed223.rms_editor.elements;

import com.meed223.rms_editor.exceptions.InvalidInputException;
import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;

public class Land {
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

    /* Hash Code */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = 7 * hash + (terrainType == null ? 0 : terrainType.hashCode());
        hash = 7 * hash + landPercent;
        hash = 7 * hash + borderFuzziness;
        hash = 7 * hash + zoneAvoidance;
        hash = 7 * hash + zone;
        hash = 7 * hash + zoneSet.hashCode();
        hash = 7 * hash + zoneByTeam.hashCode();
        hash = 7 * hash + zoneRandomly.hashCode();
        hash = 7 * hash + landId;
        hash = 7 * hash + assignToPlayer;
        hash = 7 * hash + assignToPlayerSet.hashCode();
        hash = 7 * hash + clumpingFactor;
        return hash;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        return "";
    }


    /* Getters & Setters */
    public String getTerrainType() {
        return terrainType;
    }

    public void setTerrainType(String terrainType) throws InvalidTerrainTypeException {
        if (terrainType == null || terrainType.length() == 0) {
             throw new InvalidTerrainTypeException("Invalid terrain type given. Expected non-null or non-zero (length) type.");
        }
        this.terrainType = terrainType.replaceAll("\\s", "_");
    }

    public int getLandPercent() {
        return landPercent;
    }

    public void setLandPercent(int landPercent) throws InvalidInputException {
        if (landPercent < 0 || landPercent > 100) {
            throw new InvalidInputException("Invalid value given. Expected value between 0 and 100.");
        } else {
            this.landPercent = landPercent;
        }
    }

    public int getBorderFuzziness() {
        return borderFuzziness;
    }

    public void setBorderFuzziness(int borderFuzziness) throws InvalidInputException {
        if (borderFuzziness < 0 || borderFuzziness > 100) {
            throw new InvalidInputException("Invalid border-fuzziness value given. Expected value between 0 and 100.");
        } else {
            this.borderFuzziness = borderFuzziness;
        }
    }

    public int getZoneAvoidance() { return zoneAvoidance; }

    public void setZoneAvoidance(int zoneAvoidance) throws InvalidInputException {
        // TODO set upper bound for no. tiles - using dimensions of 'ludicrous' map size
        if (zoneAvoidance < 0) {
            throw new InvalidInputException("Negative zone-avoidance value. Must be a positive value.");
        } else {
            this.zoneAvoidance = zoneAvoidance;
        }
    }

    public int getZone() { return zone; }

    public void setZone(int zone) throws InvalidInputException {
        if (zone < 0) {
            throw new InvalidInputException("Negative value for zone id. Must be a positive value.");
        } else {
            this.zone = zone;
        }
    }

    public int getLandId() { return landId; }

    public void setLandId(int landId) throws InvalidInputException {
        if (landId < 0) {
            throw new InvalidInputException("Negative value for land id. Must be a positive value.");
        } else {
            this.landId = landId;
        }
    }

    public int getAssignToPlayer() { return assignToPlayer; }

    public void setAssignToPlayer(int assignToPlayer) throws InvalidInputException {
        if (landId <= 0 || landId > 8) {
            throw new InvalidInputException("Invalid player Id. Assign-to-player must be between 1 and 8.");
        } else {
            this.assignToPlayer = assignToPlayer;
            assignToPlayerSet = true;
        }
    }

    public int getClumpingFactor() { return clumpingFactor; }

    public void setClumpingFactor(int clumpingFactor) throws InvalidInputException {
        if (clumpingFactor <= 0 || landId > 15) {
            throw new InvalidInputException("Invalid clumping-factor value. Value must be between 1 and 15.");
        } else {
            this.clumpingFactor = clumpingFactor;
        }
    }
}
