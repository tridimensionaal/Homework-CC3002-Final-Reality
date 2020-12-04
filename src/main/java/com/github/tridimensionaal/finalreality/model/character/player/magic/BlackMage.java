package com.github.tridimensionaal.finalreality.model.character.player.magic;

import com.github.tridimensionaal.finalreality.model.character.player.AbstractMagicPlayerCharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;

/**
 * A class that holds all the information of a black mage.
 *
 * @author Matías Salim Seda Auil
 */
 
public class BlackMage extends AbstractMagicPlayerCharacter {

  /**
   * Creates a new black mage.
   *
   * {@inheritDoc}
   */
 
  public BlackMage(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense, final int mana) {
      super(turnsQueue, name, health, defense, "BlackMage", mana);
  }

  @Override
  public void equipWeapon(IWeapon weapon){
      if (weapon.equippedByBlackMage()){
          super.equipWeapon(weapon);
      }
  }
}
