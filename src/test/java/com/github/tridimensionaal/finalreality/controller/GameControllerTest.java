package com.github.tridimensionaal.finalreality.controller;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.enemy.Enemy;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.magic.Staff;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Axe;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Bow;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Knife;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * A class that tests the class GameController
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see GameController 
 */

class GameControllerTest {
    private GameController gameControllerTest;

    private final int WEAPON_DAMAGE= 10;
    private final int WEAPON_WEIGHT = 10;
    private final int WEAPON_MAGIC_DAMAGE = 10;

    private IWeapon axeTest;
    private IWeapon bowTest;
    private IWeapon knifeTest;
    private IWeapon swordTest;
    private IWeapon staffTest;

    private  final String ENEMY_NAME = "enemy";
    private final int ENEMY_HEALTH= 10;
    private final int ENEMY_DEFENSE = 10;
    private final int ENEMY_DAMAGE = 10;
    private final int ENEMY_WEIGHT = 10;

    private ICharacter enemy1Test;
    private ICharacter enemy2Test;
    private ICharacter enemy3Test;

    @BeforeEach
    void setUp() {
        gameControllerTest = new GameController();

        axeTest = gameControllerTest.createAxe(WEAPON_DAMAGE,WEAPON_WEIGHT);
        bowTest = gameControllerTest.createBow(WEAPON_DAMAGE,WEAPON_WEIGHT);
        knifeTest = gameControllerTest.createKnife(WEAPON_DAMAGE, WEAPON_WEIGHT);
        swordTest = gameControllerTest.createSword(WEAPON_DAMAGE,WEAPON_WEIGHT);
        staffTest = gameControllerTest.createStaff(WEAPON_DAMAGE,WEAPON_WEIGHT,WEAPON_MAGIC_DAMAGE);

        enemy1Test = gameControllerTest.createEnemy(ENEMY_NAME + "1", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_DAMAGE, ENEMY_WEIGHT);
        enemy2Test =  gameControllerTest.createEnemy(ENEMY_NAME + "2", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_DAMAGE, ENEMY_WEIGHT);
        enemy3Test =  gameControllerTest.createEnemy(ENEMY_NAME + "3", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_DAMAGE, ENEMY_WEIGHT);
    }
    @Test
    void checkConstruction() {
        assertTrue(gameControllerTest.getEnemyCharacter().isEmpty());
        assertTrue(gameControllerTest.getPlayerCharacter().isEmpty());
        assertTrue(gameControllerTest.getPlayerInventory().isEmpty());
    }
    @Test
    void createWeapons() {
        assertEquals(axeTest, new Axe(WEAPON_DAMAGE,WEAPON_WEIGHT));

        assertEquals(bowTest, new Bow(WEAPON_DAMAGE,WEAPON_WEIGHT));

        assertEquals(knifeTest, new Knife(WEAPON_DAMAGE, WEAPON_WEIGHT));

        assertEquals(swordTest, new Sword(WEAPON_DAMAGE,WEAPON_WEIGHT));

        assertEquals(staffTest, new Staff(WEAPON_DAMAGE,WEAPON_WEIGHT,WEAPON_MAGIC_DAMAGE));

    }
    @Test
    void addToInventory() {
        assertTrue(gameControllerTest.getPlayerInventory().isEmpty());

        gameControllerTest.addWeaponToInventory(axeTest);
        assertEquals(gameControllerTest.getPlayerInventory().size(),1);

        gameControllerTest.addWeaponToInventory(bowTest);
        assertEquals(gameControllerTest.getPlayerInventory().size(),2);

        gameControllerTest.addWeaponToInventory(knifeTest);
        assertEquals(gameControllerTest.getPlayerInventory().size(),3);

        gameControllerTest.addWeaponToInventory(swordTest);
        assertEquals(gameControllerTest.getPlayerInventory().size(),4);

        gameControllerTest.addWeaponToInventory(staffTest);
        assertEquals(gameControllerTest.getPlayerInventory().size(),5);

    }
    @Test
    void createEnemy() {
        assertEquals(enemy1Test, new Enemy(gameControllerTest.getQueue(), ENEMY_NAME+"1", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_DAMAGE,ENEMY_WEIGHT));

        assertEquals(enemy2Test, new Enemy(gameControllerTest.getQueue(), ENEMY_NAME+"2", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_DAMAGE,ENEMY_WEIGHT));

        assertEquals(enemy3Test, new Enemy(gameControllerTest.getQueue(), ENEMY_NAME+"3", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_DAMAGE,ENEMY_WEIGHT));
    }
    @Test
    void addEnemy() {
        assertTrue(gameControllerTest.getEnemyCharacter().isEmpty());

        gameControllerTest.addEnemy(enemy1Test);
        assertEquals(gameControllerTest.getEnemyCharacter().size(),1);

        gameControllerTest.addEnemy(enemy2Test);
        assertEquals(gameControllerTest.getEnemyCharacter().size(),2);

        gameControllerTest.addEnemy(enemy3Test);
        assertEquals(gameControllerTest.getEnemyCharacter().size(),3);

    }


}


