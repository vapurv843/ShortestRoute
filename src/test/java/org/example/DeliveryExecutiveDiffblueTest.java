package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeliveryExecutiveDiffblueTest {

    @Test
    @DisplayName("Test new DeliveryExecutive(Location)")
    void testNewDeliveryExecutive() {
        Location location = new DeliveryExecutive(new Location(10.0d, 10.0d)).startLocation;
        assertEquals(10.0d, location.latitude);
        assertEquals(10.0d, location.longitude);
    }
}
