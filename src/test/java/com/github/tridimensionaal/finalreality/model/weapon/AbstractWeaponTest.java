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

  protected static final String STR  = "HOLA";

  protected void checkConstruction(
      //Original weapon
      final IWeapon weapon,
      //Same weapon
      final IWeapon weapon1,
      //Different name
      final IWeapon weapon2,
      //Different damage
      final IWeapon weapon3,
      //Different weight 
      final IWeapon weapon4,
      //Different name and damage
      final IWeapon weapon5,
      //Different name and weight
      final IWeapon weapon6,
      //Different damage and weight 
      final IWeapon weapon7,
      //All different
      final IWeapon weapon8) {

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
