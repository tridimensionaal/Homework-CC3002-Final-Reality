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
  private IWeapon testAxe;
  private IWeapon testAxe1;
  private IWeapon testAxe2;
  private IWeapon testAxe3;
  private IWeapon testAxe4;
  private IWeapon testAxe5;
  private IWeapon testAxe6;
  private IWeapon testAxe7;
  private IWeapon testAxe8;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testAxe = new Axe(DAMAGE, WEIGHT);
    testAxe1 = new Axe(DAMAGE, WEIGHT);
    testAxe2 = new Bow(DAMAGE, WEIGHT);
    testAxe3= new Axe(DAMAGE2, WEIGHT);
    testAxe4 = new Axe(DAMAGE, WEIGHT2);
    testAxe5 = new Bow(DAMAGE2, WEIGHT);
    testAxe6 = new Bow(DAMAGE, WEIGHT2);
    testAxe7 = new Axe(DAMAGE2, WEIGHT2);
    testAxe8 = new Bow(DAMAGE2, WEIGHT2);
  }

  /**
   * Checks that the axe's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    checkConstruction(testAxe,testAxe1,testAxe2,testAxe3,testAxe4,testAxe5,testAxe6,testAxe7,testAxe8);
  }
}
