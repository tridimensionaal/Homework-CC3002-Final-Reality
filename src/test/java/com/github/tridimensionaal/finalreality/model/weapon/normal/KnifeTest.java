package com.github.tridimensionaal.finalreality.model.weapon.normal;


import com.github.tridimensionaal.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Knife.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Knife
 */
class KnifeTest extends AbstractWeaponTest{

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    weaponTest = new Knife(DAMAGE, WEIGHT);
    weaponTest1 = new Knife(DAMAGE, WEIGHT);
    weaponTest2 = new Bow(DAMAGE, WEIGHT);
    weaponTest3= new Knife(DAMAGE2, WEIGHT);
    weaponTest4 = new Knife(DAMAGE, WEIGHT2);
    weaponTest5 = new Bow(DAMAGE2, WEIGHT);
    weaponTest6 = new Bow(DAMAGE, WEIGHT2);
    weaponTest7 = new Knife(DAMAGE2, WEIGHT2);
    weaponTest8 = new Bow(DAMAGE2, WEIGHT2);
  }

  /**
   * Checks that the knife's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    super.checkConstruction();
  }
}
