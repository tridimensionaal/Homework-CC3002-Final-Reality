package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.tridimensionaal.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Engineer.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Engineer
 */

class EngineerTest extends AbstractPlayerCharacterTest {
    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();

        testWeapon = axeTest;
        testCharacters.add(new Engineer(turns, NAME, HEALTH, DEFENSE));

        character = new Engineer(turns, NAME, HEALTH, DEFENSE);
        character1 = new Engineer(turns, NAME, HEALTH, DEFENSE);
        character2 = new Engineer(turns, NAME2, HEALTH, DEFENSE);
        character3 = new Engineer(turns, NAME, HEALTH2, DEFENSE);
        character4 = new Engineer(turns, NAME, HEALTH, DEFENSE2);
        character5 = new Engineer(turns, NAME2, HEALTH2, DEFENSE);
        character6 = new Engineer(turns, NAME2, HEALTH, DEFENSE2);
        character7  = new Engineer(turns, NAME, HEALTH2, DEFENSE2);
        character8 = new Engineer(turns, NAME2, HEALTH2, DEFENSE2);

        characterEquipWeaponTest = (IPlayerCharacter) character;
        characterEquipWeaponTest0 = new Engineer(turns, NAME, 0, DEFENSE);

        characterAttackTest = (IPlayerCharacter) character;

    }

    /**
     * Checks that the engineer's constructor and equals method works properly.
     */
    @Test
    void constructorTest() {
        super.checkConstruction();
    }

    /**
     * Checks that the equipWeapon method works properly.
     */
    @Test
    void equipWeaponTest() {

        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(swordTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(knifeTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(staffTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(axeTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), axeTest);

        characterEquipWeaponTest.equipWeapon(bowTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), bowTest);

        characterEquipWeaponTest0.equipWeapon(axeTest);
        assertNull(characterEquipWeaponTest0.getEquippedWeapon());
    }

}


