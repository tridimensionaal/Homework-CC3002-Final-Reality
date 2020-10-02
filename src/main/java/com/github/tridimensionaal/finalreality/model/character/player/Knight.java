package com.github.tridimensionaal.finalreality.model.character.player;


import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;

/**
 * A class that holds all the information of a single player's knight
 *
 * @author Matías Salim Seda Auil
 */
 
public class Knight extends PlayerCharacter{
    /**
     *  Creates a new knight.
     */
 

    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense, final String characterClass) {
    super(turnsQueue, name, health, defense, characterClass);
    }
}

