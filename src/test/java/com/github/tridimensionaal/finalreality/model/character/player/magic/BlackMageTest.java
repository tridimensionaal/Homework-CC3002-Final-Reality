package com.github.tridimensionaal.finalreality.model.character.player.magic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.tridimensionaal.finalreality.model.character.player.*;
import com.github.tridimensionaal.finalreality.model.weapon.magic.Staff;
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
class BlackMageTest extends AbstractMagicPlayerCharacterTest{

  IPlayerCharacter blackMage = new BlackMage(turns, NAME, HEALTH, DEFENSE, MANA);

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();
    testWeapon = new Staff(15,10,10);
    testCharacters.add(new BlackMage(turns, NAME, HEALTH, DEFENSE, MANA));

  }

  /**
   * Checks that the black mage's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    //Same blackMage
    IMagicPlayerCharacter blackMage1 = new BlackMage(turns, NAME , HEALTH, DEFENSE,MANA);
    //Different name
    IMagicPlayerCharacter blackMage2= new BlackMage(turns, NAME2, HEALTH, DEFENSE, MANA);
    //Different health
    IMagicPlayerCharacter blackMage3 = new BlackMage(turns, NAME , HEALTH2, DEFENSE, MANA);
    //Different defense
    IMagicPlayerCharacter blackMage4 = new BlackMage(turns, NAME , HEALTH, DEFENSE2,MANA);
    //Different name and health
    IMagicPlayerCharacter blackMage5 = new BlackMage(turns, NAME2, HEALTH2, DEFENSE,MANA);
    //Different name and defense
    IMagicPlayerCharacter blackMage6 = new BlackMage(turns, NAME2, HEALTH, DEFENSE2,MANA);
    //Different health and defense
    IMagicPlayerCharacter blackMage7 = new BlackMage(turns, NAME , HEALTH2, DEFENSE2,MANA);
    //All different 
    IMagicPlayerCharacter blackMage8 = new BlackMage(turns, NAME2, HEALTH2, DEFENSE2,MANA);

    checkConstruction(blackMage,blackMage1,blackMage2,blackMage3,blackMage4,blackMage5,blackMage6, blackMage7, blackMage8);

    //Different name
    blackMage2= new BlackMage(turns, NAME2 , HEALTH, DEFENSE, MANA2);
    //Different health
    blackMage3 = new BlackMage(turns, NAME , HEALTH2, DEFENSE, MANA2);
    //Different defense
    blackMage4 = new BlackMage(turns, NAME , HEALTH, DEFENSE2,MANA2);
    //Different name and health
    blackMage5 = new BlackMage(turns, NAME2, HEALTH2, DEFENSE,MANA2);
    //Different name and defense
    blackMage6 = new BlackMage(turns, NAME2, HEALTH, DEFENSE2,MANA2);
    //Different health and defense
    blackMage7 = new BlackMage(turns, NAME , HEALTH2, DEFENSE2,MANA2);
    //All different 
    blackMage8 = new BlackMage(turns, NAME2, HEALTH2, DEFENSE2,MANA2);

    checkConstruction(blackMage,blackMage1,blackMage2,blackMage3,blackMage4,blackMage5,blackMage6, blackMage7, blackMage8);

  }

  /**
   * Checks that the equipWeapon method works properly.
   */
  @Test
  void equipWeaponTest() {
    blackMage.equipWeapon(testWeapon);
    assertEquals(blackMage.getEquippedWeapon(),testWeapon);
  }



}
