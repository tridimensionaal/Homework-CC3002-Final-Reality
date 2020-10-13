package com.github.tridimensionaal.finalreality.model.character.player.magic;

import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import com.github.tridimensionaal.finalreality.model.character.player.AbstractMagicPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;


/**
 * A class that holds all the information of a single white mage.
 *
 * @author Matías Salim Seda Auil
 */
 
public class WhiteMage extends AbstractMagicPlayerCharacter{

  /**
   * Creates a new white mage.
   *
   * {@inheritDoc}
   */
    
    public WhiteMage(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, final int health, final int defense, final int mana) {
    super(turnsQueue, name, health, defense, "WhiteMage",mana);
    }
}

