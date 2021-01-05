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

    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        phase = new Phase();
        controller = new GameController();
    }

    /**
     * Checks that the phase's method "createElements" works properly.
     */
    @Test
    void createElementsTest() {
        assertThrows(InvalidMovementException.class, () -> phase.createElements());
    }

    /**
     * Checks that the phase's method "prepareToAttack" works properly.
     */
    @Test
    void prepareToAttackTest() {
        assertThrows(InvalidMovementException.class, () -> phase.prepareToAttack());
    }

    /**
     * Checks that the phase's method "getCharacter" works properly.
     */
    @Test
    void getCharacterTest() {
        assertThrows(InvalidMovementException.class, () -> phase.getCharacter());
    }

    /**
     * Checks that the phase's method "equipWeapon" works properly.
     */
    @Test
    void equipWeaponTest() {
        assertThrows(InvalidMovementException.class, () -> phase.equipWeapon(0));
    }
    /**
     * Checks that the phase's method "attackTest" works properly.
     */
    @Test
    void attackTest() {
        assertThrows(InvalidMovementException.class, () -> phase.attack(0));
    }

    /**
     * Checks that the phase's method "toInitialPhase" works properly.
     */
    @Test
    void toInitialPhaseTest() {
        assertThrows(InvalidTransitionException.class, () -> phase.toInitialPhase());
    }

    /**
     * Checks that the phase's method "toCreationPhase" works properly.
     */
    @Test
    void toCreationPhaseTest() {
        assertThrows(InvalidTransitionException.class, () -> phase.toCreationPhase());
    }

    /**
     * Checks that the phase's method "toPrepareToAttackPhase" works properly.
     */
    @Test
    void toPrepareToAttackPhaseTest() {
        assertThrows(InvalidTransitionException.class, () -> phase.toPrepareToAttackPhase());
    }


    /**
     * Checks that the phase's method "toGetCharacterPhase" works properly.
     */
    @Test
    void toGetCharacterPhaseTest() {
        assertThrows(InvalidTransitionException.class, () -> phase.toGetCharacterPhase());
    }

    /**
     * Checks that the phase's method "toGetCharacterPhase" works properly.
     */
    @Test
    void toEquipWeaponPhaseTest() {
        assertThrows(InvalidTransitionException.class, () -> phase.toEquipWeaponPhase());
    }

    /**
     * Checks that the phase's method "toAttackPhaseTest" works properly.
     */
    @Test
    void toAttackPhaseTest() {
        assertThrows(InvalidTransitionException.class, () -> phase.toAttackPhase());
    }

    /**
     * Checks that the phase's method "toFinalPhase" works properly.
     */
    @Test
    void toFinalPhaseTest() {
        assertThrows(InvalidTransitionException.class, () -> phase.toFinalPhase());
    }
}




