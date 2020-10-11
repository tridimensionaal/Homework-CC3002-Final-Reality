package com.github.tridimensionaal.finalreality.model.character.player;

import com.github.tridimensionaal.finalreality.model.character.AbstractCharacter;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public class PlayerCharacter extends AbstractCharacter {
  /**
   * Creates a new character.
   *
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param name
   *     the character's name
   * @param health 
   *     the character's health 
   * @param defense
   *     the character's health 
   * @param characterClass 
   *     the character's class
   * @param equippedWeapon
   *     the character's equipped weapon
   */
  private final String characterClass;
  private IWeapon equippedWeapon = null;

  protected PlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense, final String characterClass) {
      super(turnsQueue, name, health, defense);
      this.characterClass = characterClass;
  }

  public IWeapon getEquippedWeapon(){
      return equippedWeapon;
  }

  public void equipWeapon(IWeapon weapon) {
      this.equippedWeapon = weapon;
  }

  public String getCharacterClass(){
      return characterClass;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return super.equals(o) && getCharacterClass().equals(that.getCharacterClass());
  }
  @Override 
  public int hashCode(){
      return Objects.hash(getName(),getHealth(), getDefense());
  }


}


