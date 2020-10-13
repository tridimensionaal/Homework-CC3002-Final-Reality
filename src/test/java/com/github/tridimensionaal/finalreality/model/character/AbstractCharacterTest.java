package com.github.tridimensionaal.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.tridimensionaal.finalreality.model.character.player.*;
import com.github.tridimensionaal.finalreality.model.weapon.*;
import com.github.tridimensionaal.finalreality.model.weapon.magic.Staff;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
  protected IWeapon testWeapon;

  protected final String NAME = "Hola";
  protected final int HEALTH = 12;
  protected final int DEFENSE = 12;

  protected final String NAME2 = "Hola1";
  protected final int HEALTH2 = 13;
  protected final int DEFENSE2 = 13;


  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    if((testCharacters.get(0) instanceof IPlayerCharacter)) {
        IPlayerCharacter character = (IPlayerCharacter) testCharacters.get(0);
        tryToEquip(character);
        testCharacters.add(0,character);
    }
    if((testCharacters.get(0) instanceof IMagicPlayerCharacter)) {
      IPlayerCharacter  character = (IPlayerCharacter) testCharacters.get(0);
      tryToEquip(character);
      testCharacters.add(0, character);
    }
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

  private void tryToEquip(IPlayerCharacter character) {
      character.equipWeapon(testWeapon);
  }

  protected void checkConstruction(
      //Original character
      final ICharacter character,
      //Same character
      final ICharacter character1,
      //Different name
      final ICharacter character2,
      //Different health
      final ICharacter character3,
      //Different defense 
      final ICharacter character4,
      //Different name and health
      final ICharacter character5,
      //Different name and defense
      final ICharacter character6,
      //Different health and defense 
      final ICharacter character7,
      //All different
      final ICharacter character8) {

    //Different type
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

  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Staff(15, 10,10);
    testCharacters = new ArrayList<>();
  }
}
