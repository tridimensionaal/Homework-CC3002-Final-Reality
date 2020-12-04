package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.github.tridimensionaal.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Thief.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Thief
 */
class ThiefTest extends AbstractPlayerCharacterTest{

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    testWeapon = bowTest;

    character = new Thief(turns, NAME, HEALTH, DEFENSE);
    character1 = new Thief(turns, NAME, HEALTH, DEFENSE);
    character2 = new Thief(turns, NAME2, HEALTH, DEFENSE);
    character3 = new Thief(turns, NAME, HEALTH2, DEFENSE);
    character4 = new Thief(turns, NAME, HEALTH, DEFENSE2);
    character5 = new Thief(turns, NAME2, HEALTH2, DEFENSE);
    character6 = new Thief(turns, NAME2, HEALTH, DEFENSE2);
    character7  = new Thief(turns, NAME, HEALTH2, DEFENSE2);
    character8 = new Thief(turns, NAME2, HEALTH2, DEFENSE2);

    testCharacters.add(character);

    characterAttackTest = (IPlayerCharacter) character;
    characterEquipWeaponTest0 = new Thief(turns, NAME, 0, DEFENSE);

  }

  /**
   * Checks that the thief's constructor and equals method works properly.
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
        characterEquipWeaponTest = (IPlayerCharacter) character;

        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(axeTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(knifeTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(bowTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), bowTest);

        characterEquipWeaponTest.equipWeapon(swordTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), swordTest);

        characterEquipWeaponTest.equipWeapon(staffTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), staffTest);

        characterEquipWeaponTest0.equipWeapon(swordTest);
        assertNull(characterEquipWeaponTest0.getEquippedWeapon());
    }

}



