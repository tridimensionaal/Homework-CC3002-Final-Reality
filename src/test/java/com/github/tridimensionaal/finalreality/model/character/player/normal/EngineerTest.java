package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.tridimensionaal.finalreality.model.character.player.*;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Axe;
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

class EngineerTest extends AbstractPlayerCharacterTest{
  IPlayerCharacter engineer = new Engineer(turns, NAME, HEALTH, DEFENSE);

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();
    testWeapon = new Axe(15,10);
    testCharacters.add(new Engineer(turns, NAME, HEALTH, DEFENSE));

 }
  /**
   * Checks that the engineer's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    //Same engineer
    IPlayerCharacter engineer1 = new Engineer(turns, NAME , HEALTH, DEFENSE);
    //Different name
    IPlayerCharacter engineer2= new Engineer(turns, NAME2, HEALTH, DEFENSE);
    //Different health
    IPlayerCharacter engineer3 = new Engineer(turns, NAME , HEALTH2, DEFENSE);
    //Different defense
    IPlayerCharacter engineer4 = new Engineer(turns, NAME , HEALTH, DEFENSE2);
    //Different name and health
    IPlayerCharacter engineer5 = new Engineer(turns, NAME2, HEALTH2, DEFENSE);
    //Different name and defense
    IPlayerCharacter engineer6 = new Engineer(turns, NAME2, HEALTH, DEFENSE2);
    //Different health and defense
    IPlayerCharacter engineer7 = new Engineer(turns, NAME , HEALTH2, DEFENSE2);
    //All different 
    IPlayerCharacter engineer8 = new Engineer(turns, NAME2, HEALTH2, DEFENSE2);

    checkConstruction(engineer,engineer1,engineer2,engineer3,engineer4,engineer5,engineer6, engineer7, engineer8);

  }

  /**
   * Checks that the equipWeapon method works properly.
   */
  @Test
  void equipWeaponTest() {
    engineer.equipWeapon(testWeapon);
    assertEquals(engineer.getEquippedWeapon(),testWeapon);
  }


}
