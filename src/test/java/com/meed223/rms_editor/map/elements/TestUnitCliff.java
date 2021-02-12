package com.meed223.rms_editor.map.elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class TestUnitCliff {
	// Test Consts:
	private Cliff cliff;

	// Test(s) setup
	@BeforeEach
	void init() {
		this.cliff = new Cliff();
	}
		
	@Test
	void testEquals() {
		EqualsVerifier.simple().forClass(Cliff.class).verify();
	}
	
	@Test
	void testToString() {
		String result = "<CLIFF_GENERATION>\n/* Size and number of cliffs */\n"
				+ "min_number_of_cliffs 0\nmax_number_of_cliffs 0\n"
				+ "min_length_of_cliffs 0\nmax_length_of_cliffs 0";
		assertEquals(result, this.cliff.toString());
	}
}
