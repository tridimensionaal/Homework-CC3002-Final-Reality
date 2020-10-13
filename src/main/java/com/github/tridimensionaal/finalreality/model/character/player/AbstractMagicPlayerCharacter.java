package com.github.tridimensionaal.finalreality.model.character.player;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import java.util.Objects;


/**
 * A class that holds all the information of a single magic character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public abstract class AbstractMagicPlayerCharacter extends AbstractPlayerCharacter implements IMagicPlayerCharacter{
  private final int mana;

  /**
   * Creates a new magic player character.
   * 
   *
   * {@inheritDoc} 
   *
   * @param mana
   *     the character's mana 
   */

  public AbstractMagicPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense, final String characterClass, int mana) {
      super(turnsQueue, name, health, defense, characterClass);
      this.mana = mana;
  }

  /**
   * @return the character's mana
   */
  public int getMana(){
      return mana;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IMagicPlayerCharacter)) {
      return false;
    }
    final IMagicPlayerCharacter that = (IMagicPlayerCharacter) o;
    return super.equals(o) && getMana() == that.getMana();

  }

  @Override 
  public int hashCode(){
      return Objects.hash(getName(),getHealth(), getDefense(), getCharacterClass(), getMana());
  }

}
