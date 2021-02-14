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
	void testToString() {
		String baseTerrain = "WATER";
		String replacementTerrain = "GRASS";
		int cost = 1;
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
