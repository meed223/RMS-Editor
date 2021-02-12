package com.meed223.rms_editor.map.elements;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meed223.rms_editor.map.elements.Cliff;

import nl.jqno.equalsverifier.EqualsVerifier;

public class TestUnitCliff {
	// Test Consts:
	private Cliff cliff;
	private Integer max;
	private Integer min;

	// Test(s) setup
	@BeforeEach
	void init() {
		this.cliff = new Cliff();
		this.max = 2;
		this.min = 1;
	}
	
	@Test
	void getSetMaxLengthTest() {
		this.cliff.setMaxLength(this.max);
		assertTrue(this.cliff.getMaxLength() == this.max);
	}
	
	@Test
	void getSetMinLengthTest() {
		this.cliff.setMinLength(this.min);
		assertTrue(this.cliff.getMinLength() == this.min);
	}
	
	@Test
	void getSetMaxNumberTest() {
		this.cliff.setMaxNumber(this.max);
		assertTrue(this.cliff.getMaxNumber() == this.max);
	}
	
	@Test
	void getSetMinNumberTest() {
		this.cliff.setMinNumber(this.min);
		assertTrue(this.cliff.getMinNumber() == this.min);
	}
		
	@Test
	void testEquals() {
		EqualsVerifier.simple().forClass(Cliff.class).verify();
	}
	
	@Test
	void testToString() {
		// TODO fill in
	}
}
