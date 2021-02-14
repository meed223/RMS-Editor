package com.meed223.rms_editor.map.elements;

import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;
import com.meed223.rms_editor.exceptions.InvalidInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class TestUnitConnection {
	// Test Consts:
	private Connection connection;
	private String baseTerrain = "WATER";
	private String replacementTerrain = "GRASS";
	private int cost = 1;

	// Test(s) setup
	@BeforeEach
	void init() {
		this.connection = new Connection();
	}
	
	@Test
	void testEquals() {
		EqualsVerifier.simple().forClass(Connection.class).verify();
	}
	
	@Test
	void testSetBaseTerrain() {
		try {
			this.connection.setBaseTerrain(this.baseTerrain);
			assertEquals(this.baseTerrain, this.connection.getBaseTerrain());
		} catch (InvalidTerrainTypeException e) {
			fail("InvalidTerrainTypeException thrown.");
		}
	}
	
	@Test
	void testSetReplacementTerrain() {
		try {
			this.connection.setReplacementTerrain(this.replacementTerrain);
			assertEquals(this.replacementTerrain, this.connection.getReplacementTerrain());
		} catch (InvalidTerrainTypeException e) {
			fail("InvalidTerrainTypeException thrown.");
		}
	}
	
	@Test
	void testSetTerrainCost() {
		try {
			this.connection.setTerrainCost(this.cost);
			assertEquals(this.cost, this.connection.getTerrainCost());
		} catch (InvalidInputException e) {
			fail("InvalidInputException thrown.");
		}
	}
	
	@Test
	void testToString() {
		try {
			this.connection.setBaseTerrain(baseTerrain);
			this.connection.setReplacementTerrain(replacementTerrain);
			this.connection.setTerrainCost(cost);
		} catch (InvalidTerrainTypeException e) {
			fail("InvalidTerrainTypeException thrown.");
		} catch (InvalidInputException e) {
			fail("InvalidInputException thrown.");
		}
		assertEquals("\n  replace_terrain  " +
                baseTerrain +
                "    " +
                replacementTerrain +
                "\n  terrain_cost  " +
                baseTerrain +
                "    " +
                cost, this.connection.toString());
	}
}
