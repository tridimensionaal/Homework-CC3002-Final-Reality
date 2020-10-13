package com.github.tridimensionaal.finalreality.model.character.player.normal;

import com.github.tridimensionaal.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;


/**
 * A class that holds all the information of a single engineer.
 *
 * @author Matías Salim Seda Auil
 */
 
public class Engineer extends AbstractPlayerCharacter {

  /**
   * Creates a new engineer.
   *
   * {@inheritDoc}
   */
 
    public Engineer(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense) {
    super(turnsQueue, name, health, defense, "Engineer");
    }
}

