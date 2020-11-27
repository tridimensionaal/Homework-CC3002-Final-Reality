package com.github.tridimensionaal.finalreality.model.character.enemy;

import com.github.tridimensionaal.finalreality.model.character.*;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Thief;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

  protected ICharacter characterAttackTest;
  protected ICharacter enemyAttackTest;




  @BeforeEach
  void setUp() {
    super.basicSetUp();
    testCharacters.add(new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT, DAMAGE));

    character = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT, DAMAGE);
    character1 = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT, DAMAGE);
    character2 = new Enemy(turns, NAME2, HEALTH,DEFENSE, WEIGHT, DAMAGE);
    character3 = new Enemy(turns, NAME, HEALTH2,DEFENSE, WEIGHT, DAMAGE);
    character4 = new Enemy(turns, NAME, HEALTH,DEFENSE2, WEIGHT, DAMAGE);
    character5 = new Enemy(turns, NAME2 , HEALTH2,DEFENSE, WEIGHT, DAMAGE);
    character6 = new Enemy(turns, NAME2 , HEALTH,DEFENSE2, WEIGHT, DAMAGE);
    character7 = new Enemy(turns, NAME, HEALTH2,DEFENSE2, WEIGHT, DAMAGE);
    character8 = new Enemy(turns, NAME2 , HEALTH2, DEFENSE2, WEIGHT, DAMAGE);

    enemyAttackTest = character;
    characterAttackTest = new Thief(turns,"hola",15,5);
 

 }

  @Test
  void waitTurnTest() {
    assertTrue(turns.isEmpty());
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      assertEquals(0, turns.size());
      Thread.sleep(200);
      assertEquals(1, turns.size());
      assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  /**
   * Checks that the enemy's constructor and equals methods works properly.
   */

  @Test
  void constructorTest() {
    super.checkConstruction();

    //Different weight
    character2 = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT2, DAMAGE);
    assertNotEquals(character, character2);
    assertNotEquals(character.hashCode(), character2.hashCode());
 

    //Different name  and weight
    character2 = new Enemy(turns, NAME2, HEALTH,DEFENSE, WEIGHT2, DAMAGE);
    //Different health and weight
    character3 = new Enemy(turns, NAME, HEALTH2,DEFENSE, WEIGHT2, DAMAGE);
    //Different defense and weight
    character4 = new Enemy(turns, NAME, HEALTH,DEFENSE2, WEIGHT2, DAMAGE);
    //Different name, health and weight
    character5 = new Enemy(turns, NAME2 , HEALTH2,DEFENSE, WEIGHT2, DAMAGE);
    //Different name, defense and weight
    character6 = new Enemy(turns, NAME2 , HEALTH,DEFENSE2, WEIGHT2, DAMAGE);
    //Different health, defense and weight
    character7 = new Enemy(turns, NAME, HEALTH2,DEFENSE2, WEIGHT2, DAMAGE);
    //Different name, health, defense and weight
    character8 = new Enemy(turns, NAME2 , HEALTH2, DEFENSE2, WEIGHT2, DAMAGE);

    super.checkConstruction();

    //Different damage  
    character2 = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT, DAMAGE2);
    assertNotEquals(character, character2);
    assertNotEquals(character.hashCode(), character2.hashCode());
 

    //Different name and damage 
    character2 = new Enemy(turns, NAME2, HEALTH,DEFENSE, WEIGHT, DAMAGE2);
    //Different health and damage  
    character3 = new Enemy(turns, NAME, HEALTH2,DEFENSE, WEIGHT, DAMAGE2);
    //Different defense and damage
    character4 = new Enemy(turns, NAME, HEALTH,DEFENSE2, WEIGHT, DAMAGE2);
    //Different name, health and damage 
    character5 = new Enemy(turns, NAME2 , HEALTH2,DEFENSE, WEIGHT, DAMAGE2);
    //Different name, defense and damage 
    character6 = new Enemy(turns, NAME2 , HEALTH,DEFENSE2, WEIGHT, DAMAGE2);
    //Different health, defense and damage
    character7 = new Enemy(turns, NAME, HEALTH2,DEFENSE2, WEIGHT, DAMAGE2);
    //Different name, health, defense and damage
    character8 = new Enemy(turns, NAME2 , HEALTH2, DEFENSE2, WEIGHT, DAMAGE2);
    super.checkConstruction();

    //Different weight and damage 
    character2 = new Enemy(turns, NAME, HEALTH,DEFENSE, WEIGHT2, DAMAGE2);
    assertNotEquals(character, character2);
    assertNotEquals(character.hashCode(), character2.hashCode());

    //Different name, weight and damage 
    character2 = new Enemy(turns, NAME2, HEALTH,DEFENSE, WEIGHT2, DAMAGE2);
    //Different health, weight and damage  
    character3 = new Enemy(turns, NAME, HEALTH2,DEFENSE, WEIGHT2, DAMAGE2);
    //Different defense, weight and damage
    character4 = new Enemy(turns, NAME, HEALTH,DEFENSE2, WEIGHT2, DAMAGE2);
    //Different name, health, weight and damage 
    character5 = new Enemy(turns, NAME2 , HEALTH2,DEFENSE, WEIGHT2, DAMAGE2);
    //Different name, defense, weight  and damage 
    character6 = new Enemy(turns, NAME2 , HEALTH,DEFENSE2, WEIGHT2, DAMAGE2);
    //Different health, defense, weight and damage
    character7 = new Enemy(turns, NAME, HEALTH2,DEFENSE2, WEIGHT2, DAMAGE2);
    //Different name, health, defense, weight and damage
    character8 = new Enemy(turns, NAME2 , HEALTH2, DEFENSE2, WEIGHT2, DAMAGE2);
    super.checkConstruction();
  }

  @Test
  void attackTest() {
      enemyAttackTest.attack(characterAttackTest);
      assertEquals(characterAttackTest.getHealth(),10);
      enemyAttackTest.attack(characterAttackTest);
      assertEquals(characterAttackTest.getHealth(),5);
      enemyAttackTest.attack(characterAttackTest);
      assertTrue(characterAttackTest.isDead());
      characterAttackTest.attack(enemyAttackTest);
      assertEquals(enemyAttackTest.getHealth(),HEALTH);
      }

}
