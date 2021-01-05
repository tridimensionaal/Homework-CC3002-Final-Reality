package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.controller.phases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * A class that tests the InitialPhase class.
 *
 * @author Matías Salim Seda Auil
 * @see InitialPhase 
 */

class InitialPhaseTest extends PhaseTest {

    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        super.setUp();
        phase = controller.getPhase();

    }

    /**
     * Checks that the initial phase's method "toCreationPhase" works properly.
     */
 
    @Test
    void toCreationPhaseTest() {
        try {
            phase.toCreationPhase();
            assertEquals(controller.getPhase(), new CreationPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }

    }
}

