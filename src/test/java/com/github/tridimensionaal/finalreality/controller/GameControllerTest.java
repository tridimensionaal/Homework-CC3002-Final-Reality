package com.github.tridimensionaal.finalreality.controller;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.enemy.Enemy;
import com.github.tridimensionaal.finalreality.model.character.player.IPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.character.player.magic.BlackMage;
import com.github.tridimensionaal.finalreality.model.character.player.magic.WhiteMage;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Engineer;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Knight;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Thief;
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

    private final int WEAPON_DAMAGE= 15;
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
    private final int ENEMY_DAMAGE = 15;
    private final int ENEMY_WEIGHT = 10;

    private ICharacter enemy1Test;
    private ICharacter enemy2Test;
    private ICharacter enemy3Test;

    private  final String PLAYER_CHARACTER_NAME = "Player's character";
    private final int PLAYER_CHARACTER_HEALTH= 10;
    private final int PLAYER_CHARACTER_DEFENSE = 10;
    private final int PLAYER_CHARACTER_MANA = 10;

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

        axeTest = gameControllerTest.createAxe(WEAPON_DAMAGE,WEAPON_WEIGHT);
        bowTest = gameControllerTest.createBow(WEAPON_DAMAGE,WEAPON_WEIGHT);
        knifeTest = gameControllerTest.createKnife(WEAPON_DAMAGE, WEAPON_WEIGHT);
        swordTest = gameControllerTest.createSword(WEAPON_DAMAGE,WEAPON_WEIGHT);
        staffTest = gameControllerTest.createStaff(WEAPON_DAMAGE,WEAPON_WEIGHT,WEAPON_MAGIC_DAMAGE);

        enemy1Test = gameControllerTest.createEnemy(ENEMY_NAME + "1", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE);
        enemy2Test =  gameControllerTest.createEnemy(ENEMY_NAME + "2", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE);
        enemy3Test =  gameControllerTest.createEnemy(ENEMY_NAME + "3", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE);

        engineerTest = gameControllerTest.createEngineer(PLAYER_CHARACTER_NAME,PLAYER_CHARACTER_HEALTH,PLAYER_CHARACTER_DEFENSE);
        knightTest= gameControllerTest.createKnight(PLAYER_CHARACTER_NAME,PLAYER_CHARACTER_HEALTH,PLAYER_CHARACTER_DEFENSE);
        thiefTest = gameControllerTest.createThief(PLAYER_CHARACTER_NAME,PLAYER_CHARACTER_HEALTH,PLAYER_CHARACTER_DEFENSE);
        blackMageTest = gameControllerTest.createBlackMage(PLAYER_CHARACTER_NAME,PLAYER_CHARACTER_HEALTH,PLAYER_CHARACTER_DEFENSE,PLAYER_CHARACTER_MANA);
        whiteMageTest= gameControllerTest.createWhiteMage(PLAYER_CHARACTER_NAME,PLAYER_CHARACTER_HEALTH,PLAYER_CHARACTER_DEFENSE,PLAYER_CHARACTER_MANA);
    }
  
    
    /**
     * Checks that the game controller's constructor workds properly.
     */
    @Test
    void checkConstructor() {
        assertTrue(gameControllerTest.getEnemyCharacter().isEmpty());
        assertTrue(gameControllerTest.getPlayerCharacter().isEmpty());
        assertTrue(gameControllerTest.getPlayerInventory().isEmpty());
    }

    /**
     * Checks if all the game controller weapon creator methods work properly.
     */
    @Test
    void createWeapon() {
        assertEquals(axeTest, new Axe(WEAPON_DAMAGE,WEAPON_WEIGHT));

        assertEquals(bowTest, new Bow(WEAPON_DAMAGE,WEAPON_WEIGHT));

        assertEquals(knifeTest, new Knife(WEAPON_DAMAGE, WEAPON_WEIGHT));

        assertEquals(swordTest, new Sword(WEAPON_DAMAGE,WEAPON_WEIGHT));

        assertEquals(staffTest, new Staff(WEAPON_DAMAGE,WEAPON_WEIGHT,WEAPON_MAGIC_DAMAGE));

    }

    /**
     * Checks that the game controller's add to inventory method workds properly.
     */
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

    /**
     * Checks that the game controller's create enemy method workds properly.
     */
    @Test
    void createEnemy() {
        assertEquals(enemy1Test, new Enemy(gameControllerTest.getQueue(), ENEMY_NAME+"1", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_WEIGHT,ENEMY_DAMAGE));

        assertEquals(enemy2Test, new Enemy(gameControllerTest.getQueue(), ENEMY_NAME+"2", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_WEIGHT,ENEMY_DAMAGE));

        assertEquals(enemy3Test, new Enemy(gameControllerTest.getQueue(), ENEMY_NAME+"3", ENEMY_HEALTH, ENEMY_DEFENSE, ENEMY_WEIGHT,ENEMY_DAMAGE));
    }

    /**
     * Checks that the game controller's add enemy method workds properly.
     */
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

    /**
     * Checks if all the game controller player character creator methods work properly.
     */
    @Test
    void createPlayerCharacter() {
        assertEquals(engineerTest, new Engineer(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE));

        assertEquals(knightTest, new Knight(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE));

        assertEquals(thiefTest, new Thief(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE));

        assertEquals(blackMageTest, new BlackMage(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE, PLAYER_CHARACTER_MANA));

        assertEquals(whiteMageTest, new WhiteMage(gameControllerTest.getQueue(), PLAYER_CHARACTER_NAME, PLAYER_CHARACTER_HEALTH, PLAYER_CHARACTER_DEFENSE, PLAYER_CHARACTER_MANA));
    }

    /**
     * Checks that the game controller's add enemy method workds properly.
     */
    @Test
    void addPlayerCharacter() {
        assertTrue(gameControllerTest.getPlayerCharacter().isEmpty());

        gameControllerTest.addPlayerCharacter(engineerTest);
        assertEquals(gameControllerTest.getPlayerCharacter().size(),1);

        gameControllerTest.addPlayerCharacter(knightTest);
        assertEquals(gameControllerTest.getPlayerCharacter().size(),2);

        gameControllerTest.addPlayerCharacter(thiefTest);
        assertEquals(gameControllerTest.getPlayerCharacter().size(),3);

        gameControllerTest.addPlayerCharacter(blackMageTest);
        assertEquals(gameControllerTest.getPlayerCharacter().size(),4);

        gameControllerTest.addPlayerCharacter(whiteMageTest);
        assertEquals(gameControllerTest.getPlayerCharacter().size(),5);

    }

    /**
     * Checks that the game controller's equip weapon method workds properly.
     */
    @Test
    void equipWeapon() {
        gameControllerTest.setActualCharacter(engineerTest);
        IPlayerCharacter actual = (IPlayerCharacter) gameControllerTest.getActualCharacter();
        assertEquals(engineerTest,actual);

        gameControllerTest.equipWeapon(staffTest);
        actual = (IPlayerCharacter) gameControllerTest.getActualCharacter();
        assertNull(actual.getEquippedWeapon());

        gameControllerTest.equipWeapon(bowTest);
        actual = (IPlayerCharacter) gameControllerTest.getActualCharacter();
        assertEquals(actual.getEquippedWeapon(), bowTest);

        gameControllerTest.equipWeapon(axeTest);
        actual = (IPlayerCharacter) gameControllerTest.getActualCharacter();
        assertEquals(actual.getEquippedWeapon(), axeTest);

        gameControllerTest.equipWeapon(axeTest);
        actual = (IPlayerCharacter) gameControllerTest.getActualCharacter();
        assertEquals(actual.getEquippedWeapon(), axeTest);
    }

    /**
     * Checks that the game controller's attack method works properly.
     */
    @Test
    void attack() {
        gameControllerTest.addPlayerCharacter(engineerTest);
        gameControllerTest.addEnemy(enemy1Test);
        gameControllerTest.addEnemy(enemy2Test);

        ICharacter actual = gameControllerTest.getPlayerCharacter().get(0);
        gameControllerTest.setActualCharacter(actual);
        gameControllerTest.equipWeapon(bowTest);

        //Player's character attacks enemy1
        gameControllerTest.attack(gameControllerTest.getEnemyCharacter().get(0));
        assertEquals(gameControllerTest.getEnemyCharacter().get(0).getHealth(),5);

        //enemy1 died
        gameControllerTest.attack(gameControllerTest.getEnemyCharacter().get(0));
        assertEquals(gameControllerTest.getEnemyCharacter().size(), 1);

        //Player's character attacks enemy2
        gameControllerTest.attack(gameControllerTest.getEnemyCharacter().get(0));
        assertEquals(gameControllerTest.getEnemyCharacter().get(0).getHealth(),5);

        //enemy2 died
        gameControllerTest.attack(gameControllerTest.getEnemyCharacter().get(0));
        assertEquals(gameControllerTest.getEnemyCharacter().size(), 0);

        gameControllerTest.addEnemy(enemy3Test);
        gameControllerTest.addPlayerCharacter(knightTest);

        actual = gameControllerTest.getEnemyCharacter().get(0);
        gameControllerTest.setActualCharacter(actual);


        //Enemy attacks player's character1
        gameControllerTest.attack(gameControllerTest.getPlayerCharacter().get(0));
        assertEquals(gameControllerTest.getPlayerCharacter().get(0).getHealth(),5);

        //player's character1 died
        gameControllerTest.attack(gameControllerTest.getPlayerCharacter().get(0));
        assertEquals(gameControllerTest.getPlayerCharacter().size(), 1);

        //Enemy attacks player's character1
        gameControllerTest.attack(gameControllerTest.getPlayerCharacter().get(0));
        assertEquals(gameControllerTest.getPlayerCharacter().get(0).getHealth(),5);

        //player's character1 died
        gameControllerTest.attack(gameControllerTest.getPlayerCharacter().get(0));
        assertEquals(gameControllerTest.getPlayerCharacter().size(), 0);



    }
    @Test
    void turns() {
        gameControllerTest.addEnemy(enemy1Test);
        gameControllerTest.addEnemy(enemy2Test);

        whiteMageTest.equipWeapon(staffTest);
        knightTest.equipWeapon(swordTest);
        thiefTest.equipWeapon(bowTest);

        gameControllerTest.addPlayerCharacter(whiteMageTest);
        gameControllerTest.addPlayerCharacter(knightTest);
        gameControllerTest.addPlayerCharacter(thiefTest);

        gameControllerTest.turns();

    }
}


