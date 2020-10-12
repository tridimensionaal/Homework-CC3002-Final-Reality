package com.github.tridimensionaal.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.tridimensionaal.finalreality.model.weapon.normal.*;
import com.github.tridimensionaal.finalreality.model.weapon.magic.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  private static final int DAMAGE = 15;
  private static final int SPEED = 10;
  private static final int MAGICDAMAGE = 10;

  private static final int DAMAGE2 = 16;
  private static final int SPEED2 = 12;
  private static final int MAGICDAMAGE2 = 12;

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
    //Same object 
    assertEquals(testAxe, testAxe);
    assertEquals(testAxe.hashCode(), testAxe.hashCode());
    assertEquals(testStaff, testStaff);
    assertEquals(testStaff.hashCode(), testStaff.hashCode());
    assertEquals(testSword, testSword);
    assertEquals(testSword.hashCode(), testSword.hashCode());
    assertEquals(testBow, testBow);
    assertEquals(testBow.hashCode(), testBow.hashCode());
    assertEquals(testKnife, testKnife);
    assertEquals(testKnife.hashCode(), testKnife.hashCode());

    //Diferent class
    assertNotEquals(testAxe, testStaff);
    assertNotEquals(testAxe.hashCode(), testStaff.hashCode());
    assertNotEquals(testStaff, testAxe);
    assertNotEquals(testStaff.hashCode(), testAxe.hashCode());
 


    //All same
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

    //Different damage
    var expectedAxe2 = new Axe(DAMAGE2, SPEED);
    var expectedStaff2 = new Staff(DAMAGE2, SPEED, MAGICDAMAGE);
    var expectedSword2= new Sword( DAMAGE2, SPEED);
    var expectedBow2 = new Bow(DAMAGE2, SPEED);
    var expectedKnife2= new Knife(DAMAGE2, SPEED);

    assertNotEquals(expectedAxe2, testAxe);
    assertNotEquals(expectedAxe2.hashCode(), testAxe.hashCode());
    assertNotEquals(expectedStaff2, testStaff);
    assertNotEquals(expectedStaff2.hashCode(), testStaff.hashCode());
    assertNotEquals(expectedSword2, testSword);
    assertNotEquals(expectedSword2.hashCode(), testSword.hashCode());
    assertNotEquals(expectedBow2, testBow);
    assertNotEquals(expectedBow2.hashCode(), testBow.hashCode());
    assertNotEquals(expectedKnife2, testKnife);
    assertNotEquals(expectedKnife2.hashCode(), testKnife.hashCode());

    //Diferrent speed
    var expectedAxe3 = new Axe(DAMAGE, SPEED2);
    var expectedStaff3 = new Staff(DAMAGE, SPEED2, MAGICDAMAGE);
    var expectedSword3 = new Sword( DAMAGE, SPEED2);
    var expectedBow3 = new Bow(DAMAGE, SPEED2);
    var expectedKnife3 = new Knife(DAMAGE, SPEED2);

    assertNotEquals(expectedAxe3, testAxe);
    assertNotEquals(expectedAxe3.hashCode(), testAxe.hashCode());
    assertNotEquals(expectedStaff3, testStaff);
    assertNotEquals(expectedStaff3.hashCode(), testStaff.hashCode());
    assertNotEquals(expectedSword3, testSword);
    assertNotEquals(expectedSword3.hashCode(), testSword.hashCode());
    assertNotEquals(expectedBow3, testBow);
    assertNotEquals(expectedBow3.hashCode(), testBow.hashCode());
    assertNotEquals(expectedKnife3, testKnife);
    assertNotEquals(expectedKnife3.hashCode(), testKnife.hashCode());

    //All diferent 
    var expectedAxe4 = new Axe(DAMAGE2, SPEED2);
    var expectedStaff4 = new Staff(DAMAGE2, SPEED2, MAGICDAMAGE);
    var expectedSword4 = new Sword(DAMAGE2, SPEED2);
    var expectedBow4 = new Bow(DAMAGE2, SPEED2);
    var expectedKnife4 = new Knife(DAMAGE2, SPEED2);

    assertNotEquals(expectedAxe4, testAxe);
    assertNotEquals(expectedAxe4.hashCode(), testAxe.hashCode());
    assertNotEquals(expectedStaff4, testStaff);
    assertNotEquals(expectedStaff4.hashCode(), testStaff.hashCode());
    assertNotEquals(expectedSword4, testSword);
    assertNotEquals(expectedSword4.hashCode(), testSword.hashCode());
    assertNotEquals(expectedBow4, testBow);
    assertNotEquals(expectedBow4.hashCode(), testBow.hashCode());
    assertNotEquals(expectedKnife4, testKnife);
    assertNotEquals(expectedKnife4.hashCode(), testKnife.hashCode());

 



  }
}
