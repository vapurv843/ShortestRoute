package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BestRouteFinderNTest {

    @Test
    @DisplayName("Test generatePermutations(List); when ArrayList(); then return Empty")
    @MethodsUnderTest({"List BestRouteFinderN.generatePermutations(List)"})
    void testGeneratePermutations_whenArrayList_thenReturnEmpty() {
        List<List<Order>> actualGeneratePermutationsResult =
                BestRouteFinderN.generatePermutations(new ArrayList<>());
        assertTrue(actualGeneratePermutationsResult.isEmpty());
    }
}
