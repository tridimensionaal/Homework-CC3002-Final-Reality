package com.github.tridimensionaal.finalreality.model.character.player.magic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.tridimensionaal.finalreality.model.character.player.*;
import com.github.tridimensionaal.finalreality.model.weapon.magic.Staff;
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
class WhiteMageTest extends AbstractMagicPlayerCharacterTest{


  IMagicPlayerCharacter whiteMage = new WhiteMage(turns, NAME, HEALTH, DEFENSE, MANA);

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();
    testWeapon = new Staff(15,10,10);
    testCharacters.add(new WhiteMage(turns, NAME, HEALTH, DEFENSE, MANA));
  }

  /**
   * Checks that the white mage's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    //Same whiteMage
    IMagicPlayerCharacter whiteMage1 = new WhiteMage(turns, NAME , HEALTH, DEFENSE,MANA);
    //Different name
    IMagicPlayerCharacter whiteMage2= new WhiteMage(turns, NAME2, HEALTH, DEFENSE, MANA);
    //Different health
    IMagicPlayerCharacter whiteMage3 = new WhiteMage(turns, NAME , HEALTH2, DEFENSE, MANA);
    //Different defense
    IMagicPlayerCharacter whiteMage4 = new WhiteMage(turns, NAME , HEALTH, DEFENSE2,MANA);
    //Different name and health
    IMagicPlayerCharacter whiteMage5 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE,MANA);
    //Different name and defense
    IMagicPlayerCharacter whiteMage6 = new WhiteMage(turns, NAME2, HEALTH, DEFENSE2,MANA);
    //Different health and defense
    IMagicPlayerCharacter whiteMage7 = new WhiteMage(turns, NAME , HEALTH2, DEFENSE2,MANA);
    //All different 
    IMagicPlayerCharacter whiteMage8 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE2,MANA);

    checkConstruction(whiteMage,whiteMage1,whiteMage2,whiteMage3,whiteMage4,whiteMage5,whiteMage6, whiteMage7, whiteMage8);

    //Different name
    whiteMage2= new WhiteMage(turns, NAME2 , HEALTH, DEFENSE, MANA2);
    //Different health
    whiteMage3 = new WhiteMage(turns, NAME , HEALTH2, DEFENSE, MANA2);
    //Different defense
    whiteMage4 = new WhiteMage(turns, NAME , HEALTH, DEFENSE2,MANA2);
    //Different name and health
    whiteMage5 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE,MANA2);
    //Different name and defense
    whiteMage6 = new WhiteMage(turns, NAME2, HEALTH, DEFENSE2,MANA2);
    //Different health and defense
    whiteMage7 = new WhiteMage(turns, NAME , HEALTH2, DEFENSE2,MANA2);
    //All different 
    whiteMage8 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE2,MANA2);

    checkConstruction(whiteMage,whiteMage1,whiteMage2,whiteMage3,whiteMage4,whiteMage5,whiteMage6, whiteMage7, whiteMage8);

  }
  /**
   * Checks that the equipWeapon method works properly.
   */
  @Test
  void equipWeaponTest() {
    whiteMage.equipWeapon(testWeapon);
    assertEquals(whiteMage.getEquippedWeapon(),testWeapon);
  }
}
