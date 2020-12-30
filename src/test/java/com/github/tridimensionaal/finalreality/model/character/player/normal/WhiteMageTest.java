package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.github.tridimensionaal.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class White Mage.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see WhiteMage
 */
class WhiteMageTest extends AbstractPlayerCharacterTest{

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    testWeapon = staffTest;

    character = new WhiteMage(turns, NAME, HEALTH, DEFENSE);
    character1 = new WhiteMage(turns, NAME, HEALTH, DEFENSE);
    character2 = new WhiteMage(turns, NAME2, HEALTH, DEFENSE);
    character3 = new WhiteMage(turns, NAME, HEALTH2, DEFENSE);
    character4 = new WhiteMage(turns, NAME, HEALTH, DEFENSE2);
    character5 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE);
    character6 = new WhiteMage(turns, NAME2, HEALTH, DEFENSE2);
    character7  = new WhiteMage(turns, NAME, HEALTH2, DEFENSE2);
    character8 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE2);

    testCharacters.add(character);

    characterEquipWeaponTest = (IPlayerCharacter) character;
    characterEquipWeaponTest0 = new WhiteMage(turns, NAME, 0, DEFENSE);
    characterAttackTest = (IPlayerCharacter) character;
  }


  /**
   * Checks that the white mage's constructor and equals method works properly.
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

        characterEquipWeaponTest.equipWeapon(axeTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(swordTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(bowTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(knifeTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(staffTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), staffTest);

        characterEquipWeaponTest0.equipWeapon(staffTest);
        assertNull(characterEquipWeaponTest0.getEquippedWeapon());

    }

}
