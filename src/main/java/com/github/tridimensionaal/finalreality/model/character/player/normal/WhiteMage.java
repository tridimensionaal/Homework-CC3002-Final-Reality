package com.github.tridimensionaal.finalreality.model.character.player.normal;

import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;


/**
 * A class that holds all the information of a single white mage.
 *
 * @author Matías Salim Seda Auil
 */
 
public class WhiteMage extends AbstractPlayerCharacter{

    /**
     * Creates a new white mage.
     * 
     * {@inheritDoc}
     */

    public WhiteMage(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense) {
        super(turnsQueue, name, health, defense, "WhiteMage");
    }
    
    @Override
    public void equipWeapon(IWeapon weapon) {
        if (weapon.equippedByWhiteMage()) {
            super.equipWeapon(weapon);
        }
    }
}

