package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.controller.GameController;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.IPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
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
        controller.setPhase(new GetCharacterPhase());
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
     * Checks that the get character phase's method "toEquipWeaponPhase" works properly.
     */
    @Test
    void toEquipWeaponPhaseTest() {
        try {
            phase.toEquipWeaponPhase();
            assertEquals(controller.getPhase(), new EquipWeaponPhase());
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
    void toAttackPhaseTest() {
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
            assertEquals(controller.getPhase(), new PrepareToAttackPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertEquals(controller.getQueueSize(), 0);
            assertNotEquals(controller.getPhase(), "asda");
            assertNull(controller.getCurrentCharacter());

        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }
        ICharacter enemy = controller.createEnemy("Enemy");
        controller.setPhase(new GetCharacterPhase());
        controller.addEnemy(enemy);
        controller.addToQueue();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phase = controller.getPhase();
        try {
            phase.getCharacter();
            assertEquals(controller.getPhase(), new AttackPhase());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");
            assertEquals(controller.getCurrentCharacter(), enemy);
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }

        controller = new GameController();
        controller.setPhase(new GetCharacterPhase());
        IPlayerCharacter knight = controller.createKnight("Knight");
        knight.equipWeapon(controller.createSword());
        controller.addPlayerCharacter(knight);
        controller.addToQueue();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phase = controller.getPhase();
        try {
            phase.getCharacter();
            assertEquals(controller.getPhase(), controller.getPhase());
            assertNotEquals(controller.getPhase(), "asda");
            assertEquals(controller.getPhase(), new EquipWeaponPhase());
            assertEquals(controller.getCurrentCharacter(), knight);
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }

    }
}




