package com.github.tridimensionaal.finalreality.model.weapon.normal;


import com.github.tridimensionaal.finalreality.model.weapon.AbstractWeapon;

/**
 * A class that holds all the information of a single sword.
 *
 * @author Matías Salim Seda Auil
 */


public class Sword extends AbstractWeapon{
  /**
   * Creates a new Sword.
   *
   * {@inheritDoc}
   */

    public Sword( final int damage, final int weight) {
        super("Sword", damage, weight);
  }
  public boolean equippedByEngineer(){
      return false;
  }

  public boolean equippedByKnight(){
      return true;
  }

  public boolean equippedByThief(){
      return true;
  }

  public boolean equippedByBlackMage(){
      return false;
  }

  public boolean equippedByWhiteMage(){
      return false;
  }
}
