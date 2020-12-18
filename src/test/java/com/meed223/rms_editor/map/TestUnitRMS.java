package com.meed223.rms_editor.map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUnitRMS {
	// Test Consts:
	private RMS mapScript;
	
	// Test(s) Setup
	@BeforeEach
	void init() {
		this.mapScript = new RMS();
	}

	// Tests
	@Test
	void testConstructor() {
		RMS newMapScript = null;
		newMapScript = new RMS();
		
		assertFalse(newMapScript == null);
	}
	
	@Test
	void testUpdateGameType() {
		this.mapScript.updateGameType(GameType.HD);
		
		assertTrue(this.mapScript.getGame() == GameType.HD);
	}
	
	@Test
	void testAddNewTerrainConst() {
		
	}
	
	@Test
	void testUpdateTerrainConst() {
		
	}
	
	@Test
	void testDeleteTerrainConst() {
		
	}
	
	@Test
	void testGetTerrainConsts() {
		
	}
	
	@Test
	void testTerrainConstExists() {
		
	}
	
	@Test
	void testAddNewObjectConst() {
		
	}
	
	@Test
	void testupdateObjectConst() {
		
	}
	
	@Test
	void testDeleteObjectConst() {
		
	}
	
	@Test
	void testGetObjectConsts() {
		
	}
	
	@Test
	void testObjectConstExists() {
		
	}
	
	@Test
	void testToString() {
		
	}
}
