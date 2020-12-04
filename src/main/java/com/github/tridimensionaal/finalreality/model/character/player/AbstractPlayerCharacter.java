package com.github.tridimensionaal.finalreality.model.character.player;

import com.github.tridimensionaal.finalreality.model.character.AbstractCharacter;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single abstract player character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter{

  private final String characterClass;
  private IWeapon equippedWeapon = null;

  /**
   * Creates a new player character.
   *
   * {@inheritDoc}
   *
   * @param characterClass 
   *     the character's class
   */

  public AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense, final String characterClass) {
      super(turnsQueue, name, health, defense);
      this.characterClass = characterClass;
  }

  @Override
  public IWeapon getEquippedWeapon(){
      return equippedWeapon;
  }

  @Override
  public void equipWeapon(IWeapon weapon) {
      if(this.isDead()) {
          return;
      }
      this.equippedWeapon = weapon;
  }

  @Override
  public String getCharacterClass(){
      return characterClass;
  }

  @Override
  public void attack(ICharacter character){
      if(this.equippedWeapon== null){
          return;
      }
      if (this.isDead()){
          return;
      }
      character.receiveDamage(this.getEquippedWeapon().getDamage());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof IPlayerCharacter)) {
      return false;
    }

    final IPlayerCharacter that = (IPlayerCharacter) o;
    return super.equals(o) && getCharacterClass().equals(that.getCharacterClass());
  }

  @Override 
  public int hashCode(){
      return Objects.hash(getName(),getHealth(), getDefense(), getCharacterClass());
  }

}


