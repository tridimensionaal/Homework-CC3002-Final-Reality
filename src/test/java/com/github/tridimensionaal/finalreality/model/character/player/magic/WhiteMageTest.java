package com.github.tridimensionaal.finalreality.model.character.player.magic;

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
 * A class that tests the class White Mage.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see WhiteMage
 */
class WhiteMageTest extends AbstractMagicPlayerCharacterTest{


  IMagicPlayerCharacter whiteMage = new WhiteMage(turns, NAME, HEALTH, DEFENSE, MANA);

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();
    testWeapon = new Staff(15,10,10);
    testCharacters.add(new WhiteMage(turns, NAME, HEALTH, DEFENSE, MANA));
  }

  /**
   * Checks that the white mage's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    //Same whiteMage
    IMagicPlayerCharacter whiteMage1 = new WhiteMage(turns, NAME , HEALTH, DEFENSE,MANA);
    //Different name
    IMagicPlayerCharacter whiteMage2= new WhiteMage(turns, NAME2, HEALTH, DEFENSE, MANA);
    //Different health
    IMagicPlayerCharacter whiteMage3 = new WhiteMage(turns, NAME , HEALTH2, DEFENSE, MANA);
    //Different defense
    IMagicPlayerCharacter whiteMage4 = new WhiteMage(turns, NAME , HEALTH, DEFENSE2,MANA);
    //Different name and health
    IMagicPlayerCharacter whiteMage5 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE,MANA);
    //Different name and defense
    IMagicPlayerCharacter whiteMage6 = new WhiteMage(turns, NAME2, HEALTH, DEFENSE2,MANA);
    //Different health and defense
    IMagicPlayerCharacter whiteMage7 = new WhiteMage(turns, NAME , HEALTH2, DEFENSE2,MANA);
    //All different 
    IMagicPlayerCharacter whiteMage8 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE2,MANA);

    checkConstruction(whiteMage,whiteMage1,whiteMage2,whiteMage3,whiteMage4,whiteMage5,whiteMage6, whiteMage7, whiteMage8);

    //Different name
    whiteMage2= new WhiteMage(turns, NAME2 , HEALTH, DEFENSE, MANA2);
    //Different health
    whiteMage3 = new WhiteMage(turns, NAME , HEALTH2, DEFENSE, MANA2);
    //Different defense
    whiteMage4 = new WhiteMage(turns, NAME , HEALTH, DEFENSE2,MANA2);
    //Different name and health
    whiteMage5 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE,MANA2);
    //Different name and defense
    whiteMage6 = new WhiteMage(turns, NAME2, HEALTH, DEFENSE2,MANA2);
    //Different health and defense
    whiteMage7 = new WhiteMage(turns, NAME , HEALTH2, DEFENSE2,MANA2);
    //All different 
    whiteMage8 = new WhiteMage(turns, NAME2, HEALTH2, DEFENSE2,MANA2);

    checkConstruction(whiteMage,whiteMage1,whiteMage2,whiteMage3,whiteMage4,whiteMage5,whiteMage6, whiteMage7, whiteMage8);

  }
  /**
   * Checks that the equipWeapon method works properly.
   */
  @Test
    void equipWeaponTest() {
        IPlayerCharacter whiteMage1 = new WhiteMage(turns, "hola",10,10,10);

        IWeapon axeTest = new Axe(10,10);
        IWeapon bowTest = new Bow(10,10);
        IWeapon knifeTest = new Knife(10,10);
        IWeapon swordTest = new Sword(10,10);
        IWeapon staffTest = new Staff(10,10,10);


        assertNull(whiteMage1.getEquippedWeapon());

        whiteMage1.equipWeapon(axeTest);
        assertNull(whiteMage1.getEquippedWeapon());

        whiteMage1.equipWeapon(swordTest);
        assertNull(whiteMage1.getEquippedWeapon());

        whiteMage1.equipWeapon(bowTest);
        assertNull(whiteMage1.getEquippedWeapon());

        whiteMage1.equipWeapon(knifeTest);
        assertNull(whiteMage1.getEquippedWeapon());

        whiteMage1.equipWeapon(staffTest);
        assertEquals(whiteMage1.getEquippedWeapon(), staffTest);

        IPlayerCharacter whiteMage2 = new WhiteMage(turns, "hola",0,0,0);
        whiteMage2.equipWeapon(staffTest);
        assertNull(whiteMage2.getEquippedWeapon());

    }

    @Test
    void attackTest(){
        IMagicPlayerCharacter whiteMage1 = new WhiteMage(turns, "hola", 20,10,10);
        //weapon Damage = 15
        whiteMage1.equipWeapon(testWeapon);
        ICharacter enemy = new Enemy(turns,"hola",15,5,10,10);
        whiteMage1.attack(enemy);
        assertEquals(enemy.getHealth(),5);
        whiteMage1.attack(enemy);
        assertEquals(enemy.getHealth(),0);
        enemy.attack(whiteMage1);

    }
}
