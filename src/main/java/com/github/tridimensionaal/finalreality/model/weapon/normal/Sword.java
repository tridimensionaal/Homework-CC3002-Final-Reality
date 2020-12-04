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

  @Override
  public boolean equippedByEngineer(){
      return false;
  }

  @Override
  public boolean equippedByKnight(){
      return true;
  }

  @Override
  public boolean equippedByThief(){
      return true;
  }

  @Override
  public boolean equippedByBlackMage(){
      return false;
  }

  @Override
  public boolean equippedByWhiteMage(){
      return false;
  }
}
