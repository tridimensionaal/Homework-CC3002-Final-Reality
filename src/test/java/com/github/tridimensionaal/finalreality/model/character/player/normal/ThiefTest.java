package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  IPlayerCharacter thief = new Thief(turns, NAME, HEALTH, DEFENSE);

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();
    testCharacters.add(new Thief(turns, NAME, HEALTH, DEFENSE));
  }

  /**
   * Checks that the thief's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    //Same thief
    IPlayerCharacter thief1 = new Thief(turns, NAME , HEALTH, DEFENSE);
    //Different name
    IPlayerCharacter thief2= new Thief(turns, NAME2 , HEALTH, DEFENSE);
    //Different health
    IPlayerCharacter thief3 = new Thief(turns, NAME , HEALTH2, DEFENSE);
    //Different defense
    IPlayerCharacter thief4 = new Thief(turns, NAME , HEALTH, DEFENSE2);
    //Different name and health
    IPlayerCharacter thief5 = new Thief(turns, NAME2, HEALTH2, DEFENSE);
    //Different name and defense
    IPlayerCharacter thief6 = new Thief(turns, NAME2, HEALTH, DEFENSE2);
    //Different health and defense
    IPlayerCharacter thief7 = new Thief(turns, NAME , HEALTH2, DEFENSE2);
    //All different 
    IPlayerCharacter thief8 = new Thief(turns, NAME2, HEALTH2, DEFENSE2);

    checkConstruction(thief,thief1,thief2,thief3,thief4,thief5,thief6, thief7, thief8);
  }

  /**
   * Checks that the equipWeapon method works properly.
   */
  @Test
  void equipWeaponTest() {
    thief.equipWeapon(testWeapon);
    assertEquals(thief.getEquippedWeapon(),testWeapon);
  }
}
