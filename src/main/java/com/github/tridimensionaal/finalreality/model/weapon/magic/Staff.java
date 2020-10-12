package com.github.tridimensionaal.finalreality.model.weapon.magic;

import com.github.tridimensionaal.finalreality.model.weapon.MagicWeapon;

/**
 * A class that holds all the information of a single staff.
 *
 * @author Matías Salim Seda Auil
 */
 
public class Staff extends MagicWeapon{

  /**
   * Creates a new staff.
   *
   * {@inheritDoc}
   */

    public Staff(final int damage, final int weight, final int magicDamage) {
        super("Staff", damage, weight, magicDamage);
  }

}
