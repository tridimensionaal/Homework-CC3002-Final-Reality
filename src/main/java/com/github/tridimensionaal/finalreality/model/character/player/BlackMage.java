package com.github.tridimensionaal.finalreality.model.character.player;

import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;

/**
 * A class that holds all the information of a single player's black mage.
 *
 * @author Matías Salim Seda Auil
 */
 
public class BlackMage extends PlayerCharacter{
    private final int mana;
    /**
     *  Creates a new white mage.
     *
     * @param mana
     *   the mage's mana.
     *
     */

    public BlackMage(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense, final String characterClass, final int mana) {
    super(turnsQueue, name, health, defense, characterClass);
    this.mana = mana;
    }
}
