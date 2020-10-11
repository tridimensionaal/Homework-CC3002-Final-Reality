package com.github.tridimensionaal.finalreality.model.character.player.normal;

import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.player.PlayerCharacter;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;


/**
 * A class that holds all the information of a single player's engineer.
 *
 * @author Matías Salim Seda Auil
 */
 
public class Engineer extends PlayerCharacter{
    /**
     *  Creates a new engineer.
     */
    
    public Engineer(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense) {
    super(turnsQueue, name, health, defense, "Engineer");
    }
}

