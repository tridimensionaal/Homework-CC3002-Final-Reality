package com.github.tridimensionaal.finalreality.model.weapon;

import java.util.Objects;

/**
 * An abstract class that holds the common behaviour of all the  weapons in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public abstract class AbstractWeapon implements IWeapon {

  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a new abstract weapon.
   *
   * @param name
   *     the weapon's name
   * @param damage
   *     the weapon's damage
   * @param weight 
   *     the weapon's weight
   */

  protected AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IWeapon)) {
      return false;
    }
    final IWeapon weapon = (IWeapon) o;
    return getDamage() == weapon.getDamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName()); 
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight());
  }
}
