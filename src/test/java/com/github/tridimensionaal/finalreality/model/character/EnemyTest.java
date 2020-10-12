package com.github.tridimensionaal.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.github.tridimensionaal.finalreality.model.character.enemy.*;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final int ENEMY_HEALTH = 10;
  private static final int ENEMY_DEFENSE = 10;
  private static final int ENEMY_WEIGHT = 10;
  private static final int ENEMY_DAMAGE = 10;

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(turns, ENEMY_NAME, ENEMY_HEALTH,ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE));
  }

  @Test
  void constructorTest() {
    //Original
    ICharacter enemy = new Enemy(turns, ENEMY_NAME, ENEMY_HEALTH,ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE);
    //Same 
    ICharacter enemy1 = new Enemy(turns, ENEMY_NAME, ENEMY_HEALTH,ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE);
    //Different name 
    ICharacter enemy2 = new Enemy(turns, "adas", ENEMY_HEALTH,ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE);
    //Different health
    ICharacter enemy3 = new Enemy(turns, ENEMY_NAME, 13,ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE);
    //Different defense
    ICharacter enemy4 = new Enemy(turns, ENEMY_NAME, ENEMY_HEALTH,14, ENEMY_WEIGHT, ENEMY_DAMAGE);
    //Different name and health
    ICharacter enemy5 = new Enemy(turns, "kjas" , 14,ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE);
    //Different name and defense
    ICharacter enemy6 = new Enemy(turns, "kasdj" , ENEMY_HEALTH,15, ENEMY_WEIGHT, ENEMY_DAMAGE);
    //Different health and defense
    ICharacter enemy7 = new Enemy(turns, ENEMY_NAME, 14,17, ENEMY_WEIGHT, ENEMY_DAMAGE);
     //Different name, health and defense
    ICharacter enemy8 = new Enemy(turns, "ajas" , 18, 19, ENEMY_WEIGHT, ENEMY_DAMAGE);

    ICharacter thief = new Thief(turns, ENEMY_NAME, ENEMY_HEALTH, ENEMY_DEFENSE);
    
    checkConstruction(enemy, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8);
    assertNotEquals(enemy, thief);
    assertNotEquals(enemy.hashCode(), thief.hashCode());
    assertNotEquals(thief, enemy);
    assertNotEquals(thief.hashCode(), enemy.hashCode());
 
  }
}
