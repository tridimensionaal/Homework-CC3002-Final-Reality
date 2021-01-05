package com.github.tridimensionaal.finalreality.model.character.player;

import com.github.tridimensionaal.finalreality.model.character.*;
import com.github.tridimensionaal.finalreality.model.character.enemy.Enemy;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Abstract class containing the common tests for all the types of player magic characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see IPlayerCharacter
 */

public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {
  //Original playerCharacter
  protected IPlayerCharacter playerCharacter;
  //Same playerCharacter
  protected IPlayerCharacter playerCharacter1;
  //Different name
  protected IPlayerCharacter playerCharacter2;
  //Different health
  protected IPlayerCharacter playerCharacter3;
  //Different defense
  protected IPlayerCharacter playerCharacter4;
  //Different name and health
  protected IPlayerCharacter playerCharacter5;
  //Different name and defense
  protected IPlayerCharacter playerCharacter6;
  //Different health and defense
  protected IPlayerCharacter playerCharacter7;
  //All different
  protected IPlayerCharacter playerCharacter8;


  protected IWeapon axeTest;
  protected IWeapon bowTest;
  protected IWeapon knifeTest;
  protected IWeapon swordTest;
  protected IWeapon staffTest;

  protected IWeapon testWeapon;

  protected IPlayerCharacter characterAttackTest;
  protected ICharacter enemyAttackTest;

  protected IPlayerCharacter characterEquipWeaponTest;
  protected IPlayerCharacter characterEquipWeaponTest0;

  /**
   * Setup method.
   */
  @BeforeEach
  protected void basicSetUp() {
    super.basicSetUp();
    axeTest = new Axe(15,10);
    bowTest = new Bow(15,10);
    knifeTest = new Knife(15,10);
    swordTest = new Sword(15,10);
    staffTest = new Staff(15,10);
    enemyAttackTest = new Enemy(turns, "hi",10,10,10,10);

  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    assertTrue(turns.isEmpty());
    IPlayerCharacter character = (IPlayerCharacter) testCharacters.get(0);
    character.equipWeapon(testWeapon);
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

  protected void checkConstruction(){
    playerCharacter = (IPlayerCharacter) character;
    playerCharacter1 = (IPlayerCharacter) character1;
    playerCharacter2 = (IPlayerCharacter) character2;
    playerCharacter3 = (IPlayerCharacter) character3;
    playerCharacter4 = (IPlayerCharacter) character4;
    playerCharacter5 = (IPlayerCharacter) character5;
    playerCharacter6 = (IPlayerCharacter) character6;
    playerCharacter7 = (IPlayerCharacter) character7;
    playerCharacter8 = (IPlayerCharacter) character8;

    assertNotEquals(playerCharacter, "Hola");
    assertNotEquals(playerCharacter.hashCode(), "Hola".hashCode());

    assertEquals(playerCharacter, playerCharacter);
    assertEquals(playerCharacter.hashCode(), playerCharacter.hashCode());

    assertEquals(playerCharacter, playerCharacter1);
    assertEquals(playerCharacter.hashCode(), playerCharacter1.hashCode());

    assertNotEquals(playerCharacter, playerCharacter2);
    assertNotEquals(playerCharacter.hashCode(), playerCharacter2.hashCode());

    assertNotEquals(playerCharacter, playerCharacter3);
    assertNotEquals(playerCharacter.hashCode(), playerCharacter3.hashCode());

    assertNotEquals(playerCharacter, playerCharacter4);
    assertNotEquals(playerCharacter.hashCode(), playerCharacter4.hashCode());

    assertNotEquals(playerCharacter, playerCharacter5);
    assertNotEquals(playerCharacter.hashCode(), playerCharacter5.hashCode());

    assertNotEquals(playerCharacter, playerCharacter6);
    assertNotEquals(playerCharacter.hashCode(), playerCharacter6.hashCode());

    assertNotEquals(playerCharacter, playerCharacter7);
    assertNotEquals(playerCharacter.hashCode(), playerCharacter7.hashCode());

    assertNotEquals(playerCharacter, playerCharacter8);
    assertNotEquals(playerCharacter.hashCode(), playerCharacter8.hashCode());

    super.checkConstruction();
  }

  @Test
  void attackTest(){
    characterAttackTest.equipWeapon(testWeapon);

    characterAttackTest.attack(enemyAttackTest);
    assertEquals(enemyAttackTest.getHealth(),5);

    characterAttackTest.attack(enemyAttackTest);
    assertEquals(enemyAttackTest.getHealth(),0);
    assertTrue(enemyAttackTest.isDead());

    characterAttackTest.attack(enemyAttackTest);
    assertEquals(enemyAttackTest.getHealth(),0);
    assertTrue(enemyAttackTest.isDead());

    enemyAttackTest.attack(characterAttackTest);
    assertEquals(characterAttackTest.getHealth(),HEALTH);
  }

}

