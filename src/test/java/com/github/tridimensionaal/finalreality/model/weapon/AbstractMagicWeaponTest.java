package com.github.tridimensionaal.finalreality.model.weapon;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Abstract class containing the common tests for all the types of magic weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 * @see IMagicWeapon
 */
public abstract class AbstractMagicWeaponTest extends AbstractWeaponTest{

  protected final int MAGICDAMAGE = 15;
  protected static final int MAGICDAMAGE2 = 10;

  //Original magicWeaponTest 
  protected IMagicWeapon magicWeaponTest;
  //Same magicWeaponTest
  protected IMagicWeapon magicWeaponTest1;
  //Different damage
  protected IMagicWeapon magicWeaponTest2;
  //Different weight 
  protected IMagicWeapon magicWeaponTest3;
  //Different magic damage
  protected IMagicWeapon magicWeaponTest4;
  //Different damage and weight
  protected IMagicWeapon magicWeaponTest5;
  //Different damage and magic damage
  protected IMagicWeapon magicWeaponTest6;
  //Different weight and magic damage
  protected IMagicWeapon magicWeaponTest7;
  //All Different
  protected IMagicWeapon magicWeaponTest8;

  protected void checkConstruction(){
    assertEquals(magicWeaponTest, magicWeaponTest);
    assertEquals(magicWeaponTest.hashCode(), magicWeaponTest.hashCode());

    assertEquals(magicWeaponTest, magicWeaponTest1);
    assertEquals(magicWeaponTest.hashCode(), magicWeaponTest1.hashCode());

    assertNotEquals(magicWeaponTest, magicWeaponTest2);
    assertNotEquals(magicWeaponTest.hashCode(), magicWeaponTest2.hashCode());

    assertNotEquals(magicWeaponTest, magicWeaponTest3);
    assertNotEquals(magicWeaponTest.hashCode(), magicWeaponTest3.hashCode());

    assertNotEquals(magicWeaponTest, magicWeaponTest4);
    assertNotEquals(magicWeaponTest.hashCode(), magicWeaponTest4.hashCode());

    assertNotEquals(magicWeaponTest, magicWeaponTest5);
    assertNotEquals(magicWeaponTest.hashCode(), magicWeaponTest5.hashCode());

    assertNotEquals(magicWeaponTest, magicWeaponTest6);
    assertNotEquals(magicWeaponTest.hashCode(), magicWeaponTest6.hashCode());

    assertNotEquals(magicWeaponTest, magicWeaponTest7);
    assertNotEquals(magicWeaponTest.hashCode(), magicWeaponTest7.hashCode());

    assertNotEquals(magicWeaponTest, magicWeaponTest8);
    assertNotEquals(magicWeaponTest.hashCode(), magicWeaponTest8.hashCode());

    assertNotEquals(magicWeaponTest, magicWeaponTest8);
    assertNotEquals(magicWeaponTest.hashCode(), magicWeaponTest8.hashCode());

    assertNotEquals(magicWeaponTest, STR);
    assertNotEquals(magicWeaponTest.hashCode(), STR.hashCode());

    assertNotEquals(STR, magicWeaponTest);
    assertNotEquals(STR.hashCode(), magicWeaponTest.hashCode());

    super.checkConstruction();
  }
}
