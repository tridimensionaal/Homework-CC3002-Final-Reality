package com.github.tridimensionaal.finalreality.model.weapon.normal;

import com.github.tridimensionaal.finalreality.model.weapon.*;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Bow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Staff.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Staff
 */

class StaffTest extends AbstractWeaponTest{

  /**
   * Setup method.
   */
  @BeforeEach

  void setUp() {
    weaponTest = new Staff(DAMAGE, WEIGHT);
    weaponTest1 = new Staff(DAMAGE, WEIGHT);
    weaponTest2 = new Bow(DAMAGE, WEIGHT);
    weaponTest3= new Staff(DAMAGE2, WEIGHT);
    weaponTest4 = new Staff(DAMAGE, WEIGHT2);
    weaponTest5 = new Bow(DAMAGE2, WEIGHT);
    weaponTest6 = new Bow(DAMAGE, WEIGHT2);
    weaponTest7 = new Staff(DAMAGE2, WEIGHT2);
    weaponTest8 = new Bow(DAMAGE2, WEIGHT2);
 


 }
   /**
   * Checks that the staff's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    super.checkConstruction();
  }
}
