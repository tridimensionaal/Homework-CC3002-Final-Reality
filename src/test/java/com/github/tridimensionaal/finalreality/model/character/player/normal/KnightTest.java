package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.tridimensionaal.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class KnightTest extends AbstractPlayerCharacterTest{

  IPlayerCharacter knight = new Knight(turns, NAME, HEALTH, DEFENSE);

  /**
   * Setup method.
   */
 
  @BeforeEach
  void setUp() {
    super.basicSetUp();
    testCharacters.add(new Knight(turns, NAME, HEALTH, DEFENSE));

 }
  /**
   * Checks that the knight's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    //Same knight
    IPlayerCharacter knight1 = new Knight(turns, NAME , HEALTH, DEFENSE);
    //Different name
    IPlayerCharacter knight2= new Knight(turns, NAME2, HEALTH, DEFENSE);
    //Different health
    IPlayerCharacter knight3 = new Knight(turns, NAME , HEALTH2, DEFENSE);
    //Different defense
    IPlayerCharacter knight4 = new Knight(turns, NAME , HEALTH, DEFENSE2);
    //Different name and health
    IPlayerCharacter knight5 = new Knight(turns, NAME2, HEALTH2, DEFENSE);
    //Different name and defense
    IPlayerCharacter knight6 = new Knight(turns, NAME2, HEALTH, DEFENSE2);
    //Different health and defense
    IPlayerCharacter knight7 = new Knight(turns, NAME , HEALTH2, DEFENSE2);
    //All different 
    IPlayerCharacter knight8 = new Knight(turns, NAME , HEALTH2, DEFENSE2);

    checkConstruction(knight,knight1,knight2,knight3,knight4,knight5,knight6, knight7, knight8);

  }

  /**
   * Checks that the equipWeapon method works properly.
   */
  @Test
  void equipWeaponTest() {
    knight.equipWeapon(testWeapon);
    assertEquals(knight.getEquippedWeapon(),testWeapon);
  }

}
