package com.fleetmanagement.api_rest.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaxiTest {

	@Test
	public void testTaxiModel() {
		Taxi taxi = new Taxi(1, "ABC-123");
		assertEquals(1, taxi.getId());
		assertEquals("ABC-123", taxi.getPlate());
	}
}