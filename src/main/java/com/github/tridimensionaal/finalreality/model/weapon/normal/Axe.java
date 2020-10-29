package com.github.tridimensionaal.finalreality.model.weapon.normal;

import com.github.tridimensionaal.finalreality.model.weapon.AbstractWeapon;

/**
 * A class that holds all the information of a single axe.
 *
 * @author Matías Salim Seda Auil
 */
 
public class Axe extends AbstractWeapon{

  /**
   * Creates a new Axe.
   *
   * {@inheritDoc}
   */

    public Axe( final int damage, final int weight) {
        super("Axe", damage, weight);
  }

  public boolean equippedByEngineer(){
      return true;
  }

  public boolean equippedByKnight(){
      return true;
  }

  public boolean equippedByThief(){
      return false;
  }

  public boolean equippedByBlackMage(){
      return false;
  }
  public boolean equippedByWhiteMage(){
      return false;
  }
}

