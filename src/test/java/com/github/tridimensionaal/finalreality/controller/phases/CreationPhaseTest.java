package com.github.tridimensionaal.finalreality.controller.phases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * A class that tests the CreationPhase class.
 *
 * @author Matías Salim Seda Auil
 * @see CreationPhase 
 */

class CreationPhaseTest extends PhaseTest {
    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        super.setUp();
        controller.setPhase(new CreationPhase());
        phase = controller.getPhase();

    }

    /**
     * Checks that the creation phase's method "createElements" works properly.
     */
 
    @Test
    void createElementsTest() {
        try {
            phase.createElements();
            assertEquals(controller.getPhase(), new PrepareToAttackPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");

            assertEquals(controller.getPlayerCharacterSize(), 5);
            assertEquals(controller.getEnemyCharacterSize(), 9);
            assertEquals(controller.getPlayerInventorySize(), 3);

        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }

    }

    /**
     * Checks that the creation phase's method "toPrepareToAttackPhase" works properly.
     */
    @Test
    void toPrepareToAttackPhaseTest() {
        try {
            phase.toPrepareToAttackPhase();
            assertEquals(controller.getPhase(), new PrepareToAttackPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");

        } catch (InvalidTransitionException e) {
        }
    }
 
}




