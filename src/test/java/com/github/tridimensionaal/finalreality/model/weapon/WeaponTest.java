package com.github.tridimensionaal.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.tridimensionaal.finalreality.model.weapon.normal.*;
import com.github.tridimensionaal.finalreality.model.weapon.magic.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  private static final int DAMAGE = 15;
  private static final int SPEED = 10;
  private static final int MAGICDAMAGE = 10;

  private IWeapon testAxe;
  private IWeapon testStaff;
  private IWeapon testSword;
  private IWeapon testBow;
  private IWeapon testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new Axe(DAMAGE, SPEED);
    testStaff = new Staff(DAMAGE, SPEED, MAGICDAMAGE);
    testSword = new Sword(DAMAGE, SPEED);
    testBow = new Bow(DAMAGE, SPEED);
    testKnife = new Knife(DAMAGE, SPEED);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Axe(DAMAGE, SPEED);
    var expectedStaff = new Staff(DAMAGE, SPEED, MAGICDAMAGE);
    var expectedSword = new Sword( DAMAGE, SPEED);
    var expectedBow = new Bow(DAMAGE, SPEED);
    var expectedKnife = new Knife(DAMAGE, SPEED);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
  }
}
