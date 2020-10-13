package com.github.tridimensionaal.finalreality.model.weapon;

/**
 * This represents a magic weapon from the game.
 * A weapon can be used only by player's character.
 *
 * {@inheritDoc} 
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public interface IMagicWeapon extends IWeapon{

  /**
   *
   * @return This weapon's magic damage.
   * 
   */
  int getMagicDamage();
}
