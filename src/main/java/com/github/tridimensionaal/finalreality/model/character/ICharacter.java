package com.github.tridimensionaal.finalreality.model.character;

import com.github.tridimensionaal.finalreality.controller.handlers.IEventHandler;



/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil 
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Adds this character to the turns queue.
   */
  void addToQueue();

  /**
   * @return this character's name.
   */
  String getName();

  /**
   * @return this character's health points.
   */
  int getHealth();

  /**
   * @return this character's defense points.
   */
  int getDefense();

   /**
   * @param o An object
   * @return True if this character is the same that object o or False if this character is not the same that object o.
   */
  boolean equals(Object o);

  /**
   * @return This character's hash code. 
   */
  int hashCode();

  /**
   * Attacks the ICharacter character 
   * @param character 
   */
  void attack(ICharacter character);

  /**
   * Receives damage
   * @param damage
   */
  void receiveDamage(int damage);

  /**
   * @return True is this character is dead or false otherwise. A character is dead if they health is 0. 
   */
  boolean isDead();

  boolean isPlayerCharacter();

  /**
   * Sets to zero the health of this character
   */
  void hasDied();

  /**
   * Sets the 
   * @param handler
   */
  void addListener(IEventHandler handler);

}

