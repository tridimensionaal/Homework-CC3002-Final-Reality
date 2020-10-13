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


  protected void checkConstruction(
      //Original weapon 
      final IMagicWeapon weapon,
      //Same weapon
      final IMagicWeapon weapon1,
      //Different damage
      final IMagicWeapon weapon2,
      //Different weight 
      final IMagicWeapon weapon3,
      //Different magic damage
      final IMagicWeapon weapon4,
      //Different damage and weight
      final IMagicWeapon weapon5,
      //Different damage and magic damage
      final IMagicWeapon weapon6,
      //Different weight and magic damage
      final IMagicWeapon weapon7,
      //All Different
      final IMagicWeapon weapon8) {

    assertEquals(weapon, weapon);
    assertEquals(weapon.hashCode(), weapon.hashCode());

    assertEquals(weapon, weapon1);
    assertEquals(weapon.hashCode(), weapon1.hashCode());

    assertNotEquals(weapon, weapon2);
    assertNotEquals(weapon.hashCode(), weapon2.hashCode());

    assertNotEquals(weapon, weapon3);
    assertNotEquals(weapon.hashCode(), weapon3.hashCode());

    assertNotEquals(weapon, weapon4);
    assertNotEquals(weapon.hashCode(), weapon4.hashCode());

    assertNotEquals(weapon, weapon5);
    assertNotEquals(weapon.hashCode(), weapon5.hashCode());

    assertNotEquals(weapon, weapon6);
    assertNotEquals(weapon.hashCode(), weapon6.hashCode());

    assertNotEquals(weapon, weapon7);
    assertNotEquals(weapon.hashCode(), weapon7.hashCode());

    assertNotEquals(weapon, weapon8);
    assertNotEquals(weapon.hashCode(), weapon8.hashCode());

    assertNotEquals(weapon, weapon8);
    assertNotEquals(weapon.hashCode(), weapon8.hashCode());

    assertNotEquals(weapon, STR);
    assertNotEquals(weapon.hashCode(), STR.hashCode());

    assertNotEquals(STR, weapon);
    assertNotEquals(STR.hashCode(), weapon.hashCode());
 
      }
}
