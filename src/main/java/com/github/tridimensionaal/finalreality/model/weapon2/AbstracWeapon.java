package com.github.tridimensionaal.finalreality.model.weapon2;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public abstract class AbstractWeapon {

  protected final String name;
  protected final int damage;
  protected final int weight;
  protected final String type;

  public abstractWeapon(final String name, final int damage, final int weight,final String type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }

  protected String getName() {
    return name;
  }

  protected int getDamage() {
    return damage;
  }

  protected int getWeight() {
    return weight;
  }

  protected String getType() {
    return type;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Weapon)) {
      return false;
    }
    final Weapon weapon = (Weapon) o;
    return getDamage() == weapon.getDamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName()) &&
        getType() == weapon.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType());
  }
}
