package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.IPlayerCharacter;
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
        controller.setPhase(new AttackPhase());
        phase = controller.getPhase();
    }

    /**
     * Checks that the attack phase's method "toGetCharacterPhase" works properly.
     */
    @Test
    void toGetCharacterPhaseTest() {
        try {
            phase.toGetCharacterPhase();
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
     * Checks that the attack phase's method "toGetCharacterPhase" works properly.
     */
    @Test
    void toFinalPhaseTest() {
        try {
            phase.toFinalPhase();
            assertEquals(controller.getPhase(), new FinalPhase());
            assertEquals(controller.getPhase().hashCode() , new FinalPhase().hashCode());
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
        ICharacter enemy = controller.createEnemy("Enemy");
        controller.addEnemy(enemy);

        IPlayerCharacter knight = controller.createKnight("Knight");
        knight.equipWeapon(controller.createSword());
        controller.addPlayerCharacter(knight);
        controller.setCurrentCharacter(knight);
        try {
            phase.attack(0);
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");
            assertEquals(controller.getPhase(), new GetCharacterPhase());
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }
        controller.setPhase(new AttackPhase());
        controller.setCurrentCharacter(enemy);
        try {
            phase.attack(0);
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");
            assertEquals(controller.getPhase(), new GetCharacterPhase());
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }



    }

}






