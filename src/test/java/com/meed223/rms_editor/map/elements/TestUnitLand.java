package com.meed223.rms_editor.map.elements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meed223.rms_editor.exceptions.InvalidInputException;
import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;
import com.meed223.rms_editor.map.GameType;

public class TestUnitLand {
	// Test Consts.
	private Land land;
	private final GameType gameType = GameType.DE;
	private final String terrainType = "GRASS";
	private final int landPercent = 1;
	private final int borderFuzziness = 4;
	private final int zoneAvoidance = 3;
	private final int zone = 1;
    private final Boolean zoneSet = false;
    private final Boolean zoneByTeam = false;
    private final Boolean zoneRandomly = true;
    private final int landId = 1;
    private final int assignToPlayer = 1;
    private final int assignToPlayerAboveBound = 9;
    private final int negative = -1;
    private final Boolean assignToPlayerSet = true;
    private final int clumpingFactor = 5;
    private final int clumpingFactorAboveBound = 16;
    
    @BeforeEach
    void init() {
    	this.land = new Land();
    }
    
    @Test
    void testUpdateGameType() {
    	this.land.updateGameType(this.gameType);
    	assertEquals(this.gameType, this.land.getGameType());
    }
    
    @Test
    void testToString() {
    	// TODO fill in method once method is there
    }
    
    @Test
    void testSetTerrainType() {
    	try {
			this.land.setTerrainType(this.terrainType);
			assertEquals(this.terrainType, this.land.getTerrainType());
		} catch (InvalidTerrainTypeException e) {
			fail("InvalidTerrainTypeException thrown.");
		}   	
    }
    
    @Test
    void testSetLandPercent() {
    	try {
    		this.land.setLandPercent(this.landPercent);
    		assertEquals(this.landPercent, this.land.getLandPercent());
    	} catch (InvalidInputException e) {
    		fail("InvalidInputException thrown.");
    	}
    }
    
    @Test
    void testSetBorderFuzziness() {
    	try {
    		this.land.setBorderFuzziness(this.borderFuzziness);
    		assertEquals(this.borderFuzziness,this.land.getBorderFuzziness());
    	} catch (InvalidInputException e) {
    		fail("InvalidInputException thrown.");
    	}
    }
    
    @Test
    void testSetZoneAvoidance() {
    	try {
    		this.land.setZoneAvoidance(this.zoneAvoidance);
    		assertEquals(this.zoneAvoidance, this.land.getZoneAvoidance());
    	} catch (InvalidInputException e) {
    		fail("InvalidInputException thrown.");
    	}
    }
    
    @Test
    void testSetZoneAvoidanceLowerBound() {
    	try {
    		this.land.setZoneAvoidance(this.negative);
    		fail("InvalidInputException not thrown.");
    	} catch (InvalidInputException e) {
    		return;
    	} catch (Exception e) {
    		fail("Generic Exception thrown. Should throw InvalidInputException.");
    	}
    }
    
    @Test
    void testSetZone() {
    	try {
    		this.land.setZone(this.zone);
    		assertEquals(this.zone, this.land.getZone());
    	} catch (InvalidInputException e) {
    		fail("InvalidInputException thrown.");
    	}
    }
    
    @Test
    void testSetZoneLowerBound() {
    	try {
    		this.land.setZone(this.negative);
    		fail("InvalidInputException not thrown.");
    	} catch (InvalidInputException e) {
    		return;
    	} catch (Exception e) {
    		fail("Generic Exception thrown. Should throw InvalidInputException.");
    	}
    }
    
    @Test
    void testSetLandId() {
    	try {
    		this.land.setLandId(this.landId);
    		assertEquals(this.landId, this.land.getLandId());
    	} catch (InvalidInputException e) {
    		fail("InvalidInputException thrown.");
    	}
    }
    
    @Test
    void testSetAssignToPlayer() {
    	// Test setter functions correctly
    	try {
    		this.land.setAssignToPlayer(this.assignToPlayer);
    		assertEquals(this.assignToPlayer, this.land.getAssignToPlayer());
    	} catch (InvalidInputException e) {
    		fail("InvalidInputException thrown.");
    	} catch (Exception e) {
    		fail("Generic Exception thrown. Should throw InvalidInputException.");
    	}
    }
    
    @Test
    void testSetAssignToPlayerAboveBound() {
    	// Test upper limit of settable values
    	try {
    		this.land.setAssignToPlayer(this.assignToPlayerAboveBound);
    		fail("InvalidInputException not thrown.");
    	} catch (InvalidInputException e) {
    		return;
    	} catch (Exception e) {
    		fail("Generic Exception thrown. Should throw InvalidInputException.");
    	}
    }
    
    @Test
    void testSetAssignToPlayerBelowBound() { 
    	// Test lower limit of settable values
    	try {
    		this.land.setAssignToPlayer(this.negative);
    		fail("InvalidInputException not thrown.");
    	} catch (InvalidInputException e) {
    		return;
    	} catch (Exception e) {
    		fail("Generic Exception thrown. Should throw InvalidInputException.");
    	}
    }
    
    @Test
    void testSetClumpingFactor() {
    	// Test setter functions correclty
    	try {
    		this.land.setClumpingFactor(this.clumpingFactor);
    		assertEquals(this.clumpingFactor, this.land.getClumpingFactor());
    	} catch (InvalidInputException e) {
    		fail("InvalidInputException thrown.");
    	}
    }
    
    @Test
    void testSetClumpingFactorAboveBound() {
    	// Test upper limit of settable values
    	try {
    		this.land.setClumpingFactor(this.clumpingFactorAboveBound);
    		fail("InvalidInputException not thrown.");
    	} catch (InvalidInputException e) {
    		return;
    	} catch (Exception e) {
    		fail("Generic Exception thrown. Should throw InvalidInputException.");
    	}
    }
    
    @Test
    void testSetClumpingFactorBelowBound() {
    	// Test lower limit of settable values
    	try {
    		this.land.setClumpingFactor(this.negative);
    		fail("InvalidInputException not thrown.");
    	} catch (InvalidInputException e) {
    		return;
    	} catch (Exception e) {
    		fail("Generic Exception thrown. Should throw InvalidInputException.");
    	}
    }
}
