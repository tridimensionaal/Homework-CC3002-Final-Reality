package com.github.tridimensionaal.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a Magic weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public class MagicWeapon extends AbstractWeapon{

  private final int magicDamage;

  protected MagicWeapon(final String name, final int damage, final int weight, final int magicDamage) {
    super(name,damage,weight);
    this.magicDamage= magicDamage;
  }

  public int getMagicDamage() {
    return magicDamage;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MagicWeapon)) {
      return false;
    }
    final MagicWeapon weapon = (MagicWeapon) o;
    return super.equals(o) && getMagicDamage() == weapon.getMagicDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getMagicDamage());
  }
}
