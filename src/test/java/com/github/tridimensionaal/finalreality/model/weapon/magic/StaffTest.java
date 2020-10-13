package com.github.tridimensionaal.finalreality.model.weapon.magic;

import com.github.tridimensionaal.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Knife.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Staff
 */

class StaffTest extends AbstractMagicWeaponTest{
  private IMagicWeapon testStaff;
  private IMagicWeapon testStaff1;
  private IMagicWeapon testStaff2;
  private IMagicWeapon testStaff3;
  private IMagicWeapon testStaff4;
  private IMagicWeapon testStaff5;
  private IMagicWeapon testStaff6;
  private IMagicWeapon testStaff7;
  private IMagicWeapon testStaff8;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testStaff = new Staff(DAMAGE, WEIGHT,MAGICDAMAGE);
    testStaff1 = new Staff(DAMAGE, WEIGHT, MAGICDAMAGE);
    testStaff2 = new Staff(DAMAGE2, WEIGHT, MAGICDAMAGE);
    testStaff3 = new Staff(DAMAGE, WEIGHT2, MAGICDAMAGE);
    testStaff4 = new Staff(DAMAGE, WEIGHT, MAGICDAMAGE2);
    testStaff5 = new Staff(DAMAGE2, WEIGHT2, MAGICDAMAGE);
    testStaff6 = new Staff(DAMAGE2, WEIGHT, MAGICDAMAGE2);
    testStaff7 = new Staff(DAMAGE, WEIGHT2, MAGICDAMAGE2);
    testStaff8 = new Staff(DAMAGE2, WEIGHT2, MAGICDAMAGE2);

 }

   /**
   * Checks that the knife's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    checkConstruction(testStaff, testStaff1,testStaff2,testStaff3,testStaff4,testStaff5,testStaff6,testStaff7,testStaff8);

  }
}
