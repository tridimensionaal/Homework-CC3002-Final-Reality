package com.github.tridimensionaal.finalreality.controller.phases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * A class that tests the AttackPhase class.
 *
 * @author Matías Salim Seda Auil
 * @see AttackPhase 
 */


class AttackPhaseTest extends PhaseTest {
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
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }

        phase = controller.getPhase();

        try {
            phase.prepareToAttack();
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phase = controller.getPhase();
        try {
            phase.getCharacter();
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }
 
        phase = controller.getPhase();


    }

    /**
     * Checks that the attack phase's method "toGetCharacterPhase" works properly.
     */
    @Test
    void toGetCharacterPhaseTest() {
        try {
            phase.toPrepareToAttackPhase();
            assertEquals(controller.getPhase(), new GetCharacterPhase());
            assertEquals(controller.getPhase().hashCode() , new GetCharacterPhase().hashCode());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertEquals(controller.getPhase().hashCode(), controller.getPhase().hashCode());
            assertNotEquals(controller.getPhase(), "asda");

        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks that the attack phase's method "attack" works properly.
     */
    @Test
    void attackTest() {
        try {
            phase.attack();
            assertEquals(controller.getPhase(), new GetCharacterPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");

        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }
    }

}






