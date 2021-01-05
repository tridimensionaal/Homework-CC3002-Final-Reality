package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a final phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class FinalPhase extends Phase{
    public FinalPhase(){
        this.namePhase = "Final phase";
    }

    @Override
    public String getText() {
        if(controller.getWinner()){
            return "Congratulations!, you have won.";
        }
        else{
            return "Nice try but you have lost.";
        }
    }
}

