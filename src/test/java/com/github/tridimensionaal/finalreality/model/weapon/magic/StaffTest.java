package com.github.tridimensionaal.finalreality.model.weapon.magic;

import com.github.tridimensionaal.finalreality.model.weapon.*;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Bow;
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

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    weaponTest = new Staff(DAMAGE, WEIGHT,MAGICDAMAGE);
    weaponTest1 = new Staff(DAMAGE, WEIGHT, MAGICDAMAGE);
    weaponTest2 = new Bow(DAMAGE, WEIGHT);
    weaponTest3= new Staff(DAMAGE2, WEIGHT, MAGICDAMAGE);
    weaponTest4 = new Staff(DAMAGE, WEIGHT2,MAGICDAMAGE);
    weaponTest5 = new Bow(DAMAGE2, WEIGHT);
    weaponTest6 = new Bow(DAMAGE, WEIGHT2);
    weaponTest7 = new Staff(DAMAGE2, WEIGHT2, MAGICDAMAGE);
    weaponTest8 = new Bow(DAMAGE2, WEIGHT2);
 
    magicWeaponTest = new Staff(DAMAGE, WEIGHT,MAGICDAMAGE);
    magicWeaponTest1 = new Staff(DAMAGE, WEIGHT, MAGICDAMAGE);
    magicWeaponTest2 = new Staff(DAMAGE2, WEIGHT, MAGICDAMAGE);
    magicWeaponTest3 = new Staff(DAMAGE, WEIGHT2, MAGICDAMAGE);
    magicWeaponTest4 = new Staff(DAMAGE, WEIGHT, MAGICDAMAGE2);
    magicWeaponTest5 = new Staff(DAMAGE2, WEIGHT2, MAGICDAMAGE);
    magicWeaponTest6 = new Staff(DAMAGE2, WEIGHT, MAGICDAMAGE2);
    magicWeaponTest7 = new Staff(DAMAGE, WEIGHT2, MAGICDAMAGE2);
    magicWeaponTest8 = new Staff(DAMAGE2, WEIGHT2, MAGICDAMAGE2);


 }
   /**
   * Checks that the knife's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    super.checkConstruction();
  }
}
