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

      //Same character
      ICharacter character2 = new MagicPlayerCharacter(turns, characterName, characterHealth, characterDefense, characterClass,characterMana);
      //Diferent name
      ICharacter character3 = new MagicPlayerCharacter(turns, "as", characterHealth, characterDefense, characterClass, characterMana);
      //Different health
      ICharacter character4 = new MagicPlayerCharacter(turns, characterName, 12, characterDefense, characterClass, characterMana);
      //Diferent defense
      ICharacter character5 = new MagicPlayerCharacter(turns, characterName, characterHealth, 12, characterClass, characterMana);
      //Diferent name and health
      ICharacter character6 = new MagicPlayerCharacter(turns, "asda" , 13, characterDefense, characterClass, characterMana);
      //Diferent name and defense
      ICharacter character7 = new MagicPlayerCharacter(turns, "asdas" , characterHealth, 15, characterClass, characterMana);
      //Diferent health and defense
      ICharacter character8 = new MagicPlayerCharacter(turns, characterName, 13, 131, characterClass, characterMana);
      //Different name, health and defense 
      ICharacter character9 = new MagicPlayerCharacter(turns, "jjka", 16, 1, characterClass, characterMana);

      ICharacter playerCharacter = new PlayerCharacter(turns, characterName, characterHealth, characterDefense, characterClass);

      checkConstruction(character, character2, character3, character4, character5, character6, character7, character8, character9);
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
