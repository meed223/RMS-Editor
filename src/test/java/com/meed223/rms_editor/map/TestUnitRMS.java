package com.meed223.rms_editor.map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;

public class TestUnitRMS {
	// Test Consts:
	private RMS mapScript;
	private Long id = 1L;
	private String exampleConst = "example";
	
	// Test(s) Setup
	@BeforeEach
	void init() {
		this.mapScript = new RMS();
		try {
			this.mapScript.addNewTerrainConst(id, exampleConst);
		} catch (InvalidTerrainTypeException e) {
			System.out.println("Error adding constant in test initialisation!");
		}
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
		Long newId = 2L;
		String newName = "example_const";
		Map<String, Long> before = this.mapScript.getTerrainDefs();
		try {
			// Add new constant
			this.mapScript.addNewTerrainConst(newId, newName);
			
			// Test to ensure that it has been added
			Map<String, Long> after = this.mapScript.getTerrainDefs();
			assertFalse(before == after);
			assertTrue(after.containsKey(newName));
			assertTrue(after.get(newName) == newId);
		} catch (InvalidTerrainTypeException e) {
			fail("InvalidTerrainTypeException thrown.");
		}
	}
	
	// TODO add test-case for exception throwing
	
	@Test
	void testUpdateTerrainConst() {
		Long newId = 2L;
		try {
			this.mapScript.updateTerrainConst(newId, this.exampleConst);
			assertTrue(this.mapScript.getTerrainDefs().containsKey(this.exampleConst));
			assertTrue(this.mapScript.getTerrainDefs().get(this.exampleConst) == this.id);
		} catch (InvalidTerrainTypeException e) {
			fail("InvalidTerrainTypeException thrown.");
		}
	}
	
	// TODO add test-case for non-existent Id
	// TODO add test-case for exception throwing
	
	@Test
	void testDeleteTerrainConst() {
		this.mapScript.deleteTerrainConst(exampleConst);
		
		// Assert that the map is now empty (should have only been one entry)
		assertTrue(this.mapScript.getTerrainDefs().size() == 0);
	}
	
	@Test
	void testGetTerrainConsts() {
		List<String> consts = this.mapScript.getTerrainConsts();
		
		// Assert  no additional entries have been added 
		assertTrue(consts.size() == 1);
		assertTrue(consts.get(0) == this.exampleConst);
	}
	
	@Test
	void testTerrainConstExists() {
		assertTrue(this.mapScript.terrainConstExists(this.exampleConst));
	}
	
	@Test
	void testAddNewObjectConst() {
		Long newId = 2L;
		String newName = "new_object";
		Map<String, Long> before = this.mapScript.getObjectDefs();
		try {
			this.mapScript.addNewObjectConst(newId, newName);
			assertFalse(before == this.mapScript.getObjectDefs());
			assertTrue(this.mapScript.getObjectDefs().containsKey(newName));
			assertTrue(this.mapScript.getObjectDefs().get(newName) == newId);
		} catch(InvalidTerrainTypeException e) {
			fail("InvalidTerrainTypeException thrown.");
		}
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
