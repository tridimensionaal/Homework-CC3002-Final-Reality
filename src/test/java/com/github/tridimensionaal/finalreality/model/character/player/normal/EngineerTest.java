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
 * A class that tests the class Engineer.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Engineer
 */

class EngineerTest extends AbstractPlayerCharacterTest {
    IPlayerCharacter engineer = new Engineer(turns, NAME, HEALTH, DEFENSE);

    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testWeapon = new Axe(15, 10);
        testCharacters.add(new Engineer(turns, NAME, HEALTH, DEFENSE));
    }


    /**
     * Checks that the engineer's constructor and equals method works properly.
     */
    @Test
    void constructorTest() {
        //Same engineer
        IPlayerCharacter engineer1 = new Engineer(turns, NAME, HEALTH, DEFENSE);
        //Different name
        IPlayerCharacter engineer2 = new Engineer(turns, NAME2, HEALTH, DEFENSE);
        //Different health
        IPlayerCharacter engineer3 = new Engineer(turns, NAME, HEALTH2, DEFENSE);
        //Different defense
        IPlayerCharacter engineer4 = new Engineer(turns, NAME, HEALTH, DEFENSE2);
        //Different name and health
        IPlayerCharacter engineer5 = new Engineer(turns, NAME2, HEALTH2, DEFENSE);
        //Different name and defense
        IPlayerCharacter engineer6 = new Engineer(turns, NAME2, HEALTH, DEFENSE2);
        //Different health and defense
        IPlayerCharacter engineer7 = new Engineer(turns, NAME, HEALTH2, DEFENSE2);
        //All different
        IPlayerCharacter engineer8 = new Engineer(turns, NAME2, HEALTH2, DEFENSE2);

        checkConstruction(engineer, engineer1, engineer2, engineer3, engineer4, engineer5, engineer6, engineer7, engineer8);

    }

    /**
     * Checks that the equipWeapon method works properly.
     */
    @Test
    void equipWeaponTest() {
        IPlayerCharacter engineer1 = new Engineer(turns, "hola",10,10);

        IWeapon axeTest = new Axe(10,10);
        IWeapon bowTest = new Bow(10,10);
        IWeapon knifeTest = new Knife(10,10);
        IWeapon swordTest = new Sword(10,10);
        IWeapon staffTest = new Staff(10,10,10);


        assertNull(engineer1.getEquippedWeapon());

        engineer1.equipWeapon(swordTest);
        assertNull(engineer1.getEquippedWeapon());

        engineer1.equipWeapon(knifeTest);
        assertNull(engineer1.getEquippedWeapon());

        engineer1.equipWeapon(staffTest);
        assertNull(engineer1.getEquippedWeapon());

        engineer1.equipWeapon(axeTest);
        assertEquals(engineer1.getEquippedWeapon(), axeTest);

        engineer1.equipWeapon(bowTest);
        assertEquals(engineer1.getEquippedWeapon(), bowTest);

        IPlayerCharacter engineer2 = new Engineer(turns, "hola",0,0);
        engineer2.equipWeapon(bowTest);
        assertNull(engineer2.getEquippedWeapon());



    }

    @Test
    void attackTest(){
        IPlayerCharacter engineer1 = new Engineer(turns, "hola", 20,10);
        //weapon Damage = 15
        engineer1.equipWeapon(testWeapon);
        ICharacter enemy = new Enemy(turns,"hola",15,5,10,10);
        engineer1.attack(enemy);
        assertEquals(enemy.getHealth(),5);
        engineer1.attack(enemy);
        assertEquals(enemy.getHealth(),0);
        enemy.attack(engineer1);

    }
}


