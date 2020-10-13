package com.github.tridimensionaal.finalreality.model.character.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.tridimensionaal.finalreality.model.character.player.*;
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

  protected final int MANA2 = 12;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  protected void checkConstruction(
      //Original character
      IMagicPlayerCharacter character,
      //Same character
      IMagicPlayerCharacter character1,
      //Different name
      IMagicPlayerCharacter character2,
      //Different health
      IMagicPlayerCharacter character3,
      //Different defense 
      IMagicPlayerCharacter character4,
      //Different name and health
      IMagicPlayerCharacter character5,
      //Different name and defense
      IMagicPlayerCharacter character6,
      //Different health and defense 
      IMagicPlayerCharacter character7,
      //All different
      IMagicPlayerCharacter character8) {

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
