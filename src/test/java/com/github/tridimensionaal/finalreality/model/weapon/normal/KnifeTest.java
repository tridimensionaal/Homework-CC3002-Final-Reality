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

  private IWeapon testKnife;
  private IWeapon testKnife1;
  private IWeapon testKnife2;
  private IWeapon testKnife3;
  private IWeapon testKnife4;
  private IWeapon testKnife5;
  private IWeapon testKnife6;
  private IWeapon testKnife7;
  private IWeapon testKnife8;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testKnife = new Knife(DAMAGE, WEIGHT);
    testKnife1 = new Knife(DAMAGE, WEIGHT);
    testKnife2 = new Bow(DAMAGE, WEIGHT);
    testKnife3= new Knife(DAMAGE2, WEIGHT);
    testKnife4 = new Knife(DAMAGE, WEIGHT2);
    testKnife5 = new Bow(DAMAGE2, WEIGHT);
    testKnife6 = new Bow(DAMAGE, WEIGHT2);
    testKnife7 = new Knife(DAMAGE2, WEIGHT2);
    testKnife8 = new Bow(DAMAGE2, WEIGHT2);
  }

  /**
   * Checks that the knife's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    checkConstruction(testKnife, testKnife1,testKnife2,testKnife3,testKnife4,testKnife5,testKnife6,testKnife7,testKnife8);
  }
}
