
package com.github.tridimensionaal.finalreality.controller;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.*;
import com.github.tridimensionaal.finalreality.model.character.enemy.*;
import com.github.tridimensionaal.finalreality.model.character.player.magic.*;
import com.github.tridimensionaal.finalreality.model.character.player.normal.*;

import com.github.tridimensionaal.finalreality.controller.handlers.*;

import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.*;
import com.github.tridimensionaal.finalreality.model.weapon.magic.*;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
  private final LinkedList<IPlayerCharacter> playerCharacter = new LinkedList<>();
  private final LinkedList<ICharacter> enemyCharacter = new LinkedList<>();
  private final LinkedList<IWeapon> playerInventory = new LinkedList<>();

  BlockingQueue<ICharacter> queue = new LinkedBlockingQueue<>();

  private final IEventHandler playerCharacterIsDeadHandler = new PlayerCharacterIsDeadHandler(this);
  private final IEventHandler enemyIsDeadHandler = new EnemyIsDeadHandler(this);

  private ICharacter actualCharacter;

  public GameController() {
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
   * @param damage of the axe
   * @param weight of the axe
   *
   * @return  the axe
   */
  public IWeapon createAxe(int damage, int weight){
      return new Axe(damage, weight);
  }

  /**
   * Creates a new bow
   * @param damage of the bow
   * @param weight of the bow
   *
   * @return  the bow
   */
  public IWeapon createBow(int damage, int weight){
      return new Bow(damage, weight);
  }

  /**
   * Creates a new knife
   * @param damage of the knife
   * @param weight of the knife
   *
   * @return  the knife
   */
  public IWeapon createKnife(int damage, int weight){
      return new Knife(damage, weight);
  }

  /**
   * Creates a new sword
   * @param damage of the sword
   * @param weight of the sword
   *
   * @return  the sword
   */
  public IWeapon createSword(int damage, int weight){
      return new Sword(damage, weight);
  }

  /**
   * Creates a new staff
   * @param damage of the staff
   * @param weight of the staff
   * @param magicDamage of the staff
   *
   * @return  the staff
   */
  public IWeapon createStaff(int damage, int weight, int magicDamage){
      return new Staff(damage, weight,magicDamage);
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
   * @param name of the enemy
   * @param health of the enemy
   * @param defense of the enemy
   * @param weight of the enemy
   * @param damage of the enemy
   *
   * @return the enemy
   */
  public ICharacter createEnemy(String name, int health, int defense, int weight, int damage ){
      return new Enemy(queue,name,health,defense,weight,damage);
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
   * @param name of the engineer
   * @param health of the engineer
   * @param defense of the engineer
   *
   * @return the engineer
   */
  public IPlayerCharacter createEngineer(String name, int health, int defense){
      return new Engineer(queue,name,health, defense );
  }

  /**
   * Creates a new knight
   * @param name of the knight
   * @param health of the knight
   * @param defense of the knight
   *
   * @return the knight
   */
  public IPlayerCharacter createKnight(String name, int health, int defense){
      return new Knight(queue,name,health, defense );
  }

  /**
   * Creates a new thief
   * @param name of the thief
   * @param health of the thief
   * @param defense of the thief
   *
   * @return the thief
   */
  public IPlayerCharacter createThief(String name, int health, int defense){
      return new Thief(queue,name,health, defense );
  }

  /**
   * Creates a new black mage
   * @param name of the black mage
   * @param health of the black mage
   * @param defense of the black mage
   * @param mana of the black mage
   *
   * @return the black mage
   */
  public IPlayerCharacter createBlackMage(String name, int health, int defense, int mana){
      return new BlackMage(queue,name,health, defense, mana);
  }

  /**
   * Creates a new white mage
   * @param name of the white mage
   * @param health of the white mage
   * @param defense of the white mage
   * @param mana of the white mage
   *
   * @return the white mage
   */
  public IPlayerCharacter createWhiteMage(String name, int health, int defense, int mana){
      return new WhiteMage(queue,name,health, defense,mana);
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
     * Method that handles the logic of one round of turns.
     */
    public void turns(){

      for (ICharacter enemy: enemyCharacter) {
          enemy.waitTurn();
      }

      for (IPlayerCharacter character: playerCharacter){
          character.waitTurn();
      }

      try {
          Thread.sleep(6000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      while(!queue.isEmpty()){
          var character = queue.poll();
          setActualCharacter(character);
          //Do something
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
