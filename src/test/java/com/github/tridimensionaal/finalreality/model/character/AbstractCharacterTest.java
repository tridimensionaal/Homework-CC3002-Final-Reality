package com.github.tridimensionaal.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see ICharacter
 */
public abstract class AbstractCharacterTest {

  protected BlockingQueue<ICharacter> turns;
  protected List<ICharacter> testCharacters;

  protected final String NAME = "Name1";
  protected int HEALTH = 20;
  protected final int DEFENSE = 10;

  protected final String NAME2 = "Name2";
  protected int HEALTH2 = 15;
  protected final int DEFENSE2 = 5;

  //Original character
  protected ICharacter character;
  //Same character
  protected ICharacter character1;
  //Different name
  protected ICharacter character2;
  //Different health
  protected ICharacter character3;
  //Different defense
  protected ICharacter character4;
  //Different name and health
  protected ICharacter character5;
  //Different name and defense
  protected ICharacter character6;
  //Different health and defense
  protected ICharacter character7;
  //All different
  protected ICharacter character8;

  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testCharacters = new ArrayList<>();
  }

  protected void checkConstruction(){
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

  }
}


