package com.github.tridimensionaal.finalreality.model.weapon.normal;

import com.github.tridimensionaal.finalreality.model.weapon.AbstractWeapon;

/**
 * A class that holds all the information of a single staff.
 *
 * @author Matías Salim Seda Auil
 */
 
public class Staff extends AbstractWeapon{

  /**
   * Creates a new staff.
   *
   * {@inheritDoc}
   */

    public Staff(final int damage, final int weight) {
        super("Staff", damage, weight);
  }

  @Override
  public boolean equippedByEngineer(){
      return false;
  }

  @Override
  public boolean equippedByKnight(){
      return false;
  }

  @Override
  public boolean equippedByThief(){
      return true;
  }

  @Override
  public boolean equippedByBlackMage(){
      return true;
  }

  @Override
  public boolean equippedByWhiteMage(){
      return true;
  }
}
