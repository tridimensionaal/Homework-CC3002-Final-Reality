package com.github.tridimensionaal.finalreality.model.character.enemy;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.github.tridimensionaal.finalreality.model.character.*;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Enemy.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Enemy
 */
class EnemyTest extends AbstractCharacterTest {

  private static final int WEIGHT = 10;
  private static final int DAMAGE= 10;

  private static final int WEIGHT2 = 15;
  private static final int DAMAGE2 = 11;

  private final ICharacter enemy = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT, DAMAGE);

  @BeforeEach
  void setUp() {
      basicSetUp();
      testCharacters.add(new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT, DAMAGE));
  }


  /**
   * Checks that the enemy's constructor and equals methods works properly.
   */
  @Test
  void constructorTest() {
    //Same 
    ICharacter enemy1 = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT, DAMAGE);
    //Different name 
    ICharacter enemy2 = new Enemy(turns, NAME2, HEALTH,DEFENSE, WEIGHT, DAMAGE);
    //Different health
    ICharacter enemy3 = new Enemy(turns, NAME, HEALTH2,DEFENSE, WEIGHT, DAMAGE);
    //Different defense
    ICharacter enemy4 = new Enemy(turns, NAME, HEALTH,DEFENSE2, WEIGHT, DAMAGE);
    //Different name and health
    ICharacter enemy5 = new Enemy(turns, NAME2 , HEALTH2,DEFENSE, WEIGHT, DAMAGE);
    //Different name and defense
    ICharacter enemy6 = new Enemy(turns, NAME2 , HEALTH,DEFENSE2, WEIGHT, DAMAGE);
    //Different health and defense
    ICharacter enemy7 = new Enemy(turns, NAME, HEALTH2,DEFENSE2, WEIGHT, DAMAGE);
    //Different name, health and defense
    ICharacter enemy8 = new Enemy(turns, NAME2 , HEALTH2, DEFENSE2, WEIGHT, DAMAGE);
    checkConstruction(enemy, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8);

    //Different weight
    enemy2 = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT2, DAMAGE);
    assertNotEquals(enemy, enemy2);
    assertNotEquals(enemy.hashCode(), enemy2.hashCode());
 

    //Different name  and weight
    enemy2 = new Enemy(turns, NAME2, HEALTH,DEFENSE, WEIGHT2, DAMAGE);
    //Different health and weight
    enemy3 = new Enemy(turns, NAME, HEALTH2,DEFENSE, WEIGHT2, DAMAGE);
    //Different defense and weight
    enemy4 = new Enemy(turns, NAME, HEALTH,DEFENSE2, WEIGHT2, DAMAGE);
    //Different name, health and weight
    enemy5 = new Enemy(turns, NAME2 , HEALTH2,DEFENSE, WEIGHT2, DAMAGE);
    //Different name, defense and weight
    enemy6 = new Enemy(turns, NAME2 , HEALTH,DEFENSE2, WEIGHT2, DAMAGE);
    //Different health, defense and weight
    enemy7 = new Enemy(turns, NAME, HEALTH2,DEFENSE2, WEIGHT2, DAMAGE);
    //Different name, health, defense and weight
    enemy8 = new Enemy(turns, NAME2 , HEALTH2, DEFENSE2, WEIGHT2, DAMAGE);
    checkConstruction(enemy, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8);

    //Different damage  
    enemy2 = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT, DAMAGE2);
    assertNotEquals(enemy, enemy2);
    assertNotEquals(enemy.hashCode(), enemy2.hashCode());
 

    //Different name and damage 
    enemy2 = new Enemy(turns, NAME2, HEALTH,DEFENSE, WEIGHT, DAMAGE2);
    //Different health and damage  
    enemy3 = new Enemy(turns, NAME, HEALTH2,DEFENSE, WEIGHT, DAMAGE2);
    //Different defense and damage
    enemy4 = new Enemy(turns, NAME, HEALTH,DEFENSE2, WEIGHT, DAMAGE2);
    //Different name, health and damage 
    enemy5 = new Enemy(turns, NAME2 , HEALTH2,DEFENSE, WEIGHT, DAMAGE2);
    //Different name, defense and damage 
    enemy6 = new Enemy(turns, NAME2 , HEALTH,DEFENSE2, WEIGHT, DAMAGE2);
    //Different health, defense and damage
    enemy7 = new Enemy(turns, NAME, HEALTH2,DEFENSE2, WEIGHT, DAMAGE2);
    //Different name, health, defense and damage
    enemy8 = new Enemy(turns, NAME2 , HEALTH2, DEFENSE2, WEIGHT, DAMAGE2);
    checkConstruction(enemy, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8);

    //Different weight and damage 
    enemy2 = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT2, DAMAGE2);
    assertNotEquals(enemy, enemy2);
    assertNotEquals(enemy.hashCode(), enemy2.hashCode());

    //Different name, weight and damage 
    enemy2 = new Enemy(turns, NAME2, HEALTH,DEFENSE, WEIGHT2, DAMAGE2);
    //Different health, weight and damage  
    enemy3 = new Enemy(turns, NAME, HEALTH2,DEFENSE, WEIGHT2, DAMAGE2);
    //Different defense, weight and damage
    enemy4 = new Enemy(turns, NAME, HEALTH,DEFENSE2, WEIGHT2, DAMAGE2);
    //Different name, health, weight and damage 
    enemy5 = new Enemy(turns, NAME2 , HEALTH2,DEFENSE, WEIGHT2, DAMAGE2);
    //Different name, defense, weight  and damage 
    enemy6 = new Enemy(turns, NAME2 , HEALTH,DEFENSE2, WEIGHT2, DAMAGE2);
    //Different health, defense, weight and damage
    enemy7 = new Enemy(turns, NAME, HEALTH2,DEFENSE2, WEIGHT2, DAMAGE2);
    //Different name, health, defense, weight and damage
    enemy8 = new Enemy(turns, NAME2 , HEALTH2, DEFENSE2, WEIGHT2, DAMAGE2);
    checkConstruction(enemy, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8);
 
  }
}
