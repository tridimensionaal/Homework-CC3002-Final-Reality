package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * A class that tests the Phase class.
 *
 * @author Matías Salim Seda Auil
 * @see Phase
 */

class PhaseTest{
    protected GameController controller;
    protected Phase phase;
    private final String cantChange = "Can't change from ";

    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        controller = new GameController();
        phase = controller.getPhase();
    }

    /**
     * Checks that the phase's method "createElements" works properly.
     */
    @Test
    void createElementsTest() {
        try {
            phase.createElements();
        } catch (InvalidMovementException e) {
            String cantCreate = "Can't create characters on ";
            assertEquals(cantCreate + phase.toString(), e.getMessage());
        }

    }

    /**
     * Checks that the phase's method "prepareToAttack" works properly.
     */
    @Test
    void prepareToAttackTest() {
        try {
            phase.prepareToAttack();
        } catch (InvalidMovementException e) {
            String cantPrepare = "Can't prepare to attack on ";
            assertEquals(cantPrepare + phase.toString(), e.getMessage());
        }

    }

    /**
     * Checks that the phase's method "getCharacterTest" works properly.
     */
    @Test
    void getCharacterTest() {
        try {
            phase.getCharacter();
        } catch (InvalidMovementException e) {
            String cantGet = "Can't get character on ";
            assertEquals(cantGet + phase.toString(), e.getMessage() );
        }
    }

    /**
     * Checks that the phase's method "attackTest" works properly.
     */
    @Test
    void attackTest() {
        try {
            phase.attack();
        } catch (InvalidMovementException e) {
            String cantAttack = "Can't attack on ";
            assertEquals(cantAttack + phase.toString(), e.getMessage() );
        }
    }

    /**
     * Checks that the phase's method "toInitialPhase" works properly.
     */
    @Test
    void toInitialPhaseTest() {
        try {
            phase.toInitialPhase();
        } catch (InvalidTransitionException e) {
            String toInitial = " to initial phase";
            assertEquals(cantChange + phase.toString() + toInitial, e.getMessage());
        }
    }

    /**
     * Checks that the phase's method "toCreationPhase" works properly.
     */
    @Test
    void toCreationPhaseTest() {
        try {
            phase.toCreationPhase();
        } catch (InvalidTransitionException e) {
            String toCreation = " to creation phase";
            assertEquals(cantChange + phase.toString() + toCreation, e.getMessage());
        }
    }

    /**
     * Checks that the phase's method "toPrepareToAttackPhase" works properly.
     */
    @Test
    void toPrepareToAttackPhaseTest() {
        try {
            phase.toPrepareToAttackPhase();
        } catch (InvalidTransitionException e) {
            String toPrepare = " to prepare to attack phase";
            assertEquals(cantChange + phase.toString() + toPrepare, e.getMessage());
        }
    }

    /**
     * Checks that the phase's method "toGetCharacterPhase" works properly.
     */
    @Test
    void toGetCharacterPhaseTest() {
        try {
            phase.toGetCharacterPhase();
        } catch (InvalidTransitionException e) {
            String toGet = " to get character phase";
            assertEquals(cantChange + phase.toString() + toGet, e.getMessage());
        }
    }

    /**
     * Checks that the phase's method "toAttackPhaseTest" works properly.
     */
    @Test
    void toAttackPhaseTest() {
        try {
            phase.toAttackPhase();
        } catch (InvalidTransitionException e) {
            String toAttack = " to attack phase";
            assertEquals(cantChange + phase.toString() + toAttack, e.getMessage());
        }
    }

    /**
     * Checks that the phase's method "toFinalPhase" works properly.
     */
    @Test
    void toFinalPhaseTest() {
        try {
            phase.toFinalPhase();
        } catch (InvalidTransitionException e) {
            String toFinal = " to final phase";
            assertEquals(cantChange + phase.toString() + toFinal, e.getMessage());
        }
    }
}




