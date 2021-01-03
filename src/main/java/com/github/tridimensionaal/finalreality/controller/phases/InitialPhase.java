package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a initial phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class InitialPhase extends Phase{
    public InitialPhase(){
        this.namePhase = "Initial phase";
        this.text = "Welcome to the Final Fantasy game.\nIn this game you are going to have a group characters to fight dangerous enemies.\nThe game basically consists of a sequence of turns. \nIn each turn one of your characters attack otherwise one of the enemies attack \nYou must kill every enemy to win the game. ";
    }

    @Override
    public void toCreationPhase(){
        changePhase(new CreationPhase());
    }

}


