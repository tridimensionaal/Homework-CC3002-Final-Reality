package com.github.tridimensionaal.finalreality.model.weapon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Abstract class containing the common tests for all the types of weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see IWeapon
 */
public abstract class AbstractWeaponTest{
  protected final int DAMAGE = 15;
  protected final int WEIGHT = 13;

  protected final int DAMAGE2 = 10;
  protected final int WEIGHT2 = 12;

  protected static final String STR  = "Hi";

  //Original weapon
  protected IWeapon weaponTest;
  //Same weapon
  protected IWeapon weaponTest1;
  //Different name
  protected IWeapon weaponTest2;
  //Different damage
  protected IWeapon weaponTest3;
  //Different weight
  protected IWeapon weaponTest4;
  //Different name and damage
  protected IWeapon weaponTest5;
  //Different name and weight
  protected IWeapon weaponTest6;
  //Different damage and weight
  protected IWeapon weaponTest7;
  //All different
  protected IWeapon weaponTest8;

  protected void checkConstruction(){
    assertEquals(weaponTest, weaponTest);
    assertEquals(weaponTest.hashCode(), weaponTest.hashCode());

    assertEquals(weaponTest, weaponTest1);
    assertEquals(weaponTest.hashCode(), weaponTest1.hashCode());

    assertNotEquals(weaponTest, weaponTest2);
    assertNotEquals(weaponTest.hashCode(), weaponTest2.hashCode());

    assertNotEquals(weaponTest, weaponTest3);
    assertNotEquals(weaponTest.hashCode(), weaponTest3.hashCode());

    assertNotEquals(weaponTest, weaponTest4);
    assertNotEquals(weaponTest.hashCode(), weaponTest4.hashCode());

    assertNotEquals(weaponTest, weaponTest5);
    assertNotEquals(weaponTest.hashCode(), weaponTest5.hashCode());

    assertNotEquals(weaponTest, weaponTest6);
    assertNotEquals(weaponTest.hashCode(), weaponTest6.hashCode());

    assertNotEquals(weaponTest, weaponTest7);
    assertNotEquals(weaponTest.hashCode(), weaponTest7.hashCode());

    assertNotEquals(weaponTest, weaponTest8);
    assertNotEquals(weaponTest.hashCode(), weaponTest8.hashCode());

    assertNotEquals(weaponTest, weaponTest8);
    assertNotEquals(weaponTest.hashCode(), weaponTest8.hashCode());

    assertNotEquals(weaponTest, STR);
    assertNotEquals(weaponTest.hashCode(), STR.hashCode());

    assertNotEquals(STR, weaponTest);
    assertNotEquals(STR.hashCode(), weaponTest.hashCode());
  }
}
