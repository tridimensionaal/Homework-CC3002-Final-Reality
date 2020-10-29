package com.github.tridimensionaal.finalreality.model.character.player.normal;

import com.github.tridimensionaal.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;

/**
 * A class that holds all the information of a single thief.
 *
 * @author Matías Salim Seda Auil
 */
 
public class Thief extends AbstractPlayerCharacter {
  /**
   * Creates a new white mage.
   *
   * {@inheritDoc}
   */
 
    public Thief(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense) {
        super(turnsQueue, name, health, defense, "Thief");
    }
    public void equipWeapon(IWeapon weapon){
        if (weapon.equippedByThief()){
            super.equipWeapon(weapon);
        }
    }
}

