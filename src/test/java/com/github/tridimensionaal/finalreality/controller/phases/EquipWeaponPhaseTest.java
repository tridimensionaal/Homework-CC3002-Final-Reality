package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.model.character.player.IPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * A class that tests the EquipWeaponPhase class.
 *
 * @author Matías Salim Seda Auil
 * @see EquipWeaponPhase 
 */


class EquipWeaponPhaseTest extends PhaseTest {
    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        super.setUp();
        controller.setPhase(new EquipWeaponPhase());
        phase = controller.getPhase();
    }

    /**
     * Checks that the equip weapon phase's method "toAttackPhase" works properly.
     */
    @Test
    void toAttackPhaseTest() {
        try {
            phase.toAttackPhase();
            assertEquals(controller.getPhase(), new AttackPhase());
            assertEquals(controller.getPhase().hashCode() , new AttackPhase().hashCode());
            assertEquals(controller.getPhase(), controller.getPhase());
            assertEquals(controller.getPhase().hashCode(), controller.getPhase().hashCode());
            assertNotEquals(controller.getPhase(), "asda");

        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks that the equip weapon phase's method "equipWeapon" works properly.
     */
    @Test
    void equipWeaponTest() {
        IPlayerCharacter knight = controller.createKnight("Knight");
        IWeapon sword = controller.createSword();
        
        controller.setCurrentCharacter(knight);
        controller.addWeaponToInventory(sword);

        try {
            phase.equipWeapon(0);
            assertEquals(controller.getPhase(), new AttackPhase());
            assertEquals(controller.getPlayerInventorySize(), 0);
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }


    }

}






