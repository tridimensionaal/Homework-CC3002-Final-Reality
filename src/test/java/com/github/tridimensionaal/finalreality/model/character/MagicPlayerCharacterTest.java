package com.github.tridimensionaal.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.tridimensionaal.finalreality.model.character.player.MagicPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.character.player.PlayerCharacter;
import com.github.tridimensionaal.finalreality.model.character.enemy.Enemy;
import com.github.tridimensionaal.finalreality.model.character.player.magic.*;
import com.github.tridimensionaal.finalreality.model.character.player.normal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see MagicPlayerCharacter
 */
class MagicPlayerCharacterTest extends PlayerCharacterTest{

  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String WHITE_MAGE_NAME = "Eiko";

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    ICharacter BlackMage = new BlackMage(turns, BLACK_MAGE_NAME, 10,10,10);
    testCharacters.add(BlackMage);

    ICharacter WhiteMage = new WhiteMage(turns, WHITE_MAGE_NAME, 10,10,10);
    testCharacters.add(WhiteMage);

  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test

  void constructorTest() {
    var enemy = new Enemy(turns, "Enemy", 10, 10, 10, 10);

    for (var character :
        testCharacters) {

      MagicPlayerCharacter character1 = (MagicPlayerCharacter) character;
      var characterName = character1.getName();
      var characterHealth = character1.getHealth();
      var characterDefense = character1.getDefense();
      var characterClass = character1.getCharacterClass();
      var characterMana = character1.getMana();



      ICharacter character2 = new MagicPlayerCharacter(turns, characterName, characterHealth, characterDefense, characterClass, characterMana);
      ICharacter character3 = new MagicPlayerCharacter(turns, "as", 12, 12, characterClass,13);
      ICharacter character4 = new MagicPlayerCharacter(turns, characterName, characterHealth, characterDefense, "jas",characterMana);

      ICharacter playerCharacter = new PlayerCharacter(turns, characterName, characterHealth, characterDefense, characterClass);


      checkConstruction(character, character2,character3,character4);
      assertNotEquals(character, enemy);
      assertNotEquals(character, playerCharacter);
    }

  }

  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      MagicPlayerCharacter character1 = (MagicPlayerCharacter) character;
      character1.equipWeapon(testWeapon);
      assertEquals(testWeapon, character1.getEquippedWeapon());
    }
  }
}
