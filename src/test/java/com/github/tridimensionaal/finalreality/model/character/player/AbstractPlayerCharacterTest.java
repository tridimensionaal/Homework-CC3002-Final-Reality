package com.github.tridimensionaal.finalreality.model.character.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.tridimensionaal.finalreality.model.character.*;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Abstract class containing the common tests for all the types of player magic characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see IPlayerCharacter
 */

public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {
  protected IWeapon testWeapon;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    IPlayerCharacter character = (IPlayerCharacter) testCharacters.get(0);
    character.equipWeapon(testWeapon);
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void checkConstruction(
          //Original character
          IPlayerCharacter character,
          //Same character
          IPlayerCharacter character1,
          //Different name
          IPlayerCharacter character2,
          //Different health
          IPlayerCharacter character3,
          //Different defense
          IPlayerCharacter character4,
          //Different name and health
          IPlayerCharacter character5,
          //Different name and defense
          IPlayerCharacter character6,
          //Different health and defense
          IPlayerCharacter character7,
          //All different
          IPlayerCharacter character8) {

    assertNotEquals(character, "Hola");
    assertNotEquals(character.hashCode(), "Hola".hashCode());

    assertEquals(character, character);
    assertEquals(character.hashCode(), character.hashCode());

    assertEquals(character, character1);
    assertEquals(character.hashCode(), character1.hashCode());

    assertNotEquals(character, character2);
    assertNotEquals(character.hashCode(), character2.hashCode());

    assertNotEquals(character, character3);
    assertNotEquals(character.hashCode(), character3.hashCode());

    assertNotEquals(character, character4);
    assertNotEquals(character.hashCode(), character4.hashCode());

    assertNotEquals(character, character5);
    assertNotEquals(character.hashCode(), character5.hashCode());

    assertNotEquals(character, character6);
    assertNotEquals(character.hashCode(), character6.hashCode());

    assertNotEquals(character, character7);
    assertNotEquals(character.hashCode(), character7.hashCode());

    assertNotEquals(character, character8);
    assertNotEquals(character.hashCode(), character8.hashCode());

    assertNotEquals(character, character8);
    assertNotEquals(character.hashCode(), character8.hashCode());

  }

}

