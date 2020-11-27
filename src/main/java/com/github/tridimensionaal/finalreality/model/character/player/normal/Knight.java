package com.github.tridimensionaal.finalreality.model.character.player.normal;

import com.github.tridimensionaal.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;

/**
 * A class that holds all the information of a single knight
 *
 * @author Matías Salim Seda Auil
 */
 
public class Knight extends AbstractPlayerCharacter{
   /**
   * Creates a new Knight.
   *
   * {@inheritDoc}
   */
 
    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense) {
    super(turnsQueue, name, health, defense, "Knight");
    }

    @Override
    public void equipWeapon(IWeapon weapon){
        if (weapon.equippedByKnight()){
            super.equipWeapon(weapon);
        }
    }
}

