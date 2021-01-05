package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.controller.phases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * A class that tests the PrepareToAttackPhase class.
 *
 * @author Matías Salim Seda Auil
 * @see PrepareToAttackPhase 
 */

class PrepareToAttackPhaseTest extends PhaseTest {
    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        super.setUp();
        controller.setPhase(new CreationPhase());
        phase = controller.getPhase();

        try {
            phase.createElements();
            phase = controller.getPhase();
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }

    }

    /**
     * Checks that the prepate to attack phase's method "toGetCharacterPhase" works properly.
     */
    @Test
    void toGetCharacterPhaseTest() {
        try {
            phase.toGetCharacterPhase();
            assertEquals(controller.getPhase(), new GetCharacterPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }

    }

    /**
     * Checks that the prepate to attack phase's method "prepareToAttack" works properly.
     */
    @Test
    void prepareToAttackTest() {
        try {
            phase.prepareToAttack();
            assertEquals(controller.getPhase(), new GetCharacterPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertEquals(controller.getQueueSize(), 11);

        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }
    }
}





