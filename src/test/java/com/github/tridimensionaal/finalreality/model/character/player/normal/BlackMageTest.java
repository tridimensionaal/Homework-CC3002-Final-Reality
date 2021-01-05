package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.tridimensionaal.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Black Mage.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see BlackMage 
 */
class BlackMageTest extends AbstractPlayerCharacterTest{

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
      super.basicSetUp();

      testWeapon = staffTest;

      character = new BlackMage(turns, NAME, HEALTH, DEFENSE);
      character1 = new BlackMage(turns, NAME, HEALTH, DEFENSE );
      character2 = new BlackMage(turns, NAME2, HEALTH, DEFENSE);
      character3 = new BlackMage(turns, NAME, HEALTH2, DEFENSE);
      character4 = new BlackMage(turns, NAME, HEALTH, DEFENSE2);
      character5 = new BlackMage(turns, NAME2, HEALTH2, DEFENSE);
      character6 = new BlackMage(turns, NAME2, HEALTH, DEFENSE2);
      character7  = new BlackMage(turns, NAME, HEALTH2, DEFENSE2);
      character8 = new BlackMage(turns, NAME2, HEALTH2, DEFENSE2);

      testCharacters.add(character);

      characterEquipWeaponTest = (IPlayerCharacter) character;
      characterEquipWeaponTest0 = new BlackMage(turns, NAME, 0, DEFENSE);

      characterAttackTest = (IPlayerCharacter) character;

  }

  /**
   * Checks that the black mage's constructor and equals method works properly.
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
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), knifeTest);

        characterEquipWeaponTest.equipWeapon(staffTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), staffTest);

        characterEquipWeaponTest0.equipWeapon(staffTest);
        assertNull(characterEquipWeaponTest0.getEquippedWeapon());
    }

}


