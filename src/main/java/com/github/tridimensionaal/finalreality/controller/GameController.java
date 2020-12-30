package com.github.tridimensionaal.finalreality.controller;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.*;
import com.github.tridimensionaal.finalreality.model.character.enemy.*;

import com.github.tridimensionaal.finalreality.controller.handlers.*;
import com.github.tridimensionaal.finalreality.controller.phases.*;
import com.github.tridimensionaal.finalreality.controller.factory.weapon.*;
import com.github.tridimensionaal.finalreality.controller.factory.character.*;

import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
  private final LinkedList<IPlayerCharacter> playerCharacter = new LinkedList<>();
  private final LinkedList<ICharacter> enemyCharacter = new LinkedList<>();
  private final LinkedList<IWeapon> playerInventory = new LinkedList<>();
  private Phase phase;

  BlockingQueue<ICharacter> queue = new LinkedBlockingQueue<>();

  private final IEventHandler playerCharacterIsDeadHandler = new PlayerCharacterIsDeadHandler(this);
  private final IEventHandler enemyIsDeadHandler = new EnemyIsDeadHandler(this);

  private ICharacter actualCharacter;

  public GameController() {
      this.setPhase(new InitialPhase());
  }

  public void setPhase(Phase phase){
      this.phase = phase;
      phase.setController(this);
  }

    /**
     * @return this game's queue.
     */
    public BlockingQueue<ICharacter> getQueue(){
        return queue;
    }

    /**
     * @return this player's inventory size.
     */
    public int getPlayerInventorySize(){
        return playerInventory.size();
    }

    /**
     * @return this player's character list size.
     * */
    public int getPlayerCharacterSize(){
      return playerCharacter.size();
  }

  /**
   * @return this enemy's character list size.
   */
  public int getEnemyCharacterSize(){
        return enemyCharacter.size();
    }

    /**
     * @param i index of the list
     * @return the element in the index i of this player's inventory list.
     *
     */
    public IWeapon getPlayerInventoryElement(int i){
        return playerInventory.get(i);
    }

    /**
    * @param i index of the list
    * @return the element in the index i of this player's character list.
     */
    public IPlayerCharacter getPlayerCharacterElement(int i){
        return playerCharacter.get(i);
    }

    /**
     * @param i index of the list
     * @return the element in the index i of this enemy's character list.
     */
    public ICharacter getEnemyCharacterElement(int i){
        return enemyCharacter.get(i);
    }


    /**
     * @param i index of the list
     * @return the damage of the element in the index i of this player's inventory list.
     */
    public int getInventoryElementDamage(int i){
        return playerInventory.get(i).getDamage();
    }

    /**
     * @param i index of the list
     * @return the weight of the element in the index i of this player's inventory list.
     */
    public int getInventoryElementWeight(int i){
        return playerInventory.get(i).getWeight();
    }

    /**
     * @param i index of the list
     * @return the name of the element in the index i of this player's character list.
     */
    public String getPlayerCharacterElementName(int i){
        return playerCharacter.get(i).getName();
    }

    /**
     * @param i index of the list
     * @return the health of the element in the index i of this player's character list.
     */
    public int getPlayerCharacterElementHealth(int i){
        return playerCharacter.get(i).getHealth();
    }

    /**
     * @param i index of the list
     * @return the defense of the element in the index i of this enemy's character list.
     */
    public int getPlayerCharacterElementDefense(int i){
        return playerCharacter.get(i).getDefense();
    }

    /**
     * @param i index of the list
     * @return the name of the element in the index i of this enemy's character list.
     */
    public String getEnemyCharacterElementName(int i){
        return enemyCharacter.get(i).getName();
    }

    /**
     * @param i index of the list
     * @return the health of the element in the index i of this enemy's character list.
     */
    public int getEnemyCharacterElementHealth(int i){
        return enemyCharacter.get(i).getHealth();
    }

    /**
     * @param i index of the list
     * @return the defense of the element in the index i of this enemy's character list.
     */
    public int getEnemyCharacterElementDefense(int i){
        return enemyCharacter.get(i).getDefense();
    }

    /**
     * @param i index of the list
     * @return the weight of the element in the index i of this enemy's character list.
     */
    public int getEnemyCharacterElementWeight(int i){
        Enemy enemy = (Enemy) enemyCharacter.get(i);
        return enemy.getWeight();
    }

    /**
     * @param i index of the list
     * @return the damage of the element in the index i of this enemy's character list.
     */
    public int getEnemyCharacterElementDamage(int i){
        Enemy enemy = (Enemy) enemyCharacter.get(i);
        return enemy.getDamage();
    }

  /**
   * Creates a new axe
   *
   * @return the new created axe
   */
  public IWeapon createAxe(){
      return new AxeFactory().createWeapon();
  }

 /**
   * Creates a new bow
   *
   * @return the new created bow
   */
  public IWeapon createBow(){
      return new BowFactory().createWeapon();
  }

 /**
   * Creates a new knife
   *
   * @return the new created knife
   */
  public IWeapon createKnife(){
      return new KnifeFactory().createWeapon();
  }

 /**
   * Creates a new sword
   *
   * @return the new created sword
   */
  public IWeapon createSword(){
      return new SwordFactory().createWeapon();
  }

  /**
   * Creates a new staff
   *
   * @return the new created staff
   */
  public IWeapon createStaff(){
      return new StaffFactory().createWeapon();
  }

  /**
   * Adds a weapon to the player's inventory
   * @param weapon to put in the inventory
   */
  public void addWeaponToInventory(IWeapon weapon){
      playerInventory.add(weapon);
  }

  /**
   * Creates a new enemy
   * @param name of new the enemy
   *
   * @return the enemy
   */
  public ICharacter createEnemy(String name){
      return new EnemyFactory(name, this.getQueue()).createCharacter();
  }

  /**
   * Adds a new enemy to the enemy's character list
   * @param enemy to put in the list
   */
  public void addEnemy(ICharacter enemy){
      enemy.addListener(enemyIsDeadHandler);
      enemyCharacter.add(enemy);
  }

  /**
   * Creates a new engineer
   * @param name of the new engineer
   *
   * @return the new engineer
   */
  public IPlayerCharacter createEngineer(String name){
      return (IPlayerCharacter) new EngineerFactory(name, this.getQueue()).createCharacter();
  }

  /**
   * Creates a new knight
   * @param name of the new knight
   *
   * @return the new knight
   */
  public IPlayerCharacter createKnight(String name){
      return (IPlayerCharacter) new KnightFactory(name, this.getQueue()).createCharacter();
  }

  /**
   * Creates a new thief
   * @param name of the new thief
   *
   * @return the new thief
   */
  public IPlayerCharacter createThief(String name){
      return (IPlayerCharacter) new ThiefFactory(name, this.getQueue()).createCharacter();
  }

  /**
   * Creates a new black mage
   * @param name of the new black mage
   *
   * @return the new black mage
   */
  public IPlayerCharacter createBlackMage(String name){
      return (IPlayerCharacter) new BlackMageFactory(name, this.getQueue()).createCharacter();
  }

  /**
   * Creates a new white mage
   * @param name of the new white mage
   *
   * @return the new white mage
   */

  public IPlayerCharacter createWhiteMage(String name){
      return (IPlayerCharacter) new WhiteMageFactory(name, this.getQueue()).createCharacter();
  }

  /**
   * Adds a new player character to the player's character list
   * @param character to put in the list
   */
  public void addPlayerCharacter(IPlayerCharacter character){
      character.addListener(playerCharacterIsDeadHandler);
      playerCharacter.add(character);
  }

  /**
   * Sets a character as the actual character.
   * @param character (the new actual character)
   */
  public void setActualCharacter(ICharacter character){
      actualCharacter = character;
  }

  /**
   * Gets the actual the actual character.
   * @return actual character
   */
  public ICharacter getActualCharacter(){
      return actualCharacter;
  }

  /**
   * Equips a new weapon to the actual character. 
   * @param weapon to be equipped by the actual character
   */
  public void equipWeapon(IWeapon weapon){
      IPlayerCharacter character = (IPlayerCharacter) actualCharacter;
      IWeapon characterWeapon = character.getEquippedWeapon();

      character.equipWeapon(weapon);
      if(character.getEquippedWeapon()==null){
          return;
      }
      if (character.getEquippedWeapon().equals(characterWeapon)){
          return;
      }

      else{
          playerInventory.remove(weapon);
          if (characterWeapon != null){
              addWeaponToInventory(characterWeapon);
          }
      }
  }
    /**
     * Method that add all the characters of the game to the queue.
     */
    public void addToQueue(){

      for (ICharacter enemy: enemyCharacter) {
          enemy.waitTurn();
      }

      for (IPlayerCharacter character: playerCharacter){
          character.waitTurn();
      }

  }
  /**
   * The actual character attacks a character 
   * @param character the character to be attacked by the actual character
   */
  public void attack(ICharacter character){
      actualCharacter.attack(character);
  }

  public void playerHasWin(){
  }

  public void enemyHasWin(){
  }
    /**
     * Removes a player's character from the player's characters list when it dies.
     * @param character the character to remove from the player's character list
     */
    public void onPlayerCharacterHasDied(IPlayerCharacter character) {
      playerCharacter.remove(character);
      if (getPlayerCharacterSize() == 0){
          enemyHasWin();
      }
  }
    /**
     * Removes a enemy's character from the enemy's characters list when it dies.
     * @param character the character to remove from the enemy's characters list
     */
    public void onEnemyHasDied(ICharacter character) {
      enemyCharacter.remove(character);
      if (getEnemyCharacterSize() == 0){
          playerHasWin();
      }
  }
}
