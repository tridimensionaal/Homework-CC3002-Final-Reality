package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.github.tridimensionaal.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Knight.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Knight
 */


public class KnightTest extends AbstractPlayerCharacterTest{

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    testWeapon = swordTest;
    testCharacters.add(new Knight(turns, NAME, HEALTH, DEFENSE));

    character = new Knight(turns, NAME, HEALTH, DEFENSE);
    character1 = new Knight(turns, NAME, HEALTH, DEFENSE);
    character2 = new Knight(turns, NAME2, HEALTH, DEFENSE);
    character3 = new Knight(turns, NAME, HEALTH2, DEFENSE);
    character4 = new Knight(turns, NAME, HEALTH, DEFENSE2);
    character5 = new Knight(turns, NAME2, HEALTH2, DEFENSE);
    character6 = new Knight(turns, NAME2, HEALTH, DEFENSE2);
    character7  = new Knight(turns, NAME, HEALTH2, DEFENSE2);
    character8 = new Knight(turns, NAME2, HEALTH2, DEFENSE2);
    characterAttackTest = (IPlayerCharacter) character;
    characterEquipWeaponTest0 = new Knight(turns, NAME, 0, DEFENSE);
 }


  /**
   * Checks that the knight's constructor and equals method works properly.
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

        characterEquipWeaponTest.equipWeapon(bowTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(staffTest);
        assertNull(characterEquipWeaponTest.getEquippedWeapon());

        characterEquipWeaponTest.equipWeapon(axeTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), axeTest);

        characterEquipWeaponTest.equipWeapon(swordTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), swordTest);

        characterEquipWeaponTest.equipWeapon(knifeTest);
        assertEquals(characterEquipWeaponTest.getEquippedWeapon(), knifeTest);

        characterEquipWeaponTest0.equipWeapon(swordTest);
        assertNull(characterEquipWeaponTest0.getEquippedWeapon());
    }

}

