package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a final phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class FinalPhase extends Phase{
    private final boolean winner;
    public FinalPhase(boolean winner){
        this.namePhase = "Final phase";
        this.winner = winner;
    }
}

