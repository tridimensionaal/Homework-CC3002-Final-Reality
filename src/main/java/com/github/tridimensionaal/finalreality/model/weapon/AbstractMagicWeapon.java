package com.github.tridimensionaal.finalreality.model.weapon;

import java.util.Objects;

/**
 * An abstract class that holds all the information of a magic weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public abstract class AbstractMagicWeapon extends AbstractWeapon implements IMagicWeapon{
  
  private final int magicDamage;

  /**
   * Creates a new abstract magic weapon.
   * 
   *
   * 
   * {@inheritDoc} 
   *
   * @param magicDamage
   *     the weapon's magic damage 
   */

  public AbstractMagicWeapon(final String name, final int damage, final int weight, final int magicDamage) {
    super(name,damage,weight);
    this.magicDamage= magicDamage;
  }

  @Override
  public int getMagicDamage() {
    return magicDamage;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IMagicWeapon)) {
      return false;
    }
    final IMagicWeapon weapon = (IMagicWeapon) o;
    final IWeapon weaponn = (IWeapon) o;
    return super.equals(weaponn) && getMagicDamage() == weapon.getMagicDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getMagicDamage());
  }
}
