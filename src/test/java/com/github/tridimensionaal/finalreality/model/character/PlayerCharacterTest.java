package com.github.tridimensionaal.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.tridimensionaal.finalreality.model.character.player.*;
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
 * @see PlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest {

  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";
private static final String KNIGHT_NAME = "Railoo";

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    ICharacter Knight = new Knight(turns, KNIGHT_NAME, 10,10);
    testCharacters.add(Knight);

    ICharacter Engineer = new Engineer(turns, ENGINEER_NAME , 10,10);
    testCharacters.add(Engineer);

    ICharacter Thief = new Thief(turns, THIEF_NAME, 10,10);
    testCharacters.add(Thief);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy(turns, "Enemy", 10, 10, 10, 10);

    for (var character :
        testCharacters) {
      PlayerCharacter character1 = (PlayerCharacter) character;
      var characterName = character1.getName();
      var characterHealth = character1.getHealth();
      var characterDefense = character1.getDefense();
      var characterClass = character1.getCharacterClass();

      //Same character
      ICharacter character2 = new PlayerCharacter(turns, characterName, characterHealth, characterDefense, characterClass);
      //Diferent name
      ICharacter character3 = new PlayerCharacter(turns, "as", characterHealth, characterDefense, characterClass);
      //Different health
      ICharacter character4 = new PlayerCharacter(turns, characterName, 12, characterDefense, characterClass);
      //Diferent defense
      ICharacter character5 = new PlayerCharacter(turns, characterName, characterHealth, 12, characterClass);
      //Diferent name and health
      ICharacter character6 = new PlayerCharacter(turns, "asda" , 13, characterDefense, characterClass);
      //Diferent name and defense
      ICharacter character7 = new PlayerCharacter(turns, "asdas" , characterHealth, 15, characterClass);
      //Diferent health and defense
      ICharacter character8 = new PlayerCharacter(turns, characterName, 13, 131, characterClass);
      //Different name, health and defense 
      ICharacter character9 = new PlayerCharacter(turns, "jjka", 16, 1, characterClass);

      ICharacter magicPlayerCharacter = new MagicPlayerCharacter(turns, characterName, characterHealth, characterDefense, characterClass, 10);


      assertNotEquals(character, enemy);
      assertNotEquals(magicPlayerCharacter, character);
    }

  }

  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      PlayerCharacter character1 = (PlayerCharacter) character;
      character1.equipWeapon(testWeapon);
      assertEquals(testWeapon, character1.getEquippedWeapon());
    }
  }
}
