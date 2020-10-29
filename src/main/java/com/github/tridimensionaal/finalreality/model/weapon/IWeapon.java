package com.github.tridimensionaal.finalreality.model.weapon;

/**
 * This represents a weapon from the game.
 * A weapon can be used only by player's character.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public interface IWeapon {

  /**
   * @return This weapon's name.
   */
  String getName();

  /**
   * @return This weapon's damage.
   */
  int getDamage();

  /**
   * @return This weapon's weight.
   */
  int getWeight();

  /**
   * @param o An object
   * @return True if this weapon is the same that object o or False if this weapon is not the same that object o.
   */

  boolean equals(Object o);

  /**
   * @return This weapon's hash code.
   */
  int hashCode();

  boolean equippedByEngineer();

  boolean equippedByKnight();

  boolean equippedByThief();

  boolean equippedByBlackMage();

  boolean equippedByWhiteMage();
}