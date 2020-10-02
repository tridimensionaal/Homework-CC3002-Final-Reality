package com.github.tridimensionaal.finalreality.model.character;


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
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's health points.
   */
  int getHealth();

  /**
   * Returns this character's defense points.
   */
  int getDefense();
}
