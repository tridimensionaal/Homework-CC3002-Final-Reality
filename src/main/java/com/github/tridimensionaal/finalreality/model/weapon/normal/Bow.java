package com.github.tridimensionaal.finalreality.model.weapon.normal;


import com.github.tridimensionaal.finalreality.model.weapon.AbstractWeapon;


/**
 * A class that holds all the information of a single bow.
 *
 * @author Matías Salim Seda Auil
 */

public class Bow extends AbstractWeapon{

  /**
   * Creates a new bow.
   *
   * {@inheritDoc}
   */

    public Bow( final int damage, final int weight) {
        super("Bow", damage, weight );
  }

  public boolean equippedByEngineer(){
      return true;
  }

  public boolean equippedByKnight(){
      return false;
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

