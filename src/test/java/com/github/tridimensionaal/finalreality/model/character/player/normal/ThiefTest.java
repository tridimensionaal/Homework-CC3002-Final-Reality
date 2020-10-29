package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.enemy.Enemy;
import com.github.tridimensionaal.finalreality.model.character.player.*;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.*;
import com.github.tridimensionaal.finalreality.model.weapon.magic.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Thief.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Thief
 */
class ThiefTest extends AbstractPlayerCharacterTest{

  IPlayerCharacter thief = new Thief(turns, NAME, HEALTH, DEFENSE);

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();
    testWeapon = new Bow(15,10);
    testCharacters.add(new Thief(turns, NAME, HEALTH, DEFENSE));
  }

  /**
   * Checks that the thief's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    //Same thief
    IPlayerCharacter thief1 = new Thief(turns, NAME , HEALTH, DEFENSE);
    //Different name
    IPlayerCharacter thief2= new Thief(turns, NAME2 , HEALTH, DEFENSE);
    //Different health
    IPlayerCharacter thief3 = new Thief(turns, NAME , HEALTH2, DEFENSE);
    //Different defense
    IPlayerCharacter thief4 = new Thief(turns, NAME , HEALTH, DEFENSE2);
    //Different name and health
    IPlayerCharacter thief5 = new Thief(turns, NAME2, HEALTH2, DEFENSE);
    //Different name and defense
    IPlayerCharacter thief6 = new Thief(turns, NAME2, HEALTH, DEFENSE2);
    //Different health and defense
    IPlayerCharacter thief7 = new Thief(turns, NAME , HEALTH2, DEFENSE2);
    //All different 
    IPlayerCharacter thief8 = new Thief(turns, NAME2, HEALTH2, DEFENSE2);

    checkConstruction(thief,thief1,thief2,thief3,thief4,thief5,thief6, thief7, thief8);
  }

  /**
   * Checks that the equipWeapon method works properly.
   */
  @Test
    void equipWeaponTest() {
        IPlayerCharacter thief1 = new Thief(turns, "hola",10,10);

        IWeapon axeTest = new Axe(10,10);
        IWeapon bowTest = new Bow(10,10);
        IWeapon knifeTest = new Knife(10,10);
        IWeapon swordTest = new Sword(10,10);
        IWeapon staffTest = new Staff(10,10,10);


        assertNull(thief1.getEquippedWeapon());

        thief1.equipWeapon(axeTest);
        assertNull(thief1.getEquippedWeapon());

        thief1.equipWeapon(knifeTest);
        assertNull(thief1.getEquippedWeapon());

        thief1.equipWeapon(bowTest);
        assertEquals(thief1.getEquippedWeapon(), bowTest);

        thief1.equipWeapon(swordTest);
        assertEquals(thief1.getEquippedWeapon(), swordTest);

        thief1.equipWeapon(staffTest);
        assertEquals(thief1.getEquippedWeapon(), staffTest);

        IPlayerCharacter thief2 = new Thief(turns, "hola",0,0);
        thief2.equipWeapon(swordTest);
        assertNull(thief2.getEquippedWeapon());

    }

    @Test
    void attackTest(){
        IPlayerCharacter thief1= new Thief(turns, "hola", 20,10);
        //weapon Damage = 15
        thief1.equipWeapon(testWeapon);
        ICharacter enemy = new Enemy(turns,"hola",15,5,10,10);
        thief1.attack(enemy);
        assertEquals(enemy.getHealth(),5);
        thief1.attack(enemy);
        assertEquals(enemy.getHealth(),0);
        enemy.attack(thief1);

    }
}



