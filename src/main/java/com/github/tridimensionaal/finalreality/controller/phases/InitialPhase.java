package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a initial phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class InitialPhase extends Phase{
    public InitialPhase(){
        this.namePhase = "Initial phase";
    }

    @Override
    public void toCreationPhase(){
        changePhase(new CreationPhase());
    }

}


