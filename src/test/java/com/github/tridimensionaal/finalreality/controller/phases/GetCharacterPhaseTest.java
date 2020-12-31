package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * A class that tests the GetCharacterPhase class.
 *
 * @author Matías Salim Seda Auil
 * @see GetCharacterPhase 
 */

class GetCharacterPhaseTest extends PhaseTest {
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

    }

    /**
     * Checks that the get character phase's method "toPrepareToAttackPhase" works properly.
     */
    @Test
    void toPrepareToAttackPhaseTest() {
        try {
            phase.toPrepareToAttackPhase();
            assertEquals(controller.getPhase(), new PrepareToAttackPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");

        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks that the get character phase's method "toAttackPhase" works properly.
     */
    @Test
    void toAttackPhase() {
        try {
            phase.toAttackPhase();
            assertEquals(controller.getPhase(), new AttackPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");

        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks that the get character phase's method "getCharacter" works properly.
     */
    @Test
    void getCharacterTest(){
        try {
            phase.getCharacter();
            assertEquals(controller.getPhase(), new AttackPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");
            assertEquals(controller.getQueueSize(),13);
            assertNotNull(controller.getCurrentCharacter());
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }
        controller = new GameController();
        controller.setPhase( new GetCharacterPhase());
        phase = controller.getPhase();

        try {
            phase.getCharacter();
            assertEquals(controller.getPhase(), new PrepareToAttackPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");
            assertEquals(controller.getQueueSize(),0);
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }

    }
}




