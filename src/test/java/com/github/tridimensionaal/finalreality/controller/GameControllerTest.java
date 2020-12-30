package com.github.tridimensionaal.finalreality.controller;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.enemy.Enemy;
import com.github.tridimensionaal.finalreality.model.character.player.IPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.character.player.normal.*;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
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


    private IWeapon axeTest;
    private IWeapon bowTest;
    private IWeapon knifeTest;
    private IWeapon swordTest;
    private IWeapon staffTest;

    private final String ENEMY_NAME = "enemy";
    private final int ENEMY_HEALTH = 25;
    private final int ENEMY_DEFENSE = 5;

    private ICharacter enemy1Test;
    private ICharacter enemy2Test;
    private ICharacter enemy3Test;

    private final String PLAYER_CHARACTER_NAME = "Player's character";
    private final int PLAYER_CHARACTER_HEALTH = 25;
    private final int PLAYER_CHARACTER_DEFENSE = 5;

    private IPlayerCharacter engineerTest;
    private IPlayerCharacter knightTest;
    private IPlayerCharacter thiefTest;
    private IPlayerCharacter blackMageTest;
    private IPlayerCharacter whiteMageTest;

    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        gameControllerTest = new GameController();

        axeTest = gameControllerTest.createAxe();
        bowTest = gameControllerTest.createBow();
        knifeTest = gameControllerTest.createKnife();
        swordTest = gameControllerTest.createSword();
        staffTest = gameControllerTest.createStaff();

        enemy1Test = gameControllerTest.createEnemy(ENEMY_NAME + "1");
        enemy2Test = gameControllerTest.createEnemy(ENEMY_NAME + "2");
        enemy3Test = gameControllerTest.createEnemy(ENEMY_NAME + "3");

        engineerTest = gameControllerTest.createEngineer(PLAYER_CHARACTER_NAME);
        knightTest = gameControllerTest.createKnight(PLAYER_CHARACTER_NAME);
        thiefTest = gameControllerTest.createThief(PLAYER_CHARACTER_NAME);
        blackMageTest = gameControllerTest.createBlackMage(PLAYER_CHARACTER_NAME);
        whiteMageTest = gameControllerTest.createWhiteMage(PLAYER_CHARACTER_NAME);
    }


    /**
     * Checks that the game controller's constructor works properly.
     */
    @Test
    void checkConstructor() {
        assertEquals(gameControllerTest.getEnemyCharacterSize(), 0);
        assertEquals(gameControllerTest.getPlayerCharacterSize(), 0);
        assertEquals(gameControllerTest.getPlayerInventorySize(), 0);
    }

    /**
     * Checks if all the game controller weapon creator methods work properly.
     */
    @RepeatedTest(6 * 2)
    void createWeapon() {
        assertEquals(axeTest, new Axe(axeTest.getDamage(), axeTest.getWeight()));

        assertEquals(bowTest, new Bow(bowTest.getDamage(), bowTest.getWeight()));

        assertEquals(knifeTest, new Knife(knifeTest.getDamage(), knifeTest.getWeight()));

        assertEquals(staffTest, new Staff(staffTest.getDamage(), staffTest.getWeight()));

        assertEquals(swordTest, new Sword(swordTest.getDamage(), swordTest.getWeight()));

    }

    /**
     * Checks that the game controller's add to inventory method works properly.
     */
    @Test
    void addToInventory() {
        assertEquals(gameControllerTest.getPlayerInventorySize(), 0);

        gameControllerTest.addWeaponToInventory(axeTest);
        assertEquals(gameControllerTest.getPlayerInventorySize(), 1);

        gameControllerTest.addWeaponToInventory(bowTest);
        assertEquals(gameControllerTest.getPlayerInventorySize(), 2);

        gameControllerTest.addWeaponToInventory(knifeTest);
        assertEquals(gameControllerTest.getPlayerInventorySize(), 3);

        gameControllerTest.addWeaponToInventory(swordTest);
        assertEquals(gameControllerTest.getPlayerInventorySize(), 4);

        gameControllerTest.addWeaponToInventory(staffTest);
        assertEquals(gameControllerTest.getPlayerInventorySize(), 5);
    }

    /**
     * Checks that the game controller's methods to get stats of a element's inventory works properly.
     */
    @RepeatedTest(2 * 3)
    void getInventoryElementStats() {
        gameControllerTest.addWeaponToInventory(axeTest);

        assertEquals(gameControllerTest.getInventoryElementDamage(0), axeTest.getDamage());
        assertEquals(gameControllerTest.getInventoryElementWeight(0), axeTest.getWeight());
    }

    /**
     * Checks that the game controller's create enemy method works properly.
     */
    @RepeatedTest(5 * 2)
    void createEnemy() {
        Enemy enemy = (Enemy) enemy1Test;
        assertEquals(enemy1Test, new Enemy(gameControllerTest.getQueue(), ENEMY_NAME + "1", ENEMY_HEALTH, ENEMY_DEFENSE, enemy.getWeight(), enemy.getDamage()));

        enemy = (Enemy) enemy2Test;
        assertEquals(enemy2Test, new Enemy(gameControllerTest.getQueue(), ENEMY_NAME + "2", ENEMY_HEALTH, ENEMY_DEFENSE, enemy.getWeight(), enemy.getDamage()));

        enemy = (Enemy) enemy3Test;
        assertEquals(enemy3Test, new Enemy(gameControllerTest.getQueue(), ENEMY_NAME + "3", ENEMY_HEALTH, ENEMY_DEFENSE, enemy.getWeight(), enemy.getDamage()));
    }

    /**
     * Checks that the game controller's add enemy method works properly.
     */
    @Test
    void addEnemy() {
        assertEquals(gameControllerTest.getEnemyCharacterSize(), 0);

        gameControllerTest.addEnemy(enemy1Test);
        assertEquals(gameControllerTest.getEnemyCharacterSize(), 1);

        gameControllerTest.addEnemy(enemy2Test);
        assertEquals(gameControllerTest.getEnemyCharacterSize(), 2);

        gameControllerTest.addEnemy(enemy3Test);
        assertEquals(gameControllerTest.getEnemyCharacterSize(), 3);
    }

    /**
     * Checks that the game controller's methods to get enemy's character stats works properly.
     */
    @RepeatedTest(5 * 2)
    void getEnemyCharacter() {
        gameControllerTest.addEnemy(enemy1Test);
        Enemy enemy = (Enemy) enemy1Test;
        assertEquals(gameControllerTest.getEnemyCharacterElementName(0), ENEMY_NAME + "1");
        assertEquals(gameControllerTest.getEnemyCharacterElementHealth(0), ENEMY_HEALTH);
        assertEquals(gameControllerTest.getEnemyCharacterElementDefense(0), ENEMY_DEFENSE);
        assertEquals(gameControllerTest.getEnemyCharacterElementWeight(0), enemy.getWeight());
        assertEquals(gameControllerTest.getEnemyCharacterElementDamage(0), enemy.getDamage());
    }

    /**
     * Checks if all the game controller player character creator methods work properly.
     */
    @Test
    void createPlayerCharacter() {
        assertEquals(engineerTest, new Engineer(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE));

        assertEquals(knightTest, new Knight(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE));

        assertEquals(thiefTest, new Thief(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE));

        assertEquals(blackMageTest, new BlackMage(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE));

        assertEquals(whiteMageTest, new WhiteMage(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE));
    }

    /**
     * Checks that the game controller's add enemy method works properly.
     */
    @Test
    void addPlayerCharacter() {
        assertEquals(gameControllerTest.getPlayerCharacterSize(), 0);

        gameControllerTest.addPlayerCharacter(engineerTest);
        assertEquals(gameControllerTest.getPlayerCharacterSize(), 1);

        gameControllerTest.addPlayerCharacter(knightTest);
        assertEquals(gameControllerTest.getPlayerCharacterSize(), 2);

        gameControllerTest.addPlayerCharacter(thiefTest);
        assertEquals(gameControllerTest.getPlayerCharacterSize(), 3);

        gameControllerTest.addPlayerCharacter(blackMageTest);
        assertEquals(gameControllerTest.getPlayerCharacterSize(), 4);

        gameControllerTest.addPlayerCharacter(whiteMageTest);
        assertEquals(gameControllerTest.getPlayerCharacterSize(), 5);

    }

    /**
     * Checks that the game controller's methods to get player's character stats works properly.
     */
    @Test
    void getPlayerCharacter() {
        gameControllerTest.addPlayerCharacter(engineerTest);

        assertEquals(gameControllerTest.getPlayerCharacterElementName(0), PLAYER_CHARACTER_NAME);
        assertEquals(gameControllerTest.getPlayerCharacterElementHealth(0), PLAYER_CHARACTER_HEALTH);
        assertEquals(gameControllerTest.getPlayerCharacterElementDefense(0), PLAYER_CHARACTER_DEFENSE);
    }

    /**
     * Checks that the game controller's equip weapon method works properly.
     */
    @Test
    void equipWeapon() {
        gameControllerTest.setActualCharacter(engineerTest);
        IPlayerCharacter actual = (IPlayerCharacter) gameControllerTest.getActualCharacter();
        assertEquals(engineerTest, actual);

        gameControllerTest.addWeaponToInventory(staffTest);
        gameControllerTest.equipWeapon(gameControllerTest.getPlayerInventoryElement(0));
        actual = (IPlayerCharacter) gameControllerTest.getActualCharacter();
        assertNull(actual.getEquippedWeapon());

        gameControllerTest.addWeaponToInventory(bowTest);
        gameControllerTest.equipWeapon(gameControllerTest.getPlayerInventoryElement(1));
        actual = (IPlayerCharacter) gameControllerTest.getActualCharacter();
        assertEquals(actual.getEquippedWeapon(), bowTest);

        gameControllerTest.addWeaponToInventory(axeTest);
        gameControllerTest.equipWeapon(gameControllerTest.getPlayerInventoryElement(1));
        actual = (IPlayerCharacter) gameControllerTest.getActualCharacter();
        assertEquals(actual.getEquippedWeapon(), axeTest);

    }

    /**
     * Checks that the game controller's attack method works properly.
     */
    @Test
    void attack() {
        Enemy enemy1 = new Enemy(gameControllerTest.getQueue(), "aa", 10, 10, 10, 15);
        Enemy enemy2 = new Enemy(gameControllerTest.getQueue(), "a", 10, 10, 10, 15);
        IPlayerCharacter engineer = new Engineer(gameControllerTest.getQueue(), "a", 10, 10);
        gameControllerTest.addPlayerCharacter(engineer);
        gameControllerTest.addEnemy(enemy1);
        gameControllerTest.addEnemy(enemy2);

        ICharacter actual = gameControllerTest.getPlayerCharacterElement(0);
        gameControllerTest.setActualCharacter(actual);
        gameControllerTest.equipWeapon(new Bow(15, 10));

        //Player's character attacks enemy1
        gameControllerTest.attack(gameControllerTest.getEnemyCharacterElement(0));
        assertEquals(gameControllerTest.getEnemyCharacterElementHealth(0), 5);

        //enemy1 died
        gameControllerTest.attack(gameControllerTest.getEnemyCharacterElement(0));
        assertEquals(gameControllerTest.getEnemyCharacterSize(), 1);

        //Player's character attacks enemy2
        gameControllerTest.attack(gameControllerTest.getEnemyCharacterElement(0));
        assertEquals(gameControllerTest.getEnemyCharacterElementHealth(0), 5);

        //enemy2 died
        gameControllerTest.attack(gameControllerTest.getEnemyCharacterElement(0));
        assertEquals(gameControllerTest.getEnemyCharacterSize(), 0);

        Enemy enemy3 = new Enemy(gameControllerTest.getQueue(), "a", 10, 10, 10, 15);
        gameControllerTest.addEnemy(enemy3);

        IPlayerCharacter knight = new Knight(gameControllerTest.getQueue(), "a", 10, 10);
        gameControllerTest.addPlayerCharacter(knight);

        actual = gameControllerTest.getEnemyCharacterElement(0);
        gameControllerTest.setActualCharacter(actual);


        //Enemy attacks player's character1
        gameControllerTest.attack(gameControllerTest.getPlayerCharacterElement(0));
        assertEquals(gameControllerTest.getPlayerCharacterElementHealth(0), 5);

        //player's character1 died
        gameControllerTest.attack(gameControllerTest.getPlayerCharacterElement(0));
        assertEquals(gameControllerTest.getPlayerCharacterSize(), 1);

        //Enemy attacks player's character1
        gameControllerTest.attack(gameControllerTest.getPlayerCharacterElement(0));
        assertEquals(gameControllerTest.getPlayerCharacterElementHealth(0), 5);

        //player's character1 died
        gameControllerTest.attack(gameControllerTest.getPlayerCharacterElement(0));
        assertEquals(gameControllerTest.getPlayerCharacterSize(), 0);

    }

    @Test
    void addToQueueTest() {
        gameControllerTest.addEnemy(enemy1Test);
        gameControllerTest.addEnemy(enemy2Test);

        whiteMageTest.equipWeapon(staffTest);
        knightTest.equipWeapon(swordTest);
        thiefTest.equipWeapon(bowTest);

        gameControllerTest.addPlayerCharacter(whiteMageTest);
        gameControllerTest.addPlayerCharacter(knightTest);
        gameControllerTest.addPlayerCharacter(thiefTest);

        gameControllerTest.addToQueue();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(gameControllerTest.getQueueSize(), 5);

        gameControllerTest.pollQueue();
        assertNotNull(gameControllerTest.getActualCharacter());
        assertEquals(gameControllerTest.getQueueSize(), 4);

        gameControllerTest.pollQueue();
        assertNotNull(gameControllerTest.getActualCharacter());
        assertEquals(gameControllerTest.getQueueSize(), 3);

        gameControllerTest.pollQueue();
        assertNotNull(gameControllerTest.getActualCharacter());
        assertEquals(gameControllerTest.getQueueSize(), 2);

        gameControllerTest.pollQueue();
        assertNotNull(gameControllerTest.getActualCharacter());
        assertEquals(gameControllerTest.getQueueSize(), 1);

        gameControllerTest.pollQueue();
        assertNotNull(gameControllerTest.getActualCharacter());
        assertEquals(gameControllerTest.getQueueSize(), 0);

    }
}




