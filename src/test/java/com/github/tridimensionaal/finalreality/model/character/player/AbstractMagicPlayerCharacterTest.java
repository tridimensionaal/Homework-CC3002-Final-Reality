package com.github.tridimensionaal.finalreality.model.character.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Abstract class containing the common tests for all the types of player magic characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see IMagicPlayerCharacter
 */
public abstract class AbstractMagicPlayerCharacterTest extends AbstractPlayerCharacterTest{

  protected final int MANA = 12;
  protected final int MANA2 = 13;

  //Original magicPlayerCharacter
  protected IMagicPlayerCharacter magicPlayerCharacter;
  //Same magicPlayerCharacter
  protected IMagicPlayerCharacter magicPlayerCharacter1;
  //Different name
  protected IMagicPlayerCharacter magicPlayerCharacter2;
  //Different health
  protected IMagicPlayerCharacter magicPlayerCharacter3;
  //Different defense
  protected IMagicPlayerCharacter magicPlayerCharacter4;
  //Different name and health
  protected IMagicPlayerCharacter magicPlayerCharacter5;
  //Different name and defense
  protected IMagicPlayerCharacter magicPlayerCharacter6;
  //Different health and defense
  protected IMagicPlayerCharacter magicPlayerCharacter7;
  //All different
  protected IMagicPlayerCharacter magicPlayerCharacter8;


  /**
   * Setup method.
   */
  @BeforeEach
  protected void basicSetUp() {
    super.basicSetUp();
  }

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    IMagicPlayerCharacter  character = (IMagicPlayerCharacter) testCharacters.get(0);
    character.equipWeapon(testWeapon);
    testCharacters.add(0, character);
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

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  protected void checkConstruction(){
    assertNotEquals(magicPlayerCharacter, "Hola");
    assertNotEquals(magicPlayerCharacter.hashCode(), "Hola".hashCode());

    assertEquals(magicPlayerCharacter, magicPlayerCharacter);
    assertEquals(magicPlayerCharacter.hashCode(), magicPlayerCharacter.hashCode());

    assertEquals(magicPlayerCharacter, magicPlayerCharacter1);
    assertEquals(magicPlayerCharacter.hashCode(), magicPlayerCharacter1.hashCode());

    assertNotEquals(magicPlayerCharacter, magicPlayerCharacter2);
    assertNotEquals(magicPlayerCharacter.hashCode(), magicPlayerCharacter2.hashCode());

    assertNotEquals(magicPlayerCharacter, magicPlayerCharacter3);
    assertNotEquals(magicPlayerCharacter.hashCode(), magicPlayerCharacter3.hashCode());

    assertNotEquals(magicPlayerCharacter, magicPlayerCharacter4);
    assertNotEquals(magicPlayerCharacter.hashCode(), magicPlayerCharacter4.hashCode());

    assertNotEquals(magicPlayerCharacter, magicPlayerCharacter5);
    assertNotEquals(magicPlayerCharacter.hashCode(), magicPlayerCharacter5.hashCode());

    assertNotEquals(magicPlayerCharacter, magicPlayerCharacter6);
    assertNotEquals(magicPlayerCharacter.hashCode(), magicPlayerCharacter6.hashCode());

    assertNotEquals(magicPlayerCharacter, magicPlayerCharacter7);
    assertNotEquals(magicPlayerCharacter.hashCode(), magicPlayerCharacter7.hashCode());

    assertNotEquals(magicPlayerCharacter, magicPlayerCharacter8);
    assertNotEquals(magicPlayerCharacter.hashCode(), magicPlayerCharacter8.hashCode());

    super.checkConstruction();
  }
}
