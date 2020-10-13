package com.github.tridimensionaal.finalreality.model.weapon.normal;


import com.github.tridimensionaal.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Bow.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Bow
 */
class BowTest extends AbstractWeaponTest{
  private IWeapon testBow;
  private IWeapon testBow1;
  private IWeapon testBow2;
  private IWeapon testBow3;
  private IWeapon testBow4;
  private IWeapon testBow5;
  private IWeapon testBow6;
  private IWeapon testBow7;
  private IWeapon testBow8;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testBow = new Bow(DAMAGE, WEIGHT);
    testBow1 = new Bow(DAMAGE, WEIGHT);
    testBow2 = new Axe(DAMAGE, WEIGHT);
    testBow3= new Bow(DAMAGE2, WEIGHT);
    testBow4 = new Bow(DAMAGE, WEIGHT2);
    testBow5 = new Axe(DAMAGE2, WEIGHT);
    testBow6 = new Axe(DAMAGE, WEIGHT2);
    testBow7 = new Bow(DAMAGE2, WEIGHT2);
    testBow8 = new Axe(DAMAGE2, WEIGHT2);
  }

  /**
   * Checks that the bow's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    checkConstruction(testBow, testBow1,testBow2,testBow3,testBow4,testBow5,testBow6,testBow7,testBow8);
  }
}
