package com.github.tridimensionaal.finalreality.model.character.player.normal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.*;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.*;
import com.github.tridimensionaal.finalreality.model.weapon.magic.*;
import com.github.tridimensionaal.finalreality.model.character.enemy.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class KnightTest extends AbstractPlayerCharacterTest{

  IPlayerCharacter knight = new Knight(turns, NAME, HEALTH, DEFENSE);

  /**
   * Setup method.
   */
 
  @BeforeEach
  void setUp() {
    super.basicSetUp();
    testWeapon = new Sword(15,10);
    testCharacters.add(new Knight(turns, NAME, HEALTH, DEFENSE));

 }
  /**
   * Checks that the knight's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    //Same knight
    IPlayerCharacter knight1 = new Knight(turns, NAME , HEALTH, DEFENSE);
    //Different name
    IPlayerCharacter knight2= new Knight(turns, NAME2, HEALTH, DEFENSE);
    //Different health
    IPlayerCharacter knight3 = new Knight(turns, NAME , HEALTH2, DEFENSE);
    //Different defense
    IPlayerCharacter knight4 = new Knight(turns, NAME , HEALTH, DEFENSE2);
    //Different name and health
    IPlayerCharacter knight5 = new Knight(turns, NAME2, HEALTH2, DEFENSE);
    //Different name and defense
    IPlayerCharacter knight6 = new Knight(turns, NAME2, HEALTH, DEFENSE2);
    //Different health and defense
    IPlayerCharacter knight7 = new Knight(turns, NAME , HEALTH2, DEFENSE2);
    //All different 
    IPlayerCharacter knight8 = new Knight(turns, NAME , HEALTH2, DEFENSE2);

    checkConstruction(knight,knight1,knight2,knight3,knight4,knight5,knight6, knight7, knight8);

  }

  /**
   * Checks that the equipWeapon method works properly.
   */
  @Test
    void equipWeaponTest() {
        IPlayerCharacter knight1 = new Knight(turns, "hola",10,10);

        IWeapon axeTest = new Axe(10,10);
        IWeapon bowTest = new Bow(10,10);
        IWeapon knifeTest = new Knife(10,10);
        IWeapon swordTest = new Sword(10,10);
        IWeapon staffTest = new Staff(10,10,10);


        assertNull(knight1.getEquippedWeapon());

        knight1.equipWeapon(bowTest);
        assertNull(knight1.getEquippedWeapon());

        knight1.equipWeapon(staffTest);
        assertNull(knight1.getEquippedWeapon());

        knight1.equipWeapon(axeTest);
        assertEquals(knight1.getEquippedWeapon(), axeTest);

        knight1.equipWeapon(swordTest);
        assertEquals(knight1.getEquippedWeapon(), swordTest);

        knight1.equipWeapon(knifeTest);
        assertEquals(knight1.getEquippedWeapon(), knifeTest);

        IPlayerCharacter knight2 = new Knight(turns, "hola",0,0);
        knight2.equipWeapon(swordTest);
        assertNull(knight2.getEquippedWeapon());

    }


    @Test
    void attackTest(){
        IPlayerCharacter knight1 = new Knight(turns, "hola", 20,10);
        //weapon Damage = 15
        knight1.equipWeapon(testWeapon);
        ICharacter enemy = new Enemy(turns,"hola",15,5,10,10);
        knight1.attack(enemy);
        assertEquals(enemy.getHealth(),5);
        knight1.attack(enemy);
        assertEquals(enemy.getHealth(),0);
        enemy.attack(knight1);

    }
}

