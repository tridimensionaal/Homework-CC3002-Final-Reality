
package com.github.tridimensionaal.finalreality.model.controller;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.*;
import com.github.tridimensionaal.finalreality.model.character.enemy.*;
import com.github.tridimensionaal.finalreality.model.character.player.magic.*;
import com.github.tridimensionaal.finalreality.model.character.player.normal.*;

import com.github.tridimensionaal.finalreality.model.controller.handlers.*;

import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.*;
import com.github.tridimensionaal.finalreality.model.weapon.magic.*;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
  private final LinkedList<IPlayerCharacter> playerCharacters = new LinkedList<>();
  private final LinkedList<ICharacter> enemyCharacters = new LinkedList<>();
  private final LinkedList<IWeapon> playerInventory = new LinkedList<>();

  BlockingQueue<ICharacter> queue = new LinkedBlockingQueue<>();

  private final IEventHandler playerCharacterIsDeadHandler = new PlayerCharacterIsDeadHandler(this);
  private final IEventHandler enemyIsDeadHandler = new EnemyIsDeadHandler(this);

  public GameController() {
  }

  public void createAxe(){
      IWeapon axe = new Axe(10,10);
      playerInventory.add(axe);
  }

  public void createBow(){
      IWeapon bow = new Bow(10,10);
      playerInventory.add(bow);
  }

  public void createKnife(){
      IWeapon knife = new Knife(10,10);
      playerInventory.add(knife);
  }

  public void createSword(){
      IWeapon sword = new Sword(10,10);
      playerInventory.add(sword);
  }

  public void createStaff(){
      IWeapon staff = new Staff(10,10,10);
      playerInventory.add(staff);
  }

  public void createEnemy(String name){
      ICharacter enemy = new Enemy(queue,name,10,10,10,10);
      enemyCharacters.add(enemy);
      enemy.addListener(enemyIsDeadHandler);
  }

  public void createEngineer(String name){
      IPlayerCharacter engineer = new Engineer(queue,name,10,10);
      playerCharacters.add(engineer);
      engineer.addListener(playerCharacterIsDeadHandler);
  }

  public void createKnight(String name){
      IPlayerCharacter knight = new Knight(queue,name,10,10);
      playerCharacters.add(knight);
      knight.addListener(playerCharacterIsDeadHandler);
  }

  public void createThief(String name){
      IPlayerCharacter thief = new Thief(queue,name,10,10);
      playerCharacters.add(thief);
      thief.addListener(playerCharacterIsDeadHandler);
  }

  public void createBlackMage(String name){
      IPlayerCharacter blackMage = new BlackMage(queue,name,10,10,10);
      playerCharacters.add(blackMage);
      blackMage.addListener(playerCharacterIsDeadHandler);
  }
  public void createWhiteMage(String name){
      IPlayerCharacter whiteMage = new WhiteMage(queue,name,10,10,10);
      playerCharacters.add(whiteMage);
      whiteMage.addListener(playerCharacterIsDeadHandler);
  }

  public void equipWeapon(IPlayerCharacter character, IWeapon weapon){
      if (character.getEquippedWeapon() == null){
          character.equipWeapon(weapon);
      }

      else{
          IWeapon weapon2 = character.getEquippedWeapon();
          character.equipWeapon(weapon);
          playerInventory.add(weapon2);
      }
      playerInventory.remove(weapon);
  }

  public void attack(ICharacter character, ICharacter character2){
      character.attack(character2);
  }

  public void onPlayerCharacterHasDied(IPlayerCharacter character) {
      playerCharacters.remove(character);
  }
  public void onEnemyHasDied(ICharacter character) {
      enemyCharacters.remove(character);
  }
}
