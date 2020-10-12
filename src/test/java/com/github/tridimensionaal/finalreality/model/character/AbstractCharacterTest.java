package com.github.tridimensionaal.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.tridimensionaal.finalreality.model.character.player.PlayerCharacter;
import com.github.tridimensionaal.finalreality.model.weapon.*;
import com.github.tridimensionaal.finalreality.model.weapon.normal.*;
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
 * @author <Your name>
 * @see ICharacter
 */
public abstract class AbstractCharacterTest {

  protected BlockingQueue<ICharacter> turns;
  protected List<ICharacter> testCharacters;
  protected IWeapon testWeapon;

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    if(testCharacters.get(0) instanceof PlayerCharacter) {
        PlayerCharacter character = (PlayerCharacter) testCharacters.get(0);
        tryToEquip(character);
        testCharacters.add(0,character);
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
  private void tryToEquip(PlayerCharacter character) {
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
      //Different name and defendse
      final ICharacter character6,
      //Different health and defense 
      final ICharacter character7,
      //All diferent
      final ICharacter character8) {

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
    testWeapon = new Axe(15, 10);
    testCharacters = new ArrayList<>();
  }
}
