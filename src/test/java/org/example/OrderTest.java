package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("Test new Order(String, Location, String, Location, double)")
    void testNewOrder() {
        Location cLoc = new Location(10.0d, 10.0d);

        Order actualOrder =
                new Order("Consumer Name", cLoc, "Restaurant Name", new Location(10.0d, 10.0d), 10.0d);

        assertEquals("Consumer Name", actualOrder.consumerName);
        assertEquals("Restaurant Name", actualOrder.restaurantName);
        assertEquals(0.16666666666666666d, actualOrder.preparationTime);
        Location location = actualOrder.consumerLocation;
        assertEquals(10.0d, location.latitude);
        Location location2 = actualOrder.restaurantLocation;
        assertEquals(10.0d, location2.latitude);
        assertEquals(10.0d, location.longitude);
        assertEquals(10.0d, location2.longitude);
    }
}
