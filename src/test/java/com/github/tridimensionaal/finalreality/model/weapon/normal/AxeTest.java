package com.github.tridimensionaal.finalreality.model.weapon.normal;

import com.github.tridimensionaal.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Axe.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Axe
 */
class AxeTest extends AbstractWeaponTest{

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    weaponTest = new Axe(DAMAGE, WEIGHT);
    weaponTest1 = new Axe(DAMAGE, WEIGHT);
    weaponTest2 = new Bow(DAMAGE, WEIGHT);
    weaponTest3= new Axe(DAMAGE2, WEIGHT);
    weaponTest4 = new Axe(DAMAGE, WEIGHT2);
    weaponTest5 = new Bow(DAMAGE2, WEIGHT);
    weaponTest6 = new Bow(DAMAGE, WEIGHT2);
    weaponTest7 = new Axe(DAMAGE2, WEIGHT2);
    weaponTest8 = new Bow(DAMAGE2, WEIGHT2);
  }

  /**
   * Checks that the axe's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    super.checkConstruction();
  }
}
