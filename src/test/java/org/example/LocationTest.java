package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationTest {

    @Test
    @DisplayName("Test new Location(double, double)")
    @MethodsUnderTest({"void Location.<init>(double, double)"})
    void testNewLocation() {
        Location actualLocation = new Location(10.0d, 10.0d);
        assertEquals(10.0d, actualLocation.latitude);
        assertEquals(10.0d, actualLocation.longitude);
    }
}
