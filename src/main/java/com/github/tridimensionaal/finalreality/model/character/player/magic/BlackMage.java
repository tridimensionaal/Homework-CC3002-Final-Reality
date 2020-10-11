package com.github.tridimensionaal.finalreality.model.character.player.magic;

import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.player.MagicPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;

/**
 * A class that holds all the information of a single player's black mage.
 *
 * @author Matías Salim Seda Auil
 */
 
public class BlackMage extends MagicPlayerCharacter{
    /**
     *  Creates a new black mage.
     */

    public BlackMage(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense, final int mana) {
    super(turnsQueue, name, health, defense, "BlackMage", mana);
    }
}
