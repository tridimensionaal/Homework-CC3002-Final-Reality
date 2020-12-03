
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

  public LinkedList<IPlayerCharacter> getPlayerCharacter(){
      return playerCharacter;

  }
  public LinkedList<ICharacter> getEnemyCharacter(){
        return enemyCharacter;

    }
    public LinkedList<IWeapon> getPlayerInventory(){
      return playerInventory;
    }

    public BlockingQueue<ICharacter> getQueue(){
        return queue;
    }


    /**
   * Creates a axe
   */
  public IWeapon createAxe(int damage, int weight){
      return new Axe(damage, weight);
  }

  /**
   * Creates a bow
   */
  public IWeapon createBow(int damage, int weight){
      return new Bow(damage, weight);
  }

  /**
   * Creates a knife
   */
  public IWeapon createKnife(int damage, int weight){
      return new Knife(damage, weight);
  }

  /**
   * Creates a sword
   */
  public IWeapon createSword(int damage, int weight){
      return new Sword(damage, weight);
  }

  /**
   * Creates a staff
   */
  public IWeapon createStaff(int damage, int weight, int magicDamage){
      return new Staff(damage, weight,magicDamage);
  }

  /**
   * Adds a weapon to the player's inventory
   */
  public void addWeaponToInventory(IWeapon weapon){
      playerInventory.add(weapon);
  }

  /**
   * Creates a new enemy
   * @param name
   * @param health
   * @param defense
   * @param weight
   * @param damage
   */
  public ICharacter createEnemy(String name, int health, int defense, int weight, int damage ){
      return new Enemy(queue,name,health,defense,weight,damage);
  }

  /**
   * Adds a new enemy to the enemy's character list
   */
  public void addEnemy(ICharacter enemy){
      enemy.addListener(enemyIsDeadHandler);
      enemyCharacter.add(enemy);
  }

  /**
   * Creates a new engineer
   */
  public IPlayerCharacter createEngineer(String name, int health, int defense){
      return new Engineer(queue,name,health, defense );
  }

  /**
   * Creates a new knight
   */
  public IPlayerCharacter createKnight(String name, int health, int defense){
      return new Knight(queue,name,health, defense );
  }

  /**
   * Creates a new thief
   */
  public IPlayerCharacter createThief(String name, int health, int defense){
      return new Thief(queue,name,health, defense );
  }

  /**
   * Creates a new black mage
   */
  public IPlayerCharacter createBlackMage(String name, int health, int defense, int mana){
      return new BlackMage(queue,name,health, defense, mana);
  }

  /**
   * Creates a new white mage
   */
  public IPlayerCharacter createWhiteMage(String name, int health, int defense, int mana){
      return new WhiteMage(queue,name,health, defense,mana);
  }

  /**
   * Adds a new player character to the player's character list
   */
  public void addPlayerCharacter(IPlayerCharacter character){
      character.addListener(playerCharacterIsDeadHandler);
      playerCharacter.add(character);
  }

  public void setActualCharacter(ICharacter character){
      actualCharacter = character;
  }

  public ICharacter getActualCharacter(){
      return actualCharacter;
  }



  /**
   * Equips a new weapon to the actual character. 
   * @param weapon
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

  public void turns(){
      int large1 = enemyCharacter.size();
      int large2 = playerCharacter.size();

      for (int i = 0; i < large1; i++){
          enemyCharacter.get(i).waitTurn();
      }

      for (int i = 0; i < large2; i++){
          playerCharacter.get(i).waitTurn();
      }

      while(!queue.isEmpty()){
          var character = queue.poll();
      }
  }

  /**
   * The actual character attacks a character 
   * @param character 
   */
  public void attack(ICharacter character){
      actualCharacter.attack(character);
  }

  public void playerHasWin(){
  }

  public void enemyHasWin(){
  }

  public void onPlayerCharacterHasDied(IPlayerCharacter character) {
      playerCharacter.remove(character);
      if (playerCharacter.size() == 0){
          enemyHasWin();
      }
  }

  public void onEnemyHasDied(ICharacter character) {
      enemyCharacter.remove(character);
      if (enemyCharacter.size() == 0){
          playerHasWin();
      }
  }
}
