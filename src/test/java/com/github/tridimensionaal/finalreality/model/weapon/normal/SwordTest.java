package com.github.tridimensionaal.finalreality.model.weapon.normal;


import com.github.tridimensionaal.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * A class that tests the class Sword
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see Sword
 */
class SwordTest extends AbstractWeaponTest{

  private IWeapon testSword;
  private IWeapon testSword1;
  private IWeapon testSword2;
  private IWeapon testSword3;
  private IWeapon testSword4;
  private IWeapon testSword5;
  private IWeapon testSword6;
  private IWeapon testSword7;
  private IWeapon testSword8;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testSword = new Sword(DAMAGE, WEIGHT);
    testSword1 = new Sword(DAMAGE, WEIGHT);
    testSword2 = new Bow(DAMAGE, WEIGHT);
    testSword3= new Sword(DAMAGE2, WEIGHT);
    testSword4 = new Sword(DAMAGE, WEIGHT2);
    testSword5 = new Bow(DAMAGE2, WEIGHT);
    testSword6 = new Bow(DAMAGE, WEIGHT2);
    testSword7 = new Sword(DAMAGE2, WEIGHT2);
    testSword8 = new Bow(DAMAGE2, WEIGHT2);
  }

  /**
   * Checks that the knife's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    checkConstruction(testSword,testSword1,testSword2,testSword3,testSword4,testSword5,testSword6,testSword7,testSword8);
  }
}
