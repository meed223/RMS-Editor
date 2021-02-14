package com.meed223.rms_editor.map.elements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meed223.rms_editor.exceptions.InvalidInputException;
import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;

public class TestUnitElevation {
	// Test Consts.
	private Elevation elevation;
	final private int elev = 1;
	final private String terrain = "GRASS";
	
	@BeforeEach
	void init() {
		this.elevation = new Elevation();
	}
	
	@Test
	void testSetElevation() {
		try {
			this.elevation.setElevation(this.elev);
			assertEquals(this.elev, this.elevation.getElevation());
		} catch (InvalidInputException e) {
			fail("InvalidInputException thrown.");
		}
	}
	
	@Test
	void testSetBaseTerrain() {
		try {
			this.elevation.setBaseTerrain(this.terrain);
			assertEquals(this.terrain, this.elevation.getBaseTerrain());
		} catch (InvalidTerrainTypeException e) {
			fail("InvalidTerrainTypeException thrown.");
		}
	}
	
	@Test
	void testToString() {
		try {
			this.elevation.setBaseTerrain(this.terrain);
			this.elevation.setElevation(this.elev);
			assertEquals("\ncreate_elevation    " + this.elev
					+ "\n{\n  base_terrain " + this.terrain
					+ "\n  number_of_clumps " + 0
					+ "\n  number_of_tiles " + 0, this.elevation.toString());
		} catch (InvalidTerrainTypeException e) {
			fail("InvalidTerrainTypeException thrown.");
		} catch (InvalidInputException e) {
			fail("InvalidInputException thrown.");
		}
	}
}
