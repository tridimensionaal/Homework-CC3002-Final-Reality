package com.github.tridimensionaal.finalreality.model.character.player;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;


/**
 * This represents a player character from the game.
 *
 * {@inheritDoc}
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil 
 */
public interface IPlayerCharacter extends ICharacter{

  /**
   * @return the actual equipped weapon.
   */
  IWeapon getEquippedWeapon();

  /**
   * Equip a new weapon.
   * @param weapon
   */
  void equipWeapon(IWeapon weapon);

  /**
   * @return the player character's class.
   */
  String getCharacterClass();
}
