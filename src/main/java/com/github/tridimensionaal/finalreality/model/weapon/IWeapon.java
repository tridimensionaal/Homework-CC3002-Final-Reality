package com.github.tridimensionaal.finalreality.model.weapon;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public interface IWeapon{

  /**
   * Returns this weapon's name.
   */
  String getName();

  /**
   * Returns this weapon's damage.
   */
  int getDamage();

  /**
   * Returns this weapon's weight.
   */
  int getWeight();

  /**
   * 
   */
  boolean equals(Object o);

  /**
   * 
   */
  int hashCode();
}
